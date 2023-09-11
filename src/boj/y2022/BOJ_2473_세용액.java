package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473_세용액 {
	static int N;
	static long[] arr;
	static long min = Long.MAX_VALUE;
	static long[] marr = new long[3];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

		sim();

		Arrays.sort(marr);
		
		System.out.println(marr[0] + " " + marr[1] + " " + marr[2]);
	}

	private static void sim() {
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int t = Arrays.binarySearch(arr, -(arr[i] + arr[j]));
//				System.out.println(i+" "+j+" "+t);
				if (t >= 0) {
					for (int l = t-1; l < t + 2; l++) {
						if (l != i && l != j && l >= 0 && l < N) {
							long temp = arr[i] + arr[j] + arr[l];
							if (min > Math.abs(temp)) {
								min = Math.abs(temp);
								marr[0] = arr[i];
								marr[1] = arr[j];
								marr[2] = arr[l];
							}
						}
					}
				} else {
					int y = -t - 2;
					for (int l = y; l < y + 4; l++) {
						if (l != i && l != j && l >= 0 && l < N) {
							long temp = arr[i] + arr[j] + arr[l];
							if (min > Math.abs(temp)) {
								min = Math.abs(temp);
								marr[0] = arr[i];
								marr[1] = arr[j];
								marr[2] = arr[l];
							}
						}
					}
				}
			}
		}

	}
}
