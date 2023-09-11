package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형 {
	public static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][N];
		int[][] dp = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			int j = 0;
			while(st.hasMoreTokens()) {
				arr[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = arr[0][0];
		for(int i = 1;i<N;i++) {
			dp[i][0] = arr[i][0]+dp[i-1][0];
			for(int j = 1;j<=i;j++) {
				dp[i][j] = arr[i][j]+Math.max(dp[i-1][j-1], dp[i-1][j]); 
			}
		}
		int result = Integer.MIN_VALUE;
		for(int i : dp[N-1]) {
			result = Math.max(i, result);
		}

		System.out.println(result);
		
	}
}
