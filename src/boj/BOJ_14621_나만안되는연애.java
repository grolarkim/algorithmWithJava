package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14621_나만안되는연애 {
    static int N, M;

    static boolean[] mw;

    static List<List<Edge>> lists;

    static int[] parents;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        mw = new boolean[N + 1];
        parents = new int[N + 1];

        lists = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
            lists.add(new ArrayList<>());
        }

        // gender input
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            char gender = st.nextToken().charAt(0);
            if (gender == 'M') {
                mw[i] = true;
            } else {
                mw[i] = false;
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        // edges input
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (mw[from] != mw[to]) {
                lists.get(from).add(new Edge(from, to, cost));
                lists.get(to).add(new Edge(to, from, cost));
                pq.add(new Edge(from, to, cost));
            }
        }

        int anwser = 0;
        //kruskal
        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            if (union(e.from, e.to)) {
                anwser += e.cost;
            }
        }

        for (int i = 2; i <= N; i++) {
            if (getParent(1) != getParent(i)) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(anwser);

    }

    private static boolean union(int x, int y) {
        int px = getParent(x);
        int py = getParent(y);

        if (px == py) {
            return false;
        }
        parents[px] = py;

        return true;
    }

    private static int getParent(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = getParent(parents[x]);
    }

    private static class Edge implements Comparable<Edge> {

        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
