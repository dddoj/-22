import java.util.*;
import java.io.*;

public class Main{
	static int[] map = new int[51];
	static int [] result = new int[51];
	static int n;
	public static void solve() {
		for(int i=0;i<n-2;i++)
			for(int j=i+1;j<n-1;j++) {
				reverse(i,j);
			}
	}
	public static void reverse (int a, int b) {
		if(result[0]<map[a])
			return;
		int [] temp = new int[n];
		for(int i=0;i<=a;i++) {
			temp[i] = map[a-i];
		}
		int cnt = 0;
		for(int j= a+1;j<=b;j++,cnt++) {
			temp[j] = map[b-cnt];
		}
		cnt=0;
		for(int k=b+1;k<n;k++,cnt++)
			temp[k] = map[n-1-cnt];
		check(temp);
	}
	public static void check(int[] temp) {
		for(int i=0;i<n;i++) {
			if(result[i]<temp[i]) 
				return;
			else if(result[i] == temp[i])
				continue;
			else {
				result = temp;
				return;
			}
			
		}
	}
	public static String convert() {
		char[] c = new char[n];
		for(int i=0;i<n;i++)
			c[i] = (char)result[i];
		String st = new String(c);
		return st;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		n= s.length();
		for(int i=0;i<n;i++) {
			map[i] = s.charAt(i);
		}
		for(int i=0;i<n;i++)
			result[i] = 122;
		solve();
		System.out.println(convert());
		sc.close();
	}
}