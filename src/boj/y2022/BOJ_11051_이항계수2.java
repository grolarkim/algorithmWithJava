package boj.y2022;

import java.util.Scanner;

public class BOJ_11051_이항계수2 {
	public static int[][] dp;
	
	public static int bc(int n, int k) {
		if(k==0||n==k) {
			dp[n][k] = 1;
			return 1;
		}
		
		if(dp[n][k] != 0) {
			return dp[n][k];
		}
		
		int a = (bc(n-1,k-1)+bc(n-1,k))%10007;
		dp[n][k] = a;
		return a;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		
		dp = new int[N+1][K+1];
		System.out.println(bc(N,K));
		
		
	}
	
	
}
