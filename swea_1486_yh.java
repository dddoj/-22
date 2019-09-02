import java.util.*;
import java.io.*;
public class Solution{
	static int n,b;
	static int map[];
	static int ans;
	public static void solve(int sum, int index) {
		if(sum>=b) {
			ans = ans>=(sum-b)?(sum-b):ans;
		}
		if(index==n)
			return;
		solve(sum,index+1);
		solve(sum+map[index],index+1);	
	}
	public static void main(String[] arg) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1; tc<=t;tc++) {
			n = sc.nextInt();
			b = sc.nextInt();
			map = new int[n];
			ans = b;
			for(int i=0;i<n;i++) {
				map[i] = sc.nextInt();
			}
			solve(0,0);
			System.out.println("#"+tc+" "+ans);
		}
		sc.close();
	}
}