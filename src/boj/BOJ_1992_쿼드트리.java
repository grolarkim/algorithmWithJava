package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {

	public static int[][] table;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		table = new int[N][N];

		for (int i = 0; i < N; i++) {
			String st = in.readLine();
			for (int j = 0; j < N; j++) {
				table[i][j] = st.charAt(j) - '0';
			}
		}

		making(0, 0, N, N);
		String str = sb.toString();
		System.out.println(str);

	}

	public static void making(int sx, int sy, int ex, int ey) {
		int a = table[sx][sy];
		for (int i = sx; i < ex; i++) {
			for (int j = sy; j < ey; j++) {
				if (table[i][j] != a) {
					sb.append('(');
					making(sx, sy, (sx + ex) / 2, (sy + ey) / 2);
					making(sx, (sy + ey) / 2, (sx + ex) / 2, ey);
					making((sx + ex) / 2, sy, ex, (sy + ey) / 2);
					making((sx + ex) / 2, (sy + ey) / 2, ex, ey);
					sb.append(')');
					return;
				}
			}
		}
		if (a == 0) {
			sb.append('0');
		} else {
			sb.append('1');
		}

	}
}
