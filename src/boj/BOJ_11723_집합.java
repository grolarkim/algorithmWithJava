package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11723_집합 {
	static int N;
	static int A;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String operator = st.nextToken();
			if (st.hasMoreTokens()) {
				int target = Integer.parseInt(st.nextToken());
				oper(operator, target);
			} else {
				oper(operator, 0);
			}

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

	static void oper(String operator, int target) {
		switch (operator) {
		case "add":
			A |= (1 << target);
			break;
		case "remove":
			A &= ~(1 << target);
			break;
		case "check":
			sb.append((A & (1 << target)) == 1 << (target) ? "1\n" : "0\n");
			break;
		case "toggle":
			A ^= (1 << target);
			break;
		case "all":
			A |= (~0);
			break;
		case "empty":
			A &= 0;
			break;
		}

	}
}
