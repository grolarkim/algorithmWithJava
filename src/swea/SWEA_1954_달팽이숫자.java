package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1954_달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)	{
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			int[] dr = {0,1,0,-1};
			int[] dc = {1,0,-1,0};
			int step = 1;
			int r = 0;
			int c = 0;
			int dir = 0;
			while(step<=N*N) {
				arr[r][c] = step;
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=N||arr[nr][nc]!=0) {
					dir = (dir+1)%4;
					nr = r+dr[dir];
					nc = c+dc[dir];
				}
				r=nr;
				c=nc;				
				step++;
			}
			StringBuilder sb = new StringBuilder();
			sb.append('#').append(test_case).append('\n');
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					sb.append(arr[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.println(sb.toString());
		}
	}
}
