package boj;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {

    static int N;
    static int M;
    static int[][] map;
    static boolean fail;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        fail = false;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = simulation();
        if (fail) {
            bw.write(String.valueOf(0));
        } else {
            bw.write(String.valueOf(result));
        }
        bw.flush();
        bw.close();
        br.close();

    }

    private static int simulation() {
        int result = 0;
        while (true) {
            if (iceBreak()) {
                break;
            }
            int[][] newMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0) {
                        int waters = 0;
                        for (int d = 0; d < 4; d++) {
                            if (map[i + dx[d]][j + dy[d]] == 0) waters++;
                        }
                        newMap[i][j] = Math.max(0, map[i][j] - waters);
                    }
                }
            }
            map = newMap;
            result++;
        }

        return result;
    }

    private static boolean iceBreak() {
        int iceCnt = 0;
        int sx = 0;
        int sy = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    iceCnt++;
                    sx = i;
                    sy = j;
                }
            }
        }

        if (sx == 0) {
            fail = true;
            return true;
        }

        int bfsCnt = 1;
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});
        visited[sx][sy] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                if (!visited[now[0] + dx[i]][now[1] + dy[i]] && map[now[0] + dx[i]][now[1] + dy[i]] != 0) {
                    q.add(new int[]{now[0] + dx[i], now[1] + dy[i]});
                    visited[now[0] + dx[i]][now[1] + dy[i]] = true;
                    bfsCnt++;
                }
            }
        }
        if (bfsCnt != iceCnt) {
            return true;
        }
        return false;
    }
}
