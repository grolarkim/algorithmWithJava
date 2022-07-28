package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10844_쉬운계단수 {
	public static int[][] dp = new int[101][10];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		dp[1][0] = 0;
		for(int i = 1;i<10;i++) {
			dp[1][i] = 1;
		}
		for(int i = 2;i<=N;i++) {
			dp[i][0] = dp[i-1][1]%1000000000;
			for(int j = 1;j<9;j++) {
				dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
			}
			dp[i][9] = dp[i-1][8]%1000000000;
		}
		
		
		int sum = 0;
		for(int i = 0;i<10;i++) {
			sum += dp[N][i];
			sum = sum%1000000000;
		}

		System.out.println(sum);
	}
}
