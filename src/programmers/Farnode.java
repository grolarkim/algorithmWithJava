package programmers;

import java.util.*;

public class Farnode {
    public static void main(String[] args) {
        int a = new Farnode().solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
        System.out.println(a);
    }

    static List<List<Integer>> graph;
    static int[] distance;
    static boolean[] visited;

    public int solution(int n, int[][] edge) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        bfs();
        int max = 0;
        int answer = 0;
        for (int temp : distance) {
            max = Math.max(max, temp);
        }
        for (int temp : distance) {
            if (temp == max) {
                answer++;
            }
        }
        return answer;
    }

    private void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[now] + 1;
                    q.offer(next);
                }
            }
        }
    }
}
