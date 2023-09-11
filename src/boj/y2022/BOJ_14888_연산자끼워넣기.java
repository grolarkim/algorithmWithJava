package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
	public static int N;
	public static int[] arr;
	public static int[] op = new int[4];
	public static int[] opArr;
	public static StringTokenizer st;
	public static int minValue = Integer.MAX_VALUE;
	public static int maxValue = Integer.MIN_VALUE;
	public static int now;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		now = arr[0];

		st = new StringTokenizer(in.readLine());
		opArr = new int[N - 1];
		int a = 0;
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < op[i]; j++) {
				opArr[a++] = i;
			}
		}

		dfs(1);
		System.out.println(maxValue);
		System.out.println(minValue);

	}

	public static void dfs(int step) {
		if (step == N) {
			minValue = Math.min(now, minValue);
			maxValue = Math.max(now, maxValue);
			return;
		}

		for (int i = 0; i < N - 1; i++) {
			if (opArr[i] != -1) {
				int temp = opArr[i];
				int tempNow = now;
				switch (temp) {
				case 0:
					now += arr[step];
					break;
				case 1:
					now -= arr[step];
					break;
				case 2:
					now *= arr[step];
					break;
				case 3:
					now /= arr[step];
					break;
				}
				opArr[i] = -1;
				dfs(step+1);
				now = tempNow;
				opArr[i] = temp;
			}
		}
	}
}
