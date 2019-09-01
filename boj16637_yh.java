import java.util.*;
import java.io.*;

public class Main{
	static long [] nums = new long [11];
	static char[] op = new char [11];
	static int ncnt, opcnt;
	static int ans;
	// index = 현재 연산 위치 
	public static void solve(int index, long result) {
		long cur = 0; long temp = 0;
		if(index>=opcnt) {
			if(result>ans)
				ans = (int) result;
			return;
		}
		//현재 연산 계산 
		cur = calculate(result,nums[index+1],op[index]);
		solve(index+1,cur);
		//다음 연산자에 괄호 넣어 계산 (처음 연산에는 괄호를 넣으나 마나 똑같으니 처음꺼는 생략가능)
		if(index+1<opcnt) {
			temp = calculate(nums[index+1],nums[index+2],op[index+1]);
			cur = calculate(result,temp,op[index]);
		}
		solve(index+2,cur);		
	}
	
	public static long calculate(long a, long b, char c) {
		if(c=='+')
			return a+b;
		else if(c=='*')
			return a*b;
		else
			return a-b;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		ncnt = 0;
		opcnt = 0;
		for(int i=0;i<n;i++) {
			if(i%2==0)
				nums[ncnt++] = s.charAt(i)-48;
			else
				op[opcnt++] = s.charAt(i);
		}
		ans = Integer.MIN_VALUE;
		solve(0,nums[0]);
		System.out.println(ans);
		
		sc.close();
	}
}