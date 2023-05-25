package boj;

import java.util.Scanner;

public class BOJ_11049_행렬곱셈순서 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int INF = Integer.MAX_VALUE;
        int N = sc.nextInt();
        int[][] mat = new int[N + 1][2];
        int[][] dp = new int[502][502];
        for (int i = 0; i < N; i++) {
            mat[i][0] = sc.nextInt();
            mat[i][1] = sc.nextInt();
        }
        sc.close();
        for (int k = 2; k <= N; k++) {
            for (int i = 0; i <= N - k; i++) {
                dp[i][k] = INF;
                for (int j = 1; j < k; j++) {
                    dp[i][k] = Math.min(dp[i][k], mat[i][0] * mat[i + j][0] * mat[i + k - 1][1] + dp[i][j] + dp[i + j][k - j]);
                }
            }
        }

        System.out.println(dp[0][N]);

    }
}
