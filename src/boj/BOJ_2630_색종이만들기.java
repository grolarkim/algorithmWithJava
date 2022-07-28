package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_색종이만들기 {

	public static StringTokenizer st;
	public static int[][] table;
	public static int zeros = 0;
	public static int ones = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		table = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		making(0, 0, N, N);
		System.out.println(zeros);
		System.out.println(ones);

	}

	public static void making(int sx, int sy, int ex, int ey) {
		int a = table[sx][sy];
		for (int i = sx; i < ex; i++) {
			for (int j = sy; j < ey; j++) {
				if (table[i][j] != a) {
					making(sx, sy, (sx + ex) / 2, (sy + ey) / 2);
					making((sx + ex) / 2, sy, ex, (sy + ey) / 2);
					making(sx, (sy + ey) / 2, (sx + ex) / 2, ey);
					making((sx + ex) / 2, (sy + ey) / 2, ex, ey);
					return;
				}
			}
		}
		if (a == 0) {
			zeros++;
		} else {
			ones++;
		}

	}
}
