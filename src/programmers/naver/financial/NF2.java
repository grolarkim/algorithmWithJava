package programmers.naver.financial;

import java.util.*;

public class NF2 {
    public static void main(String[] args) {
        int[][] gates = {{1, 1, 5, 3}, {2, 2, 3, 3}, {1, 1, 4, 4}, {1, 0, 3, 6}, {0, 2, 5, 3}};
        int[] airlines = {3, 2, 5};
        System.out.println(Arrays.toString(new Solution().solution(gates, airlines)));
    }

    static class Solution {
        static int N, M;


        public int[] solution(int[][] gates, int[] airlines) {
            N = gates.length;
            M = gates[0].length;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (isPossible(gates[i], airlines)) {
                    list.add(i + 1);
                }
            }

            if (list.isEmpty()) {
                return new int[]{-1};
            }
            int[] anwser = new int[list.size()];
            for (int i = 0; i < anwser.length; i++) {
                anwser[i] = list.get(i);
            }

            return anwser;
        }

        static int[] select;
        static boolean p;

        private boolean isPossible(int[] arr, int[] airlines) {
            select = new int[arr.length];
            Arrays.fill(select, -1);
            p = false;
            dfs(arr, airlines, 0);

            return p;

        }

        private void dfs(int[] arr, int[] airlines, int depth) {
            if (p) {
                return;
            }

            if (depth == arr.length) {
                int[] sum = new int[3];
                for (int i = 0; i < select.length; i++) {
                    sum[select[i]] += arr[i];
                }
                if (sum[0] == airlines[0] && sum[1] == airlines[1] && sum[2] == airlines[2]) {
                    p = true;
                }
                return;
            }

            select[depth] = 0;
            dfs(arr, airlines, depth + 1);
            select[depth] = 1;
            dfs(arr, airlines, depth + 1);
            select[depth] = 2;
            dfs(arr, airlines, depth + 1);

        }
    }
}