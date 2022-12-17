package programmers.naver.financial;

//import java.util.*;

import java.util.Arrays;

public class NF1 {
    public static void main(String[] args) {
        int[] periods = {20, 23, 24};
        int[][] payments = {{}, {}, {}};
        int[] estimates = {100000, 100000, 100000};
        System.out.println(Arrays.toString(new Solution().solution(periods, payments, estimates)));
    }

    static class Solution {
        public int[] solution(int[] periods, int[][] payments, int[] estimates) {
            boolean[] nowVip = new boolean[periods.length];
            boolean[] nextVip = new boolean[periods.length];
            for (int i = 0; i < periods.length; i++) {
                int sumNow = sum(payments[i]);
                int sumNext = sum(payments[i], estimates[i]);
                if (periods[i] < 24) {

                } else if (periods[i] < 60) {
                    if (sumNow >= 900_000) {
                        nowVip[i] = true;
                    }
                } else {
                    if (sumNow >= 600_000) {
                        nowVip[i] = true;
                    }
                }
                if (periods[i] + 1 < 24) {

                } else if (periods[i] + 1 < 60) {
                    if (sumNext >= 900_000) {
                        nextVip[i] = true;
                    }
                } else {
                    if (sumNext >= 600_000) {
                        nextVip[i] = true;
                    }
                }
            }
            int[] anwser = new int[2];

            for (int i = 0; i < periods.length; i++) {
                if (!nowVip[i] && nextVip[i]) {
                    anwser[0] += 1;
                } else if (nowVip[i] && !nextVip[i]) {
                    anwser[1] += 1;
                }
            }

            return anwser;
        }
    }

    static int sum(int[] arr) {
        int a = 0;
        for (int b : arr) {
            a += b;
        }
        return a;
    }

    static int sum(int[] arr, int est) {
        int a = 0;
        for (int b : arr) {
            a += b;
        }
        a = a - arr[0] + est;
        return a;
    }
}
