package blank;
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] map;
	static int ans;
	static int k;
	
	//return longest increasing sequence.
	public static int solve() {
		ans = 0;
		int[] temp = new int[n+1];
		Arrays.fill(temp, 1);
		for(int i=n-2;i>=0;i--) 
			for(int j = n-1;j>i;j--) {
				if(map[i]<map[j]) {
					if(temp[j]+1>temp[i])
						temp[i] = temp[j]+1;
					if(temp[i]>ans)
						ans = temp[i];
				}
			}		
		return ans;
		
		
	}
	// input을 array에 받음 
	 public static void main(String[] args) throws FileNotFoundException{
	     Scanner sc = new Scanner(System.in);
	     n = sc.nextInt();
	     map = new int[n+1];
	     for(int i=0;i<n;i++) {
	    	 map[i] = sc.nextInt();	 
	     }
	     System.out.println(n-solve());
	     
	     sc.close();
	 }
}