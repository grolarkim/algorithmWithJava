package programmers;

import java.util.Arrays;

public class Choigoeuijiphap {
    public static void main(String[] args) {
        int[] a = new Solution().solution(3, 9);
        System.out.println(Arrays.toString(a));

    }

    private static class Solution {
        public int[] solution(int n, int s) {
            if (n > s) {
                return new int[]{-1};
            }
            int[] answer = new int[n];
            int a = s / n;
            int b = s % n;
            for (int i = 0; i < n; i++) {
                answer[i] = a;
            }
            for (int i = n - 1; i > n - 1 - b; i--) {
                answer[i] += 1;
            }
            return answer;
        }
    }

}
