package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654_랜선자르기 {
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K];
		long low = 0;
		long high = 0;

		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			high = Math.max(high, arr[i]);
		}
		
		high++;
		
		while (low < high) {
			long mid = (low + high) / 2;
			long sum = 0;
			for (int a : arr) {
				sum += (a / mid);
			}
			if (sum >= N) {
				low = mid+1;
			} else {
				high = mid;
			}
		}

		System.out.println(low-1);

	}

}
