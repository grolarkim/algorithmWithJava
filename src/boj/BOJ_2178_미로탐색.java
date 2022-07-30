package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
	static int N;
	static int M;
	static int[][] table;
	static int[][] visit;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		table = new int[N][M];
		visit = new int[N][M];
		for (int i = 0; i < N; i++) {
			String a = in.readLine();
			for (int j = 0; j < M; j++) {
				table[i][j] = a.charAt(j) - '0';
			}
		}

		bfs();
		System.out.println(visit[N - 1][M - 1]);

	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(0);
		q.offer(0);
		visit[0][0] = 1;
		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && table[nx][ny] == 1 && visit[nx][ny] == 0) {
					visit[nx][ny] = visit[x][y] + 1;
					q.offer(nx);
					q.offer(ny);
				}
			}

		}

	}
}
