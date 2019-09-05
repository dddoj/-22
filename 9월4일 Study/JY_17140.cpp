#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// maxRow    : 최대 행 길이
// maxColumn : 최대 열 길이
// A         : 입력 된 이차원 배열
// transA    : transpose된 A 배열
// cntMatrix : 숫자, 수의 등장 횟수가 담긴 2차원 vector
int maxRow, maxColumn = 0;
int A[101][101] = { 0 };
int transA[101][101] = { 0 };
vector<vector<int>> cntMatrix;

// 배열 값들을 0으로 초기화
void init(int (*matrix)[101], int line)
{
    for(int i=0; i<100; i++)
    {
        matrix[line][i] = 0;
    }
}

// maxRow, maxColumn 값을 구함
int setMax(int (*matrix)[101])
{
    int maxVal = -1;

    for(int i=0; i<100; i++)
    {
        for(int j=0; j<100; j++)
        {
            if(matrix[i][j] == 0)
            {
                maxVal = max(maxVal, j);
                break;
            }
        }
    }
    return maxVal;
}

// 정렬 (등장 횟수가 적은 순으로, 그 횟수가 같다면 수의 크기가 더 작은 순으로)
bool sortCnt(vector<int> &v1, vector<int> &v2)
{
    if (v1[1] < v2[1])
        return true;
    else if (v1[1] == v2[1])
        return v1[0] < v2[0];
    else return false;
}
void sorting(int (*matrix)[101], int line)
{
    int size = 0;

    init(matrix, line);
    sort(cntMatrix.begin(), cntMatrix.end(), sortCnt);

    // 행, 열의 크기가 100을 넘어가지 않도록 제한
    if(cntMatrix.size() > 50)
        size = 50;
    else
        size = (int)cntMatrix.size();

    for (int i=0; i<size; i++)
    {
        matrix[line][i * 2]     = cntMatrix[i][0];
        matrix[line][i * 2 + 1] = cntMatrix[i][1];
    }
}

// cntMatrix 내에 동일한 원소가 존재하는가? (존재하면 해당 index 반환, 없으면 -1 반환)
int checking(int input)
{
    int index = -1;

    for(int i=0; i<cntMatrix.size(); i++)
    {
        if(cntMatrix[i][0] == input)
        {
            index = i;
            break;
        }
    }
    return index;
}

// Row <-> Column (transpose)
void transpose(int (*m1)[101], int (*m2)[101])
{
    for(int i=0; i<100; i++)
    {
        for(int j=0; j<100; j++)
        {
            m2[i][j] = m1[j][i];
        }
    }
}

// 연산 (Row 연산, Column연산)
void operate(int (*matrix)[101])
{
    for(int i=0; i<100; i++)
    {
        for(int j=0; j<100; j++)
        {
            if(matrix[i][j] != 0)
            {
                vector<int> info;
                int idx = checking(matrix[i][j]);

                // 현재 값이 처음 등장하는 값이라면 배열에 값 추가 및 cnt = 1
                if (idx == -1)
                {
                    info.push_back(matrix[i][j]);
                    info.push_back(1);
                    cntMatrix.push_back(info);
                }
                    // 현재 값이 이차원 배열 내에 이미 존재했던 값이라면 cnt = cnt+1
                else
                {
                    cntMatrix[idx][1]++;
                }
            }
        }
        sorting(matrix, i);
        cntMatrix.clear();
    }
}

int main()
{
    int r, c, k;
    int input;
    int answer = 0;

    std::cin >> r >> c >> k;

    // 이차원 배열 입력 받음
    for(int i=0; i<3; i++)
    {
        for(int j=0; j<3; j++)
        {
            std::cin >> A[i][j];
        }
    }
    maxRow = maxColumn = 3;

    // A[r][c]가 k값이 나올 때까지 반복 및 count
    while(A[r-1][c-1] != k)
    {
        // 행 길이 >= 열 길이라면 R연산 후 maxColumn 값 구함
        if (maxRow >= maxColumn)
        {
            operate(A);
            maxColumn = setMax(A);
        }

            // 행 길이 < 열 길이라면 C연산 후 maxRow 값 구함
            // 이때 동일한 연산을 수행하는 함수를 사용하기 위해, C연산은 이차원 배열을 transpose 후 연산
        else
        {
            transpose(A, transA);
            operate(transA);
            maxRow = setMax(transA);
            transpose(transA, A);
        }

        answer++;

        if(answer > 100)
        {
            answer = -1;
            break;
        }
    }
    std::cout << answer << endl;
}
