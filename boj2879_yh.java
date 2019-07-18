import java.util.*;
import java.io.*;

public class Main{
	static int n;
	static int temp[],diff[];
	static int cnt;
	
	//연속된 줄 확인후 추가또는 삭제. 연속이 끝나면 cnt++. 현재 줄이 다 고쳐지면 다음 줄로. 
	public static void solve() {
		int s = 0;
		while(s<n) {
			if(s==n-1) {
				if(diff[s]>0)
					cnt+=diff[s];
				else
					cnt-=diff[s];
				break;
			}
			if(diff[s]==0)
				s++;
			if(s<n-1) {
				if(diff[s]*diff[s+1]<=0) {
					if(diff[s]>0)
						cnt+=diff[s];
					else
						cnt-=diff[s];
					diff[s] = 0;
					s++;
				}
				else {
					int e = s+1;
					if(diff[s]>0) {
						diff[s]--;
						while(diff[e]>0) {
							diff[e]--;
							e++;
						}
					}
					else {
						diff[s]++;
						while(diff[e]<0) {
							diff[e]++;
							e++;
						}
					}	
					cnt++;
				}
			}

		}
	}
	

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		temp = new int[n+1];
		diff = new int[n+1];
		for(int i=0;i<n;i++)
			temp[i] = sc.nextInt();
		for(int j=0;j<n;j++) {
			int t = sc.nextInt();
			diff[j] = temp[j]-t;
		}
		solve();
		System.out.println(cnt);
		sc.close();
	}
}
