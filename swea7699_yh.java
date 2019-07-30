import java.util.*;
import java.io.*;
public class Solution{
	static int[][] map = new int[21][21];
	static int r,c;
	static boolean[] alphabet;
	static boolean [][] visited;
	static int ans;
	static int[] dy = {0,0,-1,1};
	static int[] dx = {1,-1,0,0};
	public static void solve(int x, int y, int cnt) {
		if(cnt>ans)
			ans = cnt;	
		for(int i=0;i<4;i++) {
			int a=x+dx[i]; int b =y+dy[i];	
			if(a>=0 && a<r && b>=0 && b<c && !visited[a][b] && !alphabet[map[a][b]]) {
				visited[a][b] = true;
				alphabet[map[a][b]] = true;
				solve(a,b,cnt+1);
				visited[a][b] = false;
				alphabet[map[a][b]] = false;
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			r = sc.nextInt();
			c = sc.nextInt();
			for(int i=0;i<r;i++) {
				String s= sc.next();
				for(int j=0;j<c;j++) {
					map[i][j] = s.charAt(j)-'A';
				}
			}
			visited = new boolean[21][21];
			alphabet = new boolean[27];
			visited[0][0] = true;
			alphabet[map[0][0]] = true;
			ans = 1;
			solve(0,0,1);
			System.out.println("#"+tc+" "+ans);
		}
		sc.close();
	}

}