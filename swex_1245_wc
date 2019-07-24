package day0723;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1245 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] x = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < x.length; i++) {
				x[i] = Integer.parseInt(st.nextToken());//좌표값
			}
			
			int[] m = new int[N];
			
			for (int i = 0; i < m.length; i++) {
				m[i] = Integer.parseInt(st.nextToken());//질량
			}
			
			System.out.print("#"+tc+" ");
			//binary search 한다.
			for (int i = 0; i < N-1; i++) {
				double l = x[i];	//left
				double r = x[i+1];	//right
				double ans = 0;
				for(int k = 0; k < 50; k++) {
					double mid = (l + r) / 2;
					double s = 0;
					for(int j = 0; j <= i; j++)
						s += m[j] / ((mid - x[j]) * (mid - x[j]));
					for (int j = i + 1; j < N; j++) 
	                    s -= m[j] / ((mid - x[j]) * (mid - x[j]));
					if(s > 0) {
						l = mid;
					}
					else {
						ans = mid;
						r = mid;
					}
				}
				System.out.printf("%.10f ",Math.round(ans*10000000000.0)/10000000000.0);
			}
			System.out.println();
		}//end of testCase
	}//end of main
}//end of class
