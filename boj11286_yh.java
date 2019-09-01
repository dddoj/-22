import java.util.*;
import java.io.*;

public class Main{
	static int cnt;
	static PriorityQueue<Integer> pos = new PriorityQueue<Integer>();
	static PriorityQueue<Integer> neg = new PriorityQueue<Integer>(10,Collections.reverseOrder());
	public static void pop() {
		if(pos.isEmpty() && neg.isEmpty())
			System.out.println(0);
		else if(pos.isEmpty())
			System.out.println(neg.poll());
		else if(neg.isEmpty())
			System.out.println(pos.poll());
		else {
			int a = Math.abs(pos.peek());
			int b = Math.abs(neg.peek());
			if(a==b)
				System.out.println(neg.poll());
			else if(a>b)
				System.out.println(neg.poll());
			else
				System.out.println(pos.poll());
			
		}
	}
	public static void insert(int k) {
		if(k>0)
			pos.add(k);
		else
			neg.add(k);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int k = sc.nextInt();
			if(k==0)
				pop();
			else
				insert(k);
		}
		sc.close();
	}
}