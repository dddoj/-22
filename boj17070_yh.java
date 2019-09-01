import java.util.*;
import java.io.*;

//각각의 위치에서 이동가능한 다음의 모양 체크 후 다음 위치 재귀
public class Main{
	static int map[][];
	static int n;
	static int ans;
	
	public static void solve(int x, int y, int d) {
		if(x==n-1 && y==n-1) {
			ans+=1;
			return;
		}
		if(d==1) {
			if(one(x,y))
				solve(x+1,y,1);
			if(three(x,y))
				solve(x+1,y+1,3);
		}
		else if(d==2) {
			if(two(x,y))
				solve(x,y+1,2);
			if(three(x,y))
				solve(x+1,y+1,3);
		}
		else {
			if(one(x,y))
				solve(x+1,y,1);
			if(two(x,y))
				solve(x,y+1,2);
			if(three(x,y))
				solve(x+1,y+1,3);
			
		}
	}
	public static boolean one(int x, int y) {
		if(x+1<n && map[x+1][y]==0)
			return true;
		return false;
	}
	public static boolean two(int x, int y) {
		if(y+1<n && map[x][y+1]==0)
			return true;
		return false;
	}
	public static boolean three(int x, int y) {
		if(x+1<n && y+1<n)
			if(map[x+1][y]==0 && map[x][y+1]==0 && map[x+1][y+1]==0)
				return true;
		return false;
	}


	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n+1][n+1];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				map[j][i] = sc.nextInt();
		ans = 0;
		solve(1,0,1);
		System.out.println(ans);
		sc.close();
	}
}