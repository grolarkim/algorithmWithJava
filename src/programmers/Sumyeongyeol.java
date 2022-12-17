package programmers;

import java.util.*;

public class Sumyeongyeol {
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

        System.out.println(new Solution().solution(n, costs));
    }

    static class Solution {
        private static final int INF = 1_000_000_000;

        public int solution(int n, int[][] costs) {
            if (n == 1) {
                return 0;
            }
            // mst - prim
            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < costs.length; i++) {
                graph.get(costs[i][0]).add(new Edge(costs[i][1], costs[i][2]));
                graph.get(costs[i][1]).add(new Edge(costs[i][0], costs[i][2]));
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[n];

            q.add(0);

            int answer = 0;

            while (!q.isEmpty()) {
                int now = q.poll();
                visited[now] = true;
                for (Edge e : graph.get(now)) {
                    if (!visited[e.to]) {
                        pq.add(e);
                    }
                }
                while (!pq.isEmpty()) {
                    Edge next = pq.poll();
                    if (!visited[next.to]) {
                        q.add(next.to);
                        visited[next.to] = true;
                        answer += next.cost;
                        break;
                    }
                }
            }
            return answer;
        }

        public static class Edge implements Comparable<Edge> {
            int to;
            int cost;

            public Edge(int to, int cost) {
                this.to = to;
                this.cost = cost;
            }

            @Override
            public int compareTo(Edge o) {
                return this.cost - o.cost;
            }
        }
    }
}
