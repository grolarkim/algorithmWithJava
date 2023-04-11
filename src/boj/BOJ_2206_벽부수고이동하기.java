package boj;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {
    static int N, M;
    static int answer = -1;
    static int[][] map;
    static int[][] v0;
    static int[][] v1;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = a.charAt(j) - '0';
            }
        }
        br.close();
        if (N == 1 && M == 1) {
            System.out.println(1);
            return;
        }

        v0 = new int[N][M];
        v1 = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                v0[i][j] = 10000000;
                v1[i][j] = 10000000;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1, 0});
        v0[0][0] = 1;

        bfs:
        while (!q.isEmpty()) {
            int[] n = q.poll();
            int x = n[0];
            int y = n[1];
            int cost = n[2];
            int breaked = n[3];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (nx == N - 1 && ny == M - 1) {
                    answer = cost + 1;
                    break bfs;
                }
                if (map[nx][ny] == 0) {
                    if (breaked == 0 && v0[nx][ny] > cost + 1) {
                        v0[nx][ny] = cost + 1;
                        q.add(new int[]{nx, ny, cost + 1, breaked});
                    } else if (breaked == 1 && v1[nx][ny] > cost + 1) {
                        v1[nx][ny] = cost + 1;
                        q.add(new int[]{nx, ny, cost + 1, breaked});
                    }
                } else if (breaked == 0 && v1[nx][ny] > cost + 1) {
                    v1[nx][ny] = cost + 1;
                    q.add(new int[]{nx, ny, cost + 1, breaked + 1});
                }
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
