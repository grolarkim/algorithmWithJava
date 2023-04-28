package programmers;

import java.util.*;

public class gyeongjurogunseol {
    public static void main(String[] args) {
        int[][] b1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] b2 = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};
        int[][] b3 = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        int[][] b4 = {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}};

        int a1 = solution(b1);
        int a2 = solution(b2);
        int a3 = solution(b3);
        int a4 = solution(b4);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);

    }

    // 하 우 상 좌 반시계
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int N;
    private static int[][][] cost;

    private static PriorityQueue<Node> pq;

    public static int solution(int[][] board) {
        N = board.length;
        cost = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    cost[i][j][k] = 2_000_000_000;
                }
            }
        }
        pq = new PriorityQueue<>();
        if (board[0][1] == 0) {
            pq.add(new Node(0, 1, 1, 100));
        }
        if (board[1][0] == 0) {
            pq.add(new Node(1, 0, 0, 100));
        }
        for (int i = 0; i < 4; i++) {
            cost[0][0][i] = 0;
        }
        cost[0][1][1] = 100;
        cost[1][0][0] = 100;

        while (!pq.isEmpty()) {
            Node n = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nr = n.r + dx[i];
                int nc = n.c + dy[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || board[nr][nc] == 1) {
                    continue;
                }

                if (n.dir == i && cost[nr][nc][i] > n.cost + 100) {
                    cost[nr][nc][i] = n.cost + 100;
                    pq.add(new Node(nr, nc, i, n.cost + 100));
                } else if (cost[nr][nc][i] > n.cost + 600) {
                    cost[nr][nc][i] = n.cost + 600;
                    pq.add(new Node(nr, nc, i, n.cost + 600));
                }

            }
        }
        int answer = Arrays.stream(cost[N - 1][N - 1]).min().getAsInt();
        return answer;
    }

    private static class Node implements Comparable<Node> {
        int r;
        int c;
        int dir;
        int cost;

        public Node(int r, int c, int dir, int cost) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
