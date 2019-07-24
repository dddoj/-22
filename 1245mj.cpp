#include <bits/stdc++.h>
using namespace std;

//자성체
struct mats
{
	int x;
	int weight;
};


int solution(struct mats material[], int N)
{
	for (int i = 0; i < N - 1; i++)
	{
		//현 자성체의 위치
		double left_F, right_F;
		double left = material[i].x, right = material[i + 1].x, ans = 0;

		//이 안에 자성체의 x값이 존재해야함.
		while (1)
		{
			double mid = (left + right) / 2;
			left_F = 0.0; right_F = 0.0;

			//물체와 왼쪽 자성체들의 인력 합
			for (int j = 0; j <= i; j++) {
				double d = (mid - material[j].x);
				left_F += (material[j].weight / (d*d));
			}

			//물체와 오른쪽 자성체들의 인력 합
			for (int j = i + 1; j < N; j++) {
				double d = (mid - material[j].x);
				right_F += (material[j].weight / (d*d));
			}

			double res = left_F - right_F;

			//각 좌표의 오차가 1e-12 이하여야하고,
			//오차가 더 크더라도, 양 옆의 인력이 같으면 그 곳이 균형점!
			if ((abs(right - left) <= (1e-12)) || (res == 0)) {
				printf("%.10f ", mid);
				break;
			}

			if (res > 0)		//왼쪽이 더 큼.
				left = mid;
			else if (res < 0) //오른쪽이 더 큼.
				right = mid;
		}
	}
	std::cout << endl;
	return 0;
}

int main()
{
	int testCase, N;

	cin >> testCase;
	for (int test = 1; test <= testCase; test++)
	{
		cin >> N;

		struct mats material[10];
		for (int j = 0; j < N; j++)
			cin >> material[j].x;

		for (int j = 0; j < N; j++)
			cin >> material[j].weight;

		std::cout << "#" << test << " ";
		solution(material, N);
	}
	return 0;
}


