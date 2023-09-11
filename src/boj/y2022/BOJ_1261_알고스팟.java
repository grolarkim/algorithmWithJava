package boj.y2022;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1261_알고스팟 {
    static int N, M, answer;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        dijkstra();
        System.out.println(answer);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][] costs = new int[N][M];
        for (int[] arr : costs) {
            Arrays.fill(arr, 1_000_000_000);
        }
        boolean[][] visited = new boolean[N][M];
        pq.offer(new Node(0, 0, 0));
        costs[0][0] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.x][now.y]) continue;
            visited[now.x][now.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (costs[nx][ny] > map[nx][ny] + now.cost) {
                    costs[nx][ny] = map[nx][ny] + now.cost;
                    pq.offer(new Node(nx, ny, costs[nx][ny]));
                }
            }
        }
        answer = costs[N - 1][M - 1];
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
