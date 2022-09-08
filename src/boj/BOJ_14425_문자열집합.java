package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_14425_문자열집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> S = new HashSet<>();

		for (int i = 0; i < N; i++) {
			S.add(in.readLine());
		}
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if (S.contains(in.readLine())) {
				cnt++;
			}
		}

		System.out.println(cnt);

	}
}
