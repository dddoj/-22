import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      //A와 B 입력받음
			String A = st.nextToken();
			String B = st.nextToken();
			int len = B.length();
			int cnt = 0;
			//A의 길이만큼 돌면서(index값을 0~ length-1까지) A의 부분문자열과일치하면 카운트 하주고 i를 i+len으로 초기화 -1로 
      for (int i = 0; i < A.length(); i++) {
				if(i+len <= A.length() && A.substring(i, i+len).equals(B)) {
					cnt++;
					i = i+len-1;
				} else {
					cnt++;
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
		}//end of testCase

	}//end of main
}//end of class
