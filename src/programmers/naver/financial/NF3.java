package programmers.naver.financial;

import java.util.*;

public class NF3 {
    public static void main(String[] args) {
        int[][] games = {{66000, 0, 50}, {16000, 2, 10}, {84500, 3, 20}, {5500, 2, 75}};
//        int[][] games = {{100, 0, 50}, {1000, 0, 50}, {10000, 0, 50}};
        System.out.println(new Solution().solution(games));
    }

    static class Solution {
        int solution(int[][] games) {
//            dp
            int n = games.length;


            //최대힙
//            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += games[i][0];
            }
            int max = 0;
            for (int i = n - 1; i >= 0; i--) {
                boolean[] visited = new boolean[n];
                int dis = 0;
                PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
                int[][] discount = new int[n][n];
                for (int j = 0; j < n; j++) {
                    if (games[j][1] > i) {
                        pq.add(new int[]{j, 0});
                    } else {
                        discount[games[j][1]][j] = (games[j][0] / 100) * games[j][2];
                        pq.add(new int[]{j, (games[j][0] / 100) * games[j][2]});
                    }
                }
                for (int j = 0; j < n - i - 1; j++) {
                    int[] a = pq.poll();
                    dis += a[1];
                    visited[a[0]] = true;
                }
                for (int j = 0; j <= i; j++) {
                    int m = 0;
                    int idx = -1;
                    for (int k = 0; k < n; k++) {
                        if (discount[j][k] != 0 && !visited[k]) {
                            m = Math.max(m, discount[j][k]);
                            idx = k;
                        }
                    }
                    if (idx != -1) {
                        dis += m;
                        visited[idx] = true;
                    }
                }
                max = Math.max(max, dis);
            }


            // dp
            return sum - max;
        }
    }
}
