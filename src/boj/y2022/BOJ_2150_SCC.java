package boj.y2022;

import java.io.*;
import java.util.*;

public class BOJ_2150_SCC {
    private static int V, E, ID;
    private static List<List<Integer>> graph;
    private static int[] parent;
    private static boolean[] finished;
    private static Stack<Integer> stack;
    private static List<List<Integer>> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        ID = 1;

        graph = new ArrayList<>(V + 1);
        parent = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        finished = new boolean[V + 1];
        answer = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        stack = new Stack<>();

        for (int i = 1; i <= V; i++) {
            if (parent[i] == 0) {
                dfs(i);
            }
        }

        for (List<Integer> l : answer) {
            l.sort(Comparator.comparingInt(o -> o));
        }
        answer.sort(Comparator.comparingInt(o -> o.get(0)));
        bw.write(Integer.toString(answer.size()) + "\n");
        for (List<Integer> l : answer) {
            for (Integer i : l) {
                bw.write(Integer.toString(i) + " ");
            }
            bw.write("-1\n");
        }
        br.close();
        bw.flush();
        bw.close();

    }

    private static int dfs(int x) {
        parent[x] = ID++;
        stack.add(x);

        int result = parent[x];
        for (int n : graph.get(x)) {
            if (parent[n] == 0) {
                result = Math.min(dfs(n), result);
            } else if (!finished[n]) {
                result = Math.min(parent[n], result);
            }
        }
        if (result == parent[x]) {
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                int a = stack.pop();
                list.add(a);
                finished[a] = true;
                if (a == x) {
                    break;
                }
            }
            answer.add(list);
        }
        return result;
    }
}
