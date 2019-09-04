package day0903;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2382 {
	public static int ans;
	public static ArrayList<Microbe>[][] map;
	public static int[] dx = {0,-1,1,0,0};
	public static int[] dy = {0,0,0,-1,1};
	public static int[] dirConvert = {0,2,1,4,3};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			ans = 0;//총 미생물 수
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int x,y,cnt,dir;
			
			map = new ArrayList[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = new ArrayList<Microbe>();
				}
			}
			
			//미생물 입력
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				cnt = Integer.parseInt(st.nextToken());
				dir = Integer.parseInt(st.nextToken());
				map[x][y].add(new Microbe(x,y,cnt,dir,0));//해당 맵에 미생물 저장
			}
			
			//시뮬레이션
			for(int time=0; time<M; time++) {
				//이동
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(!map[i][j].isEmpty() && map[i][j].get(0).check == 0) {//미생물이 존재하면
							move(map[i][j], N);
						}
					}
				}
				
				//합치기
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(map[i][j].size() >= 2) {//모인 미생물이 2마리 이상이면
							combine(map[i][j], N);
						} else if(map[i][j].size()==1) {
							map[i][j].get(0).check = 0;
						}
					}
				}
			}
			//총 합 계산
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!map[i][j].isEmpty())
						ans += map[i][j].get(0).cnt;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}//end of testCase
	}//end of main
	
	public static void move(ArrayList<Microbe> miseng, int N) {
		Microbe m = miseng.get(0);
		miseng.remove(0);
		
		int x = m.x;
		int y = m.y;
		int dir = m.dir;
		int nx = x;
		int ny = y;
		int cnt = m.cnt;
		
		if(dir==1) { 
			nx=x-1; 
		}else if(dir==2) { 
			nx=x+1; 
		}else if(dir==3) { 
			ny=y-1; 
		}else if(dir==4) { 
			ny=y+1; 
		}
		
		if(nx == 0 || ny == 0 || nx == N-1 || ny == N-1) {//약품 칠해진 곳이면
			if(dir == 1) {
				dir = 2;
				cnt = cnt/2;
			} else if(dir == 2) {
				dir = 1;
				cnt = cnt/2;
			} else if(dir == 3) {
				dir = 4;
				cnt = cnt/2;
			} else if(dir == 4) {
				dir = 3;
				cnt = cnt/2;
			}
		}
		
		map[nx][ny].add(new Microbe(nx,ny,cnt,dir,1));
	}//end of move();
	
	public static void combine(ArrayList<Microbe> miseng, int N) {
		int maxSize = 0;
		int dir = 0;
		int total = 0;
		int x = 0;
		int y = 0;
		
		int size = miseng.size();
		
		for(int i=0; i<size; i++) {
			Microbe m = miseng.get(0);
			miseng.remove(0);
			total += m.cnt;
			
			if(maxSize < m.cnt) {
				maxSize = m.cnt;
				dir = m.dir;
				x = m.x;
				y = m.y;
			}
		}
		miseng.add(new Microbe(x,y,total,dir,0));
	}//end of combine()
	
	//미생물 클래스
	public static class Microbe{
		int x;//세로위치
		int y;//가로위치
		int cnt;//미생물 수
		int dir;//이동방향(상,하,좌,우) : 1,2,3,4
		int check;
		
		public Microbe(int x, int y, int cnt, int dir, int check) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
			this.check = check;
		}
		
	}//end of class
}//end of class
