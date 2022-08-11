package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210_Ladder1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			String tc = br.readLine();
			int[][] map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int start = -1;
			for (int j = 0; j < 100; j++) {
				if (map[99][j] == 2) {
					start = j;
				}
			}
			int r = 99;
			int c = start;
			int d = 0;
			int[] dr = { -1, 0, 0 };
			int[] dc = { 0, -1, 1 };
			while (r > 0) {
				if (d == 0) {
					for (int a = 1; a < 3; a++) {
						int nr = r + dr[a];
						int nc = c + dc[a];
						if (nr >= 0 && nc >= 0 && nr < 100 && nc < 100) {
							if (map[nr][nc] == 1) {
								d = a;
							}
						}
					}
				} else {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr >= 0 && nc >= 0 && nr < 100 && nc < 100) {
						if (map[nr][nc] == 0) {
							d = 0;
						}
					} else {
						d = 0;
					}
				}
				r += dr[d];
				c += dc[d];
			}
			System.out.printf("#%d %d", test_case, c).println();
		}
	}
}
