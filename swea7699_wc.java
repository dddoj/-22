import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static char[][] map;
	public static int ans;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
  
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
    
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			map = new char[R][C];
			boolean[] checkSpelling = new boolean[26];//중복 방문 체크 변수
			int cnt = 1;
			ans = 0;
			
			for (int i = 0; i < R; i++) {
				String str = br.readLine().trim();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			checkSpelling[map[0][0] - 'A'] = true;
			dfs(checkSpelling, cnt, 0, 0);
			
			System.out.println("#"+tc+" "+ans);
			
		}//end of testCase
		
	}//end of main
	
	public static void dfs(boolean[] check, int cnt, int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {//범위 체크
				if(!check[map[nx][ny] - 'A']) {//중복되지 않으면
					cnt++;
					check[map[nx][ny] - 'A'] = true;
					dfs(check, cnt, nx, ny);
					cnt--;
					check[map[nx][ny] - 'A'] = false;
				}
			}
		}
		if(cnt > ans) {
			ans = cnt;
		}
	}
}//end of class
