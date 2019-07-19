import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int LIScnt = 0;
		int cnt = 0;
		
		int[] tmp = new int[N+1];
		
		//가장 긴 증가수열 찾는다
		for(int i=1; i<=N; i++) {
			tmp[i] = 1;
			for (int j = 1; j < i; j++) {
				if(arr[j] < arr[i] && tmp[i] < tmp[j]+1) { 
					tmp[i]++;
				}
			}
      //최장증가수열 
			if(LIScnt < tmp[i]) {
				LIScnt = tmp[i];
			}
		}
    //숫자의 개수 - LIS
		System.out.println(N-LIScnt);
	}//end of main
}//end of class
