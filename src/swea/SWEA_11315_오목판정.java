package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_11315_오목판정 {
	static int N;
	static char[][] table;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			table = new char[N][N];

			for (int i = 0; i < N; i++) {
				table[i] = br.readLine().toCharArray();
			}

			if (omok()) {
				System.out.println("#" + tc + " YES");
			} else {
				System.out.println("#" + tc + " NO");
			}
		}
	}

	static boolean omok() {
		if (isPossible(0, 1, 1, 0))
			return true; // 가로
		if (isPossible(1, 0, 0, 1))
			return true; // 세로
		if (isPossible(0, 1, 1, 1))
			return true; // 대각1-1
		if (isPossible(1, 0, 1, 1))
			return true; // 대각1-2
		if (isPossible(0, 1, 1, -1))
			return true; // 대각2-1
		if (isPossible(1, 0, 1, -1))
			return true; // 대각2-2
		return false;
	}

	static boolean isPossible(int r, int c, int dr, int dc) {
		int a = 0;
		if (r == 1 && c == 0 && dr == 1 && dc == -1) {
			a = N - 1;
		}
		for (int i = 0; i < N; i++) {
			int x = i * r;
			int y = a + i * c;
			int idx = 0;
			int cnt = 0;
			while (true) {
				int nx = x + idx * dr;
				int ny = y + idx * dc;
				if (nx >= N || ny >= N || nx < 0 || ny < 0) {
					break;
				}
				if (table[nx][ny] == 'o') {
					cnt++;
				} else {
					cnt = 0;
				}
				if (cnt >= 5) {
					return true;
				}
				idx++;
			}
		}
		return false;
	}
}
