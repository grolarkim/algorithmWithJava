package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_6549_히스토그램에서가장긴직사각형 {
	static int N;
	static long[] arr;
	static long result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N == 0)
				break;
			arr = new long[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}
			result = getResult();
			bw.write(result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static long getResult() {
		// idx stack
		Stack<Integer> stack = new Stack<>();
		long max = 0;
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				long h = arr[stack.pop()];
				/*
				 * pop한 뒤 그 다음의 이전체인이 만약 없다면 0번째 index 부터 (i-1)번째 인덱스까지가 유일한 폭이 된다. (폭은 i가 됨) 반면
				 * 스택이 비어있지 않다면 이는 pop한 높이보다 더 작은 높이를 갖는 체인이 들어있다는 것이므로 (i-1)번째 index에서 그 다음 이전
				 * 체인의 index를 빼준 것이 폭이 된다.
				 */
				long w = stack.isEmpty() ? i : i - 1 - stack.peek();
				long size = h * w;
				max = Math.max(max, size);
			}
			stack.push(i);

		}
		while (!stack.isEmpty()) {
			long h = arr[stack.pop()];
			long w = stack.isEmpty() ? N : N - 1 - stack.peek();
			long size = h * w;
			max = Math.max(max, size);
		}

		return max;
	}
}
