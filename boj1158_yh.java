import java.util.*;
import java.io.*;

public class Main{
	static int n,k;
	
	//k번째전까지 제거한뒤 맨뒤로 추가, k번째는 제거한뒤 프린트.
	public static void solve() {
		LinkedList<Integer> llist = new LinkedList<Integer>();
		for(int i=1;i<=n;i++) {
			llist.add(i);
		}
		System.out.print("<");
		for(int i=0;i<n;i++) {
			for(int j=1;j<k;j++) {
				int t = llist.poll();
				llist.add(t);
			}
			int p = llist.poll();
			System.out.print(p);
			if(i!=n-1)
				System.out.print(", ");
			else
				System.out.print(">");
		}
		
	}
	

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		solve();
		sc.close();
	}
}
