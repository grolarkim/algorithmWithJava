package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_12712_파리퇴치3 {
	public static int[][] matrix;
	public static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	public static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	public static int N;
	public static int M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			matrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int result = flies();
			System.out.println("#" + tc + " " + result);

		}

	}

	public static int flies() {
		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, spray(i, j));
			}
		}

		return max;
	}

	public static int spray(int x, int y) {
		int sump = matrix[x][y];
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < M; j++) {
				if (j * dx[i] + x >= 0 && j * dx[i] + x < N && j * dy[i] + y >= 0 && j * dy[i] + y < N) {
					sump += matrix[j * dx[i] + x][j * dy[i] + y];
				}
			}
		}
		int sumx = matrix[x][y];
		for (int i = 4; i < 8; i++) {
			for (int j = 1; j < M; j++) {
				if (j * dx[i] + x >= 0 && j * dx[i] + x < N && j * dy[i] + y >= 0 && j * dy[i] + y < N) {
					sumx += matrix[j * dx[i] + x][j * dy[i] + y];
				}
			}
		}
		return Math.max(sump, sumx);
	}
}
