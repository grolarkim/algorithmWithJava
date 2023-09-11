package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16139_인간컴퓨터상호작용 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();

		int[][] dp = new int[str.length()][26];
		dp[0][str.charAt(0) - 'a'] += 1;
		for (int i = 1; i < str.length(); i++) {
			for (int j = 0; j < 26; j++) {
				dp[i][j] = dp[i - 1][j];
			}
			dp[i][str.charAt(i) - 'a'] += 1;
		}

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			char ch = st.nextToken().charAt(0);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int temp = 0;
			if (str.charAt(start) == ch) {
				temp = 1;
			}
			sb.append(dp[end][ch - 'a'] - dp[start][ch - 'a'] + temp);
			sb.append('\n');
		}

		System.out.println(sb.toString());

	}

}
