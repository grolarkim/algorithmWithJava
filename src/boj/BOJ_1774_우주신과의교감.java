package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1774_우주신과의교감 {
    static int N, M;
    static int[][] coo;
    static int[] parent;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        coo = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            coo[i][0] = Integer.parseInt(st.nextToken());
            coo[i][1] = Integer.parseInt(st.nextToken());
        }
        parent = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    pq.add(new Edge(i, j, coo[i][0], coo[i][1], coo[j][0], coo[j][1]));
                }
            }
        }
        double cost = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (union(e.x, e.y)) {
                cost += e.dis;
            }
        }

        System.out.printf("%.2f", cost).println();

    }

    public static class Edge implements Comparable<Edge>{
        int x;
        int y;

        double dis;

        public Edge(int x, int y, int x1, int y1, int x2, int y2) {
            this.x = x;
            this.y = y;
            this.dis = Math.pow(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2), 0.5);
        }


        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.dis, o.dis);
        }
    }


    private static int findParent(int x){
        if (parent[x] == x){
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    private static boolean union(int x, int y){
        int px = findParent(x);
        int py = findParent(y);
        if (px == py) {
            return false;
        }
        parent[px] = py;
        return true;
    }

}
