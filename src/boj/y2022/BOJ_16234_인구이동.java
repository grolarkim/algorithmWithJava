package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16234_인구이동 {
    static int N, L, R, cnt;
    static int[][] map;
    static int[][] num;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        cnt = 0;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        while (cnt < 2001) {

            cnt++;
            num = new int[N][N];
            int numcnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (num[i][j] == 0) {
                        numcnt++;
                        int sumcnt = 1;
                        int sum = map[i][j];
                        Queue<Integer> q = new LinkedList<>();
                        List<Integer> l = new ArrayList<>();
                        q.add(i);
                        q.add(j);
                        l.add(i);
                        l.add(j);
                        num[i][j] = numcnt;
                        while (!q.isEmpty()) {
                            int x = q.poll();
                            int y = q.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = x + dx[k];
                                int ny = y + dy[k];
                                if (nx < 0 || ny < 0 || nx >= N || ny >= N || num[nx][ny] != 0) {
                                    continue;
                                }
                                if (Math.abs(map[x][y] - map[nx][ny]) < L || Math.abs(map[x][y] - map[nx][ny]) > R) {
                                    continue;
                                }
                                num[nx][ny] = numcnt;
                                sum += map[nx][ny];
                                sumcnt++;
                                q.add(nx);
                                q.add(ny);
                                l.add(nx);
                                l.add(ny);
                            }
                        }
                        int avg = sum / sumcnt;
                        int size = l.size() / 2;
                        for (int k = 0; k < size; k++) {
                            int x = l.get(2 * k);
                            int y = l.get(2 * k + 1);
                            map[x][y] = avg;
                        }

                    }
                }

            }


            if (num[N - 1][N - 1] == N * N) {
                break;
            }

        }

        System.out.println(cnt - 1);

    }


}
