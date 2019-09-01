package blank;

import java.util.*;
import java.io.*;

public class Solution{
	static int n;
	static int[] d;
	static int[] w;
	
	//binary search를 통해 균형점 찾기 
	public static void solve() {
		for(int k=0;k<n-1;k++) {
			double left = d[k]; double right = d[k+1];
			double leftsum,rightsum;
			int cnt = 0;
			while(cnt<=100) {
				double mid = (right+left)/2;
				leftsum = 0.0;
				rightsum = 0.0;
				for (int i=0;i<=k;i++) {
					double dist = mid - d[i];
					leftsum += (w[i]/(dist*dist));
				}
				for(int j=k+1;j<n;j++) {
					double dis = d[j] - mid;
					rightsum += (w[j]/(dis*dis));
				}
				double diff = leftsum - rightsum;
				if(diff==0 ||Math.abs(diff)<1E-13 || cnt==100) {
					System.out.print(" ");
					System.out.printf("%.10f",mid);
					break;
				}
				if(diff>0)
					left = mid;
				else
					right = mid;
				cnt++;
			}
		}
		
		System.out.println();
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			n = sc.nextInt();
			d = new int[n+1];
			w = new int[n+1];
			for(int i=0;i<n;i++) {
				d[i] = sc.nextInt();
			}
			for(int j=0;j<n;j++) {
				w[j] = sc.nextInt();
			}
			
			System.out.print("#"+tc);
			solve();
		}
		sc.close();
	}
}


