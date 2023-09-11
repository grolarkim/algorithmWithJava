package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {
	static int N;
	static int[] arr;
	static int start;
	static int end;

	static int min;
	static int minS;
	static int minE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		start = 0;
		end = N - 1;

		min = Integer.MAX_VALUE;
		minS = 0;
		minE = N - 1;

		search();

		System.out.println(minS + " " + minE);

	}

	static void search() {
		for (int i = 0; i < N; i++) {
			int y = Arrays.binarySearch(arr, -arr[i]);
			if (y >= 0) {
				int temp = arr[i] + arr[y];
				if (min > temp) {
					min = temp;
					minS = Math.min(arr[i], arr[y]);
					minE = Math.max(arr[i], arr[y]);
				}
				break;
			} else {
				y = -y - 2;
				for (int j = y; j < y + 4; j++) {
					if (j >= 0 && j < N && i != j) {
						int temp = arr[i] + arr[j];
						if (min > Math.abs(temp)) {
							min = Math.abs(temp);
							minS = Math.min(arr[i], arr[j]);
							minE = Math.max(arr[i], arr[j]);
						}
					}
				}

			}
		}

	}

}
