package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14003_가장긴증가하는부분수열5 {
	static int N;
	static int[] arr;
	static int[] lis;
	static int[] lisIdx;
	static int[] dp;
	static int max;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		lis = new int[N];
		lisIdx = new int[N];
		Arrays.fill(lis, Integer.MAX_VALUE);
		dp = new int[N];
		Arrays.fill(dp, -1);
		max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		getLIS();
		System.out.println(max);
		System.out.println(sb.toString());
	}

	private static void getLIS() {
		for (int i = 0; i < N; i++) {
			int idx = Arrays.binarySearch(lis, arr[i]);
			if (idx < 0) {
				lis[(-idx - 1)] = arr[i];
				lisIdx[(-idx - 1)] = i;
				max = Math.max(max, (-idx - 1) + 1);
				if (-idx - 2 >= 0) {
					dp[i] = lisIdx[(-idx - 2)];
				}
			}
		}
		int lastIdx = lisIdx[max - 1];
		Stack<Integer> stack = new Stack<>();
		stack.add(lastIdx);
		while (true) {
			int now = stack.peek();
			if (dp[now] < 0) {
				break;
			}
			stack.add(dp[now]);
		}
		while (!stack.isEmpty()) {
			sb.append(arr[stack.pop()]).append(' ');
		}
		sb.deleteCharAt(sb.length() - 1);
	}
}
