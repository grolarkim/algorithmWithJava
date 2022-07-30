package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기1 {
	static int N;
	static int[][] table;
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 1, 0 };
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		table = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, 0);
		System.out.println(sum);
	}

	public static void dfs(int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		if (nx >= N || ny >= N || table[nx][ny] != 0 || (d==1 && (table[nx][y] != 0 || table[x][ny] != 0))) {
			return;
		} 
		if (nx == N - 1 && ny == N - 1) {
			sum++;
			return;
		}
		switch (d) {
		case 0:
			dfs(nx,ny,0);
			dfs(nx,ny,1);
			break;
		case 1:
			dfs(nx,ny,0);
			dfs(nx,ny,1);
			dfs(nx,ny,2);
			break;
		case 2:
			dfs(nx,ny,1);
			dfs(nx,ny,2);
			break;
		}
	}
}
