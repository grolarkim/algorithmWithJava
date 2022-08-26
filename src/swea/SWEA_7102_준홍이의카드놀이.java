package swea;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_7102_준홍이의카드놀이 {
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N + M + 1];
			sb = new StringBuilder();

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					arr[i + j]++;
				}
			}

			int max = -1;

			for (int a : arr) {
				max = Math.max(max, a);
			}

			for (int i = 1; i <= N + M; i++) {
				if (arr[i] == max) {
					sb.append(' ').append(i);
				}
			}

			System.out.println("#" + tc + sb.toString());
		}

	}
}
