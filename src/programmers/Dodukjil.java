package programmers;

import java.util.*;

public class Dodukjil {
    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1};
        int result = new Solution().solution(money);
        System.out.println(result);
    }

    static class Solution {
        public int solution(int[] money) {
            int answer = -1;

            int[] dp = new int[money.length];
            dp[0] = money[0];
            dp[1] = money[1];
            dp[2] = Math.max(dp[0], 0) + money[2];
            for (int i = 3; i < money.length; i++) {
                dp[i] = Math.max(dp[i - 3], dp[i - 2]) + money[i];
            }
            answer = Math.max(dp[dp.length - 3], dp[dp.length - 2]);

            dp = new int[money.length];
            dp[0] = 0;
            dp[1] = money[1];
            dp[2] = money[2];
            for (int i = 3; i < money.length; i++) {
                dp[i] = Math.max(dp[i - 3], dp[i - 2]) + money[i];
            }

            answer = Math.max(answer, Math.max(dp[dp.length - 2], dp[dp.length - 1]));

            return answer;
        }
    }
}
