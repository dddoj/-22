import java.util.*;
import java.io.*;
public class Solution{
	static int n,m,k;
	static int ans;
	static int [][] visit;
	static int[][] cell;
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,-1,1};
	
	public static void solve(int t) {
		//m 시간후 미생물 총합 계산
		if (t == m) {
			for(int i=0;i<k;i++) {
				if(cell[i][0]!=-1)
					ans+=cell[i][2];
			}
			return;
		}
		//visit array 군집 위치에 군집# 넣어서 군집이 만나는지 안만나는지 확인하기 위해 visit reset.
		for(int[] row:visit)
			Arrays.fill(row, -1);
		//군집 이동하여 위치, 미생물수 저장. cell[i][4] = 군집이 합쳐질때 미생물수 비교위해.
		for(int i=0;i<k;i++) {
			//군집이 합쳐지거나 미생물수가 0일때 cell[i][0] = -1로 표시하여 계산 안함.
			if(cell[i][0] !=-1) {
				if(cell[i][3] == 1) {
					if(cell[i][0] == 1) {
						cell[i][2] = cell[i][2]/2; cell[i][3] = 2; 
					}
					cell[i][4] = cell[i][2];
					cell[i][0] -=1;
				}
				else if(cell[i][3] == 2) {
					if(cell[i][0] == n-2) {
						cell[i][2] = cell[i][2]/2; cell[i][3] =1; 
					}
					cell[i][4] =cell[i][2];
					cell[i][0] +=1;
				}
				else if(cell[i][3] == 3) {
					if(cell[i][1]==1) {
						cell[i][2] = cell[i][2]/2; cell[i][3] = 4; 
					}
					cell[i][4] =cell[i][2];
					cell[i][1]-=1;
				}
				else {
					if(cell[i][1] == n-2) {
						cell[i][2] = cell[i][2]/2; cell[i][3] =3; 
					}
					cell[i][4] =cell[i][2];
					cell[i][1]+=1;
				}
				//미생물 수가 0이되면 필요없어지므로.
				if(cell[i][2] == 0) {
					cell[i][0] = -1;
				}
				//군집이 합쳐질경우 계산.
				int x = cell[i][0]; int y= cell[i][1];
				if(cell[i][0] !=-1) {
					if(visit[x][y] != -1) {
						if(cell[visit[x][y]][4]<cell[i][4]) {
							cell[i][2]+=cell[visit[x][y]][2];
							cell[visit[x][y]][0] = -1;
							visit[x][y] = i;
						}
						else {
							cell[visit[x][y]][2]+=cell[i][2];
							cell[i][0] = -1;
						}
					}
					else
						visit[x][y] = i;
				}
			}
		}
		//다음 시간 재귀.
		solve(t+1);
	}
	public static void main(String[] arg) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1; tc<=t;tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			visit = new int[n+1][n+1];
			cell = new int [k][5];
			for(int i=0;i<k;i++) { 
				for(int j=0;j<4;j++)
					cell[i][j] = sc.nextInt();
			}
			ans = 0;
			solve(0);
			System.out.println("#"+tc+" "+ans);
		}
		sc.close();
	}
}