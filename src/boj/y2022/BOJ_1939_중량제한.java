package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1939_중량제한 {
    static int N, M, A, B;

    static class Bridge {
        int to;
        int cost;

        public Bridge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static List<List<Bridge>> lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lists = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists.get(f).add(new Bridge(t, c));
            lists.get(t).add(new Bridge(f, c));
        }
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = 1_000_000_000;
        int mid = 500_000_000;
        while (left < right) {
            mid = (left + right) / 2;
            boolean can = bfs(mid);
            if (can) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (bfs(left)) {
            System.out.println(left);
        } else {
            System.out.println(left - 1);
        }


    }

    private static boolean bfs(int mid) {
        boolean[] visited = new boolean[N + 1];
        visited[A] = true;
        Queue<Bridge> q = new LinkedList<>();
        q.add(new Bridge(A, 0));
        while (!q.isEmpty()) {
            Bridge b = q.poll();
            if (b.to == B) {
                return true;
            }
            for (Bridge nb : lists.get(b.to)) {
                if (!visited[nb.to] && nb.cost >= mid) {
                    visited[nb.to] = true;
                    q.add(nb);
                }
            }
        }

        return false;
    }

}
