package programmers;

import programmers.naver.financial.NF1;

public class Jeongsusamgak {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(new Solution().solution(triangle));
        System.out.println(new Solution().solution(new int[][]{{1}}));

    }

    static class Solution {
        public int solution(int[][] triangle) {
            int[][] dp = new int[triangle.length][triangle.length];
            dp[0][0] = triangle[0][0];
            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = dp[i - 1][0] + triangle[i][0];
                for (int j = 1; j <= i; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
            int answer = 0;
            for (int i = 0; i < dp.length; i++) {
                answer = Math.max(dp[dp.length - 1][i], answer);
            }
            return answer;
        }
    }

}
