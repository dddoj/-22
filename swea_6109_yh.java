import java.util.*;
import java.io.*;
public class Solution{
	static int n;
	static String s;
	static int[][] map;
	static int[][] ans;
	public static void solve(String s) {
		if(s.equals("left")) 
			left();
		else if(s.equals("right"))
			right();
		else if(s.equals("up"))
			up();
		else 
			down();
		
	}
	public static void left() {
		for(int i=0;i<n;i++) {
			Queue<Integer> queue = new LinkedList<>();
			for(int j=0;j<n;j++) {
				if(map[i][j]!=0)
					queue.add(map[i][j]);
			}
			int k = 0;
			while(!queue.isEmpty()) {
				int a = queue.poll();
				if(!queue.isEmpty()) {
					int b = queue.peek();
					if(a==b) {
						a+=a;
						queue.remove();	
					}
				}
				ans[i][k] = a;
				k++;
			}
		}
	}
	public static void right() {
		for(int i=0;i<n;i++) {
			Queue<Integer> queue = new LinkedList<>();
			for(int j=n-1;j>=0;j--) {
				if(map[i][j]!=0)
					queue.add(map[i][j]);
			}
			int k = n-1;
			while(!queue.isEmpty()) {
				int a = queue.poll();
				if(!queue.isEmpty()) {
					int b = queue.peek();
					if(a==b) {
						a+=a;
						queue.remove();	
					}
				}
				ans[i][k] = a;
				k--;
			}
		}
	}
	public static void up() {
		for(int j=0;j<n;j++) {
			Queue<Integer> queue = new LinkedList<>();
			for(int i=0;i<n;i++) {
				if(map[i][j]!=0)
					queue.add(map[i][j]);
			}
			int k = 0;
			while(!queue.isEmpty()) {
				int a = queue.poll();
				if(!queue.isEmpty()) {
					int b = queue.peek();
					if(a==b) {
						a+=a;
						queue.remove();	
					}
				}
				ans[k][j] = a;
				k++;
			}
		}
	}
	public static void down() {
		for(int j=0;j<n;j++) {
			Queue<Integer> queue = new LinkedList<>();
			for(int i=n-1;i>=0;i--) {
				if(map[i][j]!=0)
					queue.add(map[i][j]);
			}
			int k = n-1;
			while(!queue.isEmpty()) {
				int a = queue.poll();
				if(!queue.isEmpty()) {
					int b = queue.peek();
					if(a==b) {
						a+=a;
						queue.remove();	
					}
				}
				ans[k][j] = a;
				k--;
			}
		}
	}
	
	public static void main(String[] arg) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			n = sc.nextInt();
			s = sc.next();
			map = new int[n+1][n+1];
			ans = new int[n+1][n+1];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					map[i][j] = sc.nextInt();
			solve(s);
			System.out.println("#"+t);
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) 
					System.out.print(ans[i][j]+" ");
				System.out.println();
			}
		
					
		}
		sc.close();
	}
}