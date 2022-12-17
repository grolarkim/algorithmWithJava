package programmers;

import java.util.*;

public class Allbaruengwalho {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(1));
        System.out.println(new Solution().solution(2));
        System.out.println(new Solution().solution(3));
        System.out.println(new Solution().solution(4));
    }

    static class Solution {
        public int solution(int n) {
            int[] dp = new int[n + 1];

            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[i - j] * dp[j - 1];
                }
            }

            return dp[n];
        }
    }
}
