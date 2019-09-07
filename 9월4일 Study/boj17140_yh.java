import java.util.*;
import java.io.*;
public class Main{
	static int r,c,k;
	static int[][] map;
	static int ans;
	//rn = 행의 개수, cn = 열의 개수
	public static void solve(int n, int rn, int cn) {
		//최소시간>=100 
		if(n>100) {
			ans = -1;
			return;
		}
		//A[r][c] == k
		if(map[r][c] == k) {
			ans = n;
			return;
		}
		//row : R연산 -행의 수는 그대로, 변한 열의 수 return, column: C연산- 변한 행의 수 return
		if(rn>=cn)
			cn = row(rn, cn);
		else
			rn = column(rn, cn);
		//다음 시간 재귀		
		solve(n+1,rn,cn);	 
	}
	public static int row(int rn, int cn) {
		int num = 0;
		//각각의 수가 몇번 나왔는지 rmap에 저장
		int[][] rmap = new int[101][101];
		for(int i=0;i<rn;i++) {
			for(int j=0;j<cn;j++) {
				rmap[i][map[i][j]]++;
			}
		}
		//map reset. rmap에 자장된 결과를 map에 넣음.
		map = new int[101][101];
		for(int i=0;i<rn;i++) {
			int index = 0;
			//행의 크기가 100이 넘어가는지 확인
			for(int l=1;l<=cn;l++) {
				if(index>98)
					break;
				for(int k=1;k<=100;k++) {
					if(index>98)
						break;
					if(rmap[i][k] == l) {
						map[i][index++] = k;
						map[i][index++] = l;
					}
				}		
			}
			//행의 크기 update	
			num = num<index? index:num;
		}
		return num;
	}
	public static int column(int rn, int cn) {
		int num = 0;
		int[][] cmap = new int[101][101];
		for(int i=0;i<cn;i++)
			for(int j=0;j<rn;j++)
				cmap[map[j][i]][i]++;
		map = new int[101][101];
		for(int i=0;i<cn;i++) {
			int index = 0;
			for(int l=1;l<=rn;l++) {
				if(index>98)
					break;
				for(int k=1;k<=100;k++) {
					if(index>98)
						break;
					if(cmap[k][i]==l) {
						map[index++][i] = k;
						map[index++][i] = l;
					}
				}
			}
			num = num<index? index:num;
		}
		return num;
	}
	
	public static void main(String[] arg) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt()-1;
		c = sc.nextInt()-1;
		k = sc.nextInt();
		map = new int[101][101];
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				map[i][j] = sc.nextInt();
		solve(0,3,3);
		System.out.println(ans);
		sc.close();
	}
}