package day0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_7829 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int P = Integer.parseInt(br.readLine().trim());
			
			int[] yaksu = new int[P];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < P; i++) {
				yaksu[i] = Integer.parseInt(st.nextToken());
			}
			
			//소팅
			Arrays.sort(yaksu);
			
			int start = yaksu[0];
			int end = yaksu[yaksu.length-1];
			
			int ans = start * end;
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}//end of main
}//end of class
