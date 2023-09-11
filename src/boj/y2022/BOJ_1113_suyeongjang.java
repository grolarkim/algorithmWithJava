package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1113_suyeongjang {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 2][M + 2];
        visited = new boolean[10][N + 2][M + 2];

        for (int i = 1; i <= N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                map[i][j] = temp[j - 1] - '0';
            }
        }
        br.close();

        for (int i = 2; i < 10; i++) {
            visited[i][0][0] = true;
            dfs(0, 0, i);
        }

        int water = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int h = 0;
                for (int k = 9; k > 1; k--) {
                    if (!visited[k][i][j]) {
                        h = k - map[i][j];
                        break;
                    }
                }
                water += h;

            }
        }


        System.out.println(water);


    }

    private static void dfs(int x, int y, int h) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx > N + 1 || ny > M + 1 || visited[h][nx][ny] || map[nx][ny] >= h) {
                continue;
            }
            visited[h][nx][ny] = true;
            dfs(nx, ny, h);
        }

    }
}
