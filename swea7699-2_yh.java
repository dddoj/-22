import java.util.*;
import java.io.*;

public class Solution {
	static int r, c;
	static int[][] map;
	static int[] dx = {1,0,0,-1};
	static int[] dy = {0,-1,1,0};
	static int ans;
	public static void solve(int x,int y,int k, int cnt) {
		if(cnt>ans)
			ans = cnt;
		if(cnt==26)
			return;
		for(int i=0;i<4;i++) {
			int a = x+dx[i]; int b = y+dy[i];
			if(a<0 || a>=r || b<0 ||b>=c)
                continue;
            if ((map[a][b]&k) == 0) {
				solve(a,b,(map[a][b]|k),cnt+1);
			}
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			r = sc.nextInt();
			c = sc.nextInt();
            map = new int[r][c];
			for(int i=0;i<r;i++) {
				String s = sc.next();
				for(int j=0;j<c;j++) {
					map[i][j] = s.charAt(j)-'A';
					map[i][j] = 1 << map[i][j];
				}
			}
			ans = 1;
			solve(0,0,map[0][0],1);
			System.out.println("#"+tc+" "+ans);
			
		}
       
        sc.close();

        
	}

}