package boj;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485_젤다 {
    static int N;
    static int[][] map;
    static int[][] dis;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Node implements Comparable<Node> {
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        int x;
        int y;
        int cost;

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 0;
        while (true) {
            cnt++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            map = new int[N][N];
            dis = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dis[i][j] = 1_000_000_000;
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0, 0, map[0][0]));

            dijkstra:
            while (!pq.isEmpty()) {
                Node n = pq.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = n.x + dx[i];
                    int ny = n.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        continue;
                    }
                    if (dis[nx][ny] > n.cost + map[nx][ny]) {
                        dis[nx][ny] = n.cost + map[nx][ny];
                        pq.add(new Node(nx, ny, dis[nx][ny]));
                    }
                    if (nx == N - 1 && ny == N - 1) {
                        break dijkstra;
                    }

                }
            }

            bw.write("Problem " + Integer.toString(cnt) + ": " + Integer.toString(dis[N - 1][N - 1]) + "\n");
            
            bw.flush();


        }


    }
}
