package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2096_내려가기 {
	static int N;
	static int[][] table;
	static int[][] maxDp;
	static int[][] minDp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		table = new int[N][3];
		maxDp = new int[N][3];
		minDp = new int[N][3];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int j = 0; j < 3; j++) {
			table[0][j] = Integer.parseInt(st.nextToken());
			maxDp[0][j] = table[0][j];
			minDp[0][j] = table[0][j];
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
			maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + table[i][0];
			minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + table[i][0];
			maxDp[i][1] = Math.max(maxDp[i - 1][0], Math.max(maxDp[i - 1][1], maxDp[i - 1][2])) + table[i][1];
			minDp[i][1] = Math.min(minDp[i - 1][0], Math.min(minDp[i - 1][1], minDp[i - 1][2])) + table[i][1];
			maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + table[i][2];
			minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + table[i][2];
		}
		int max = Math.max(maxDp[N - 1][0], Math.max(maxDp[N - 1][1], maxDp[N - 1][2]));
		int min = Math.min(minDp[N - 1][0], Math.min(minDp[N - 1][1], minDp[N - 1][2]));

		System.out.println(max + " " + min);

	}
}
