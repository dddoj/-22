import java.util.*;
import java.io.*;

public class Main{
	static int n, m;
	static int[][] map;
	static int[][] virus;
	static int vcnt;
	static int ans;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class v{
		int x; int y; 
		v(int X, int Y){
			x = X; y = Y; 
		}
	}
	//바이러스 선택해서 nums에 저장. (조합)
	public static void choose(List<Integer> nums, int remain, int start) {
		if(remain == 0) {
			start(nums);
			return;
		}
		else {
			for(int i=start;i<vcnt;i++) {
				nums.add(i);
				choose(nums,remain-1,i+1);
				nums.remove(nums.size()-1);
			}
		}
	}
	//vlist(queue)에 선택한 바이러스넣기, mcopy에 선택한 바이러스 0 
	public static void start(List<Integer> nums) {
		int[][] mcopy = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				mcopy[i][j] = map[i][j];
		Queue<v> vlist = new LinkedList<v>();
		for(int i=0;i<m;i++) {
			int x = virus[nums.get(i)][0];
			int y = virus[nums.get(i)][1];
			mcopy[x][y] = 0;
			vlist.add(new v(x,y));
		}
		spread(vlist,mcopy,0);
	}
	// 재귀. 큐에 있는 바이러스 꺼내서 상하좌우 퍼트리기. 퍼트린 바이러스 다시 큐에 저장.
	public static void spread(Queue<v> vlist, int[][] mcopy, int t) {
		//다 퍼졌는지 체크.
		if(check(mcopy)) {
			ans = ans>t? t:ans;
			return;
		}	
		int vn = vlist.size();
		for(int i=0;i<vn;i++) {
			v cur = vlist.poll();
			for(int j=0;j<4;j++) {
				int x = cur.x+dx[j];
				int y = cur.y+dy[j];
				if(x>=0 && x<n && y>=0 && y<n) {
					if(mcopy[x][y] == -1 || mcopy[x][y] == -2) {
						mcopy[x][y] = t+1;
						vlist.add(new v(x,y));
					}
				}		
			}
		}
		if(vlist.size()!=0)
			spread(vlist,mcopy,t+1);
	}
	public static boolean check(int[][] mcopy) {
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(mcopy[i][j] == -1) {
					return false;
				}
		return true;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		virus = new int[10][2];
		vcnt = 0;
		// 빈칸 = -1, 바이러스 위치 = -2, 벽 = -3
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++) {
				int k = sc.nextInt();
				if(k==1)
					map[i][j] = -3;
				else if(k==2) {
					map[i][j] = -2;
					virus[vcnt][0] = i;
					virus[vcnt][1] = j;
					vcnt++;
				}
				else
					map[i][j] = -1;
			}
		ans = Integer.MAX_VALUE;
		choose(new ArrayList<Integer>(),m,0);
		if(ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
		sc.close();
	}
}