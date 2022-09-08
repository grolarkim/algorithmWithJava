package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1206_view {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(in.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int sum = 0;
			for (int i = 2; i < N - 2; i++) {
				int view = Math.min(Math.min(arr[i] - arr[i - 1], arr[i] - arr[i - 2]),
						Math.min(arr[i] - arr[i + 1], arr[i] - arr[i + 2]));
				if (view > 0) {
					sum += view;
				}
			}
			System.out.printf("#%d %d", tc, sum).println();
			
		}
	}
}
