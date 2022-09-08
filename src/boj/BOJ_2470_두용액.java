package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_두용액 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int left = 0;
		int right = N - 1;
		int min = Integer.MAX_VALUE;
		int resultLeft = 0;
		int resultRight = 0;
		while (left < right) {
			if (arr[left] + arr[right] == 0) {
				System.out.println(arr[left] + " " + arr[right]);
				return;
			} else if (Math.abs(arr[left] + arr[right]) < min) {
				min = Math.abs(arr[left] + arr[right]);
				resultLeft = arr[left];
				resultRight = arr[right];
			} else if (arr[left] + arr[right] > 0) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println(resultLeft + " " + resultRight);

	}
}
