package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156_포도주시식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int[] arr = new int[N];
		for(int i = 0;i<N;i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		if(N == 1) {
			System.out.println(arr[0]);
			return;
		}
		int[][] dp = new int[N][2];
		dp[0][0] = 0;
		dp[0][1] = arr[0];
		dp[1][0] = arr[0];
		dp[1][1] = dp[0][1]+arr[1];
		
		for(int i = 2;i<N;i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
			dp[i][1] = Math.max(dp[i-2][0]+arr[i]+arr[i-1], dp[i-1][0]+arr[i]);
		}
		System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
	}
}
