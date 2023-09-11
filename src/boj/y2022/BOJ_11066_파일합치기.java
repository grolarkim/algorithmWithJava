package boj.y2022;

import java.util.*;


public class BOJ_11066_파일합치기 {
    static int N;
    static int[] chapters;
    static int[] sums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            N = sc.nextInt();
            chapters = new int[N + 1];
            sums = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                chapters[i] = sc.nextInt();
                sums[i] = sums[i - 1] + chapters[i];
            }
            int result = dp();
            System.out.println(result);
        }
    }

    public static int dp() {
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            dp[i][i + 1] = chapters[i] + chapters[i + 1];
        }
        for (int j = 2; j <= N; j++) {
            for (int i = 1; j + i <= N; i++) {
                for (int k = i; k < i + j; k++) {
                    if (dp[i][j + i] == 0) {
                        dp[i][j + i] = dp[i][k] + dp[k + 1][i + j] + sum(i, i + j);
                    } else
                        dp[i][j + i] = Math.min(dp[i][j + i], dp[i][k] + dp[k + 1][i + j] + sum(i, i + j));
                }
            }
        }
//        System.out.println("a");
        return dp[1][N];
    }

    static int sum(int start, int end) {
        if (start == 0) {
            return sums[end];
        }
        return sums[end] - sums[start - 1];
    }
}
