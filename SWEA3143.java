import java.util.*;
import java.io.*;

public class Solution {
	static int t;
	static int cnt;
	static int n,m;

	//map index = i, sub index = si. map과 sub을 비교, sub array가 map안에 있으면 비교 끝난 index부터 다시 비교시작, 아님 다음 index부터 시작. 비교끝난뒤 cnt++, si reset.
	public static void solve(char[] map, char[] sub) {
		cnt = 0;
		int si = 0;
		int i = 0;
		while(i<n) {
			int k = i;
			if(map[k]==sub[si]) {
				while(k<n && si<m && map[k]==sub[si]) {
					k++; si++;
					}
				if(si == m)
					i = k;
				else
					i++;
				si=0; cnt++;

			}
			else {
				i++; cnt++;
			}
		}
	}
	
	//String to char Array
	public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for(int tc = 1; tc<=t;tc++) {
        	String s = sc.next();
        	String ss = sc.next();
        	n = s.length();
        	m = ss.length();
        	char [] map = new char[n];
        	char [] sub = new char[m];
        	for(int i=0;i<n;i++)
        		map[i] = s.charAt(i);
        	for(int j=0;j<m;j++)
        		sub[j] = ss.charAt(j);
        	solve(map,sub);
        	System.out.println("#"+tc+" "+cnt);
        	
        }
        sc.close();

        
	}

}
