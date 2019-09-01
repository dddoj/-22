#include <bits/stdc++.h>
using namespace std;
 
int main() {
    int T;
    scanf("%d", &T);
 
    
    for(int tc=1; tc<=T; tc++) {
        int p;
        scanf("%d", &p);
        vector<int> num;
        for(int i=0; i<p; i++) {
            int x;
            scanf("%d",&x);
            num.push_back(x);
        }
 

        sort(num.begin(),num.end());
 
        int res;

        res = num.front() * num.back();
        printf("#%d %d\n", tc,res);
    }
    return 0;
}
