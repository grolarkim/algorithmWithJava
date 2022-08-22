package swea;

import java.util.Scanner;

public class SWEA_1873_상호의배틀필드 {
	public static int H;
	public static int W;
	public static char[][] table;
	public static int X;
	public static int Y;
	public static int direction;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1;tc<=T;tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			table = new char[H][W];
			
			for(int i = 0;i<H;i++) {
				String str = sc.next();
				for(int j = 0;j<W;j++) {
					table[i][j] = str.charAt(j);
				}
			}
			getStart();
			
			int N = sc.nextInt();
			String str = sc.next();
			for(int i = 0;i<N;i++) {
				move(str.charAt(i));
			}
			
			String result = getResult();
			System.out.print("#"+tc+" "+result);
		}
		
	}


	static void move(char ch) {
		int nx = -1;
		int ny = -1;
		int dir = -1;
		if(ch == 'S') {
			int idx = 0;
			while(true) {
				nx = X+dx[direction]*idx;
				ny = Y+dy[direction]*idx;
				
				if(nx<0||ny<0||nx>=H||ny>=W) {
					break;
				}
				
				if(table[nx][ny] == '*') {
					table[nx][ny] = '.';
					break;
				} else if(table[nx][ny] == '#') {
					break;
				}
				
				idx++;
				
			}
			return;
		} else if(ch=='U') {
			dir = 0;
		} else if(ch=='D') {
			dir = 2;
		} else if(ch=='L') {
			dir = 3;
		} else if(ch=='R') {
			dir = 1;						
		}
		nx = X+dx[dir];
		ny = Y+dy[dir];			
		char[] d = {'^','>','v','<'};
		
		if((nx>=0&&ny>=0&&nx<H&&ny<W) && table[nx][ny]=='.') {
			table[nx][ny] = d[dir];
			table[X][Y] = '.';
			X=nx;
			Y=ny;
		} else {
			table[X][Y] = d[dir];
		}			
		direction = dir;
	}


	static void getStart() {
		for(int i = 0;i<H;i++) {
			for(int j = 0;j<W;j++) {
				if(table[i][j]=='^') {
					X = i;
					Y = j;
					direction = 0;
					return;
				} else if(table[i][j]=='>')	{
					X = i;
					Y = j;
					direction = 1;
					return;
				} else if(table[i][j]=='v') {
					X = i;
					Y = j;
					direction = 2;
					return;					
				} else if(table[i][j]=='<') {
					X = i;
					Y = j;
					direction = 3;
					return;
				}
			}
		}		
	}


	static String getResult() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<H;i++) {
			for(int j = 0;j<W;j++) {
				sb.append(table[i][j]);
			}
			sb.append('\n');
		}		
		return sb.toString();
	}
}
