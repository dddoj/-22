import java.util.*;
import java.io.*;
public class Solution{
	static int n,k;
	static int map[];
	static int ans;
	static int diff[];
	public static void solve() {
		if(n<=k) {
			ans = 0;
			return;
		}
		diff = new int[n];
		for(int i=0;i<n-1;i++) 
			diff[i] = map[i+1]-map[i];
		Arrays.sort(diff);
		ans = 0;
		for(int j = 0;j<n-k+1;j++)
			ans +=diff[j];	
	}
	public static void main(String[] arg) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			k = sc.nextInt();
			map = new int[n+1];
			for(int i=0;i<n;i++)
				map[i] = sc.nextInt();
			solve();
			System.out.println("#"+t+" "+ans);
		}
		sc.close();
	}
}