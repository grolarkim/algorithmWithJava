package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298_오큰수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());

		int[] arr = new int[N];
		int[] nge = new int[N];

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		stack.push(0);
		for (int i = 1; i < N - 1; i++) {
			while (!stack.isEmpty()) {
				int idx = stack.pop();
				int val = arr[idx];
				if (val < arr[i]) {
					nge[idx] = arr[i];
				} else {
					stack.push(idx);
					break;
				}
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int idx = stack.pop();
			int val = arr[idx];
			if (val < arr[N - 1]) {
				nge[idx] = arr[N - 1];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (nge[i] == 0) {
				sb.append(-1);
				sb.append(' ');
			} else {
				sb.append(nge[i]);
				sb.append(' ');
			}
		}
		System.out.println(sb.toString());

	}
}
