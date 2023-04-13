package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class deunggyosgil {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(4, 3, new int[][]{{2, 2}}));
        System.out.println(new Solution().solution(3, 1, new int[][]{{2, 1}}));
//        System.out.println(new Solution().solution(10, 10, new int[][]{}));
    }

    private static class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int[] dx = {0, 1};
            int[] dy = {1, 0};
            int[][] dp = new int[n + 1][m + 1];
            boolean[][] p = new boolean[n + 1][m + 1];
            boolean[][] visited = new boolean[n + 1][m + 1];
            for (int[] pu : puddles) {
                p[pu[1]][pu[0]] = true;
            }
            dp[1][1] = 1;
            for (int i = 3; i <= n + m; i++) {
                for (int j = 1; j < i; j++) {
                    if (j <= n && i - j <= m) {
                        dp[j][i - j] = (dp[j - 1][i - j] + dp[j][i - j - 1]) % 1_000_000_007;
                        if (p[j][i - j]) {
                            dp[j][i - j] = 0;
                        }
                    }
                }
            }

            return dp[n][m];
        }
    }
}
