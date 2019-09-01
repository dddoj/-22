#include <cstdio>
#include <iostream>

using namespace std;
int** map;
int N;
int cnt = 0;

void dfs(int x, int y, int state) {
	if (x == N && y == N) {//마지막점에 도달하면 cnt++
		cnt++;
		return;
	}
	if (state == 0) {//가로
		//오른쪽
		if (y + 1 <= N && map[x][y+1] == 0) {
			dfs(x, y + 1, 0);
		}
		//대각선
		if (x + 1 <= N && y + 1 <= N && map[x + 1][y + 1] == 0 && map[x][y + 1] == 0 && map[x + 1][y] == 0) {
			dfs(x + 1, y + 1, 1);
		}
	}
	else if (state == 1) {//대각선
		//오른쪽
		if (y + 1 <= N && map[x][y + 1] == 0) {
			dfs(x, y + 1, 0);
		}
		//대각선
		if (x + 1 <= N && y + 1 <= N && map[x + 1][y + 1] == 0 && map[x][y + 1] == 0 && map[x + 1][y] == 0) {
			dfs(x + 1, y + 1, 1);
		}
		//아래
		if (x + 1 <= N && map[x + 1][y] == 0) {
			dfs(x + 1, y, 2);
		}
	}
	else {
		//대각선
		if (x + 1 <= N && y + 1 <= N && map[x + 1][y + 1] == 0 && map[x][y + 1] == 0 && map[x + 1][y] == 0) {
			dfs(x + 1, y + 1, 1);
		}
		//아래
		if (x + 1 <= N && map[x + 1][y] == 0) {
			dfs(x + 1, y, 2);
		}
	}
}

int main() {
	scanf("%d", &N);// 3 <= N <= 16

	//동적할당 N+1 * N+1 행렬 (1,1)부터 시작되므로
	map = new int*[N + 1];
	for (int i = 0; i < N + 1; ++i) {
		map[i] = new int[N + 1];
	}

	//집 입력받기
	for (int i = 1; i < N + 1; ++i) {
		for (int j = 1; j < N + 1; ++j) {
			scanf("%d", &map[i][j]);
		}
	}
	int state = 0;//파이프의 현재 상태 : 0=가로, 1=대각선, 2=아래
	dfs(1, 2, state);

	printf("%d\n", cnt);

	return 0;
}
