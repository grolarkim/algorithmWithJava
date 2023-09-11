package boj.y2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14442_벽부수고이동하기 {
    static int N, M, K, result;
    static int[][] map;
    static boolean[][][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;
        map = new int[N][M];
        visited = new boolean[N][M][K + 1];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = chars[j] - '0';
            }
        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.x == N - 1 && now.y == M - 1) {
                result = Math.min(result, now.dist + 1);
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if ((map[nx][ny] == 0 && visited[nx][ny][now.b])
                        || (map[nx][ny] == 1 && (now.b + 1 > K || visited[nx][ny][now.b + 1]))) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    q.add(new Node(nx, ny, now.dist + 1, now.b));
                    visited[nx][ny][now.b] = true;
                } else {
                    q.add(new Node(nx, ny, now.dist + 1, now.b + 1));
                    visited[nx][ny][now.b + 1] = true;
                }
            }
        }
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

    private static class Node {
        int x;
        int y;
        int dist;
        int b;

        public Node(int x, int y, int dist, int b) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.b = b;
        }

        public Node() {
        }
    }
}
