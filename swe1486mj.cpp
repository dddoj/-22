#include <bits/stdc++.h>
using namespace std;


int n,b,sol,tc;
int a[21];

void dfs(int cnt,int height) {
    if(cnt == n) {
        if(height >= b) 
            sol = min(sol,height);

            return;
    }

    dfs(cnt+1, height + a[cnt]);
    dfs(cnt+1, height);
}

int main() {
    cin >> tc;

    for (int k=1; k <=tc; k++) {
        cin >> n >> b;

        for(int i = 0; i <n; i++){
            cin >> a[i];
        }

       dfs(0,0);

       cout << "#" << k << "" << sol-b << "\n";
          }

          return 0;
}