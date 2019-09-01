#include <iostream>
#include <vector>
#include <math.h>

using namespace std;
vector<int> peopleH;
int minHeight = 0;

void makeTower(int here, int towerH, int num, int shelfH)
{
    if (here > num)
        return;

    if (towerH >= shelfH)
    {
        minHeight = min(minHeight, towerH);
        return;
    }

    makeTower(here+1, towerH, num, shelfH);
    makeTower(here+1, towerH + peopleH[here], num, shelfH);
}

int main()
{
    int T = 0, N =0, B = 0, H = 0;

    std::cin >> T;

    for(int i=0; i<T; i++)
    {
        minHeight = 0;
        peopleH.clear();
        std::cin >> N >> B;

        for(int j=0; j<N; j++)
        {
            std::cin >> H;
            peopleH.push_back(H);
            minHeight += peopleH[j];
        }
        makeTower(0, 0, N, B);

        std::cout << "#" << i+1 << " " << (minHeight-B) << endl;
    }
}