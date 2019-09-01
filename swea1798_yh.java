import java.util.*;
import java.io.*;

public class Solution{
	static int n;
	static int m;
	static int time[][] = new int[36][36];
	static int play[][] = new int[36][4];
	static int hotel[] = new int[36];
	static int hotelindex[] = new int[36];
	static int airport;
	static int airportmin;
	static int airportindex;
	static int hotelcnt;
	static int playcnt;
	static int visited[] = new int[36];
	static int visitcnt;
	static boolean check[] = new boolean [36];
	static int ans;
	static int result[] = new int[36];
	static int resultcnt;
	
	public static void solve(int cur, int s, int t, int d) {
		if(d == m) {
			if(s>ans) {
				ans = s;
				resultcnt = visitcnt;
				for(int i=0;i<visitcnt;i++)
					result[i] = visited[i];
				result[resultcnt++] = airport;
			}
			return;
		}
		int temp = 0;
		for(int i=0;i<playcnt;i++) {
			if(!check[i]) {
				if(d<m-1) {
					temp = time[cur][play[i][0]]+play[i][1]+time[play[i][0]][play[i][3]];
				}
				else if(d==m-1)
					temp = time[cur][play[i][0]]+play[i][1]+time[play[i][0]][airport];
				if(t+temp>540)
					continue;
				else {
					if(d<m-1)
						temp -=time[play[i][0]][play[i][3]];
					else if(d==m-1)
						temp -=time[play[i][0]][airport];
					check[i] = true;
					visited[visitcnt++] = play[i][0];
					solve(play[i][0],s+play[i][2],t+temp,d);
					check[i] = false;
					visitcnt--;
				}
			}
		}
		if(d!=m-1) {
			if(cur == airport) {
				visited[visitcnt++] = airportindex;
				solve(airportindex,s,0,d+1);
				visitcnt--;
			}
			else {
				visited[visitcnt++] = hotelindex[cur];
				solve(hotelindex[cur],s,0,d+1);
				visitcnt--;
			}
		}
		else {
			solve(airport,s,0,m);

		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			for(int i=1;i<n;i++) 
				for(int j=i+1;j<=n;j++) {
					time[i][j] = sc.nextInt();
					time[j][i] = time[i][j];
				}
			
			playcnt = 0;
			hotelcnt = 0;
			for(int i=1;i<=n;i++) {
				String s = sc.next();
				if (s.equals("A"))
					airport = i;
				else if(s.equals("P")){
					play[playcnt][0] = i;
					play[playcnt][1] = sc.nextInt();
					play[playcnt++][2] = sc.nextInt();
				}
				else
					hotel[hotelcnt++]=i;
			}
			for(int i=0;i<playcnt;i++) {
				int min =Integer.MAX_VALUE;
				int index = 0;
				airportmin = Integer.MAX_VALUE;
				for(int j=0;j<hotelcnt;j++) {
					if(time[airport][hotel[j]]<airportmin) {
						airportmin=time[airport][hotel[j]];
						airportindex = hotel[j];
					}
					if(time[play[i][0]][hotel[j]]<min) {
						index = hotel[j];
						min = time[play[i][0]][hotel[j]];
					}
				}
				play[i][3] = index;
				hotelindex[play[i][0]] = play[i][3];
			}
			ans = 0;
			visitcnt = 0;
			solve(airport,0,0,0);
			System.out.print("#"+tc+" "+ans);
			if(ans!=0)
				for(int i=0;i<resultcnt;i++)
					System.out.print(" "+result[i]);
			System.out.println();
					
		}
		sc.close();
	}
}


