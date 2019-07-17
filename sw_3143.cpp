//가장 빠른 문자열 타이핑 
#include <bits/stdc++.h>

using namespace std;

int main()
{
     int T;
     cin >> T;

     for(int i=1; i<=T; i++)
     { 
         string a,b;
         cin >>a>> b;

          int a_s = a.size();
          int b_s = b.size();

          int total=0;

          for( int j = 0; j < a_s; j++ )
          {
               if( a[j]==b[0] ) 
               {
                    for(int k=1; k < b_s; k++)
                    {
                         if(a[j+k]!=b[k])

                         break;
                          if (k==b_s-1) j+=b_s-1;
                    }
               }
               
               total++;
          }

          cout << "#" << i << " " << total << endl;
     }
}
