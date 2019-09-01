import java.util.*;
import java.io.*;
class Scot{
	int x;
	int y;
	int knum;
	Scot(int X, int Y, int K){
		x = X;
		y = Y;
		knum = K;
	}
}
class Villain{
	int x; int y;
	Villain(int X, int Y){
		x = X;
		y = Y;
	}
}
class Fire{
	int x; int y;
	Fire(int X, int Y){
		x = X;
		y = Y;
	}
}
//스캇,악당,불 위치를 각각의 큐에 저장해서 디큐해서 위치 변화.
public class Solution{
	static int n,m,k;
	static char[][] map;
	static int[][] kmap;
	static boolean[][] vvisit;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<Scot> squeue;
	static Queue<Villain> vqueue;
	static Queue<Fire> fqueue;
	
	public static int solve() {
		int t = 0;
		while(!squeue.isEmpty()) {
			t++;
			int fsize = fqueue.size();
			for(int i=0;i<fsize;i++) {
				Fire f = fqueue.poll();
				for(int j=0;j<4;j++) {
					int fx = f.x+dx[j]; int fy = f.y+dy[j];
					if(fx>=0 && fy>=0 && fx<n && fy<m && map[fx][fy] == 'A'){
							map[fx][fy] = 'F';
							fqueue.add(new Fire(fx,fy));
						}
				}
			}
			int vsize = vqueue.size();
			for(int l=0;l<vsize;l++) {
				Villain v = vqueue.poll();
				for(int i=0;i<4;i++) {
					int vx = v.x+dx[i]; int vy = v.y+dy[i];
					if(vx>=0 && vy>=0 && vx<n && vy<m) {
						if(map[vx][vy] == 'E') {
							return -1;
						}
						if(!vvisit[vx][vy] && (map[vx][vy] == 'A' || map[vx][vy] == 'F')){
							vvisit[vx][vy] = true;
							vqueue.add(new Villain(vx,vy));
						}
					}	
				}
			}
			int ssize =squeue.size(); 
			for(int j=0;j<ssize;j++) {
				Scot s = squeue.poll();
				for(int i=0;i<4;i++) {
					int sx = s.x+dx[i]; int sy = s.y+dy[i];
					if(sx>=0 && sy>=0 && sx<n && sy<m) {
						if(map[sx][sy] == 'E') {
							return t;
						}
						if(map[sx][sy] == 'A' && kmap[sx][sy]!=k) {
							kmap[sx][sy] = k;
							squeue.add(new Scot(sx,sy,k));
						}
						else if(map[sx][sy] == 'W' && kmap[sx][sy]<s.knum-1) {
							kmap[sx][sy] = s.knum-1;
							squeue.add(new Scot(sx,sy,s.knum-1));
						}
					}
				}
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			map = new char[n][m];
			kmap = new int[n][m];
			for(int[] row : kmap)
				Arrays.fill(row, -1);
			vvisit = new boolean [n][m];
			squeue = new LinkedList<Scot>();
			vqueue = new LinkedList<Villain>();
			fqueue = new LinkedList<Fire>();
			for(int i=0;i<n;i++) {
				String s = sc.next();
				for(int j=0;j<m;j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == 'S') {
						map[i][j] = 'A';
						kmap[i][j] = k;
						squeue.add(new Scot(i,j,k));
					}
					else if(map[i][j] == 'V') {
						map[i][j] = 'A';
						vvisit[i][j] = true;
						vqueue.add(new Villain(i,j));
					}
					else if(map[i][j] == 'F') 
						fqueue.add(new Fire(i,j));
				}
			}
			
			System.out.println("#"+tc+" "+solve());
		}
		sc.close();
	}
}
