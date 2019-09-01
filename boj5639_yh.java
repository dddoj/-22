import java.util.*;
import java.io.*;

public class Main{
	static int[] map = new int[10001];
	static int index;
	public static void solve(int s, int e) {
		if(s>e)
			return;
		int root = s;
		int f = s; int l=e;
		while(map[f]>=map[root])
			f++;
		while(map[l]>map[root])
			l--;
		solve(f,l);
		solve(l+1,e);
		System.out.println(map[root]);
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		index = 0;
		while(sc.hasNextInt()) {
			map[index++] = sc.nextInt();
		}
		solve(0,index-1);
		sc.close();
	}
	
}