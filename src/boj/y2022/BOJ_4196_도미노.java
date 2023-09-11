package boj.y2022;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_4196_도미노 {
    private static int T, N, M, ID;
    private static List<List<Integer>> graph;
    private static List<List<Integer>> rev;

    private static boolean[] visited;
    private static int[] group;

    private static Stack<Integer> stack;
    private static int[] indegree;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            visited = new boolean[N + 1];
            group = new int[N + 1];
            ID = 1;
            graph = new ArrayList<>();
            rev = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
                rev.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                rev.get(b).add(a);
            }
            stack = new Stack<>();
            indegree = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    fdfs(i);
                }
            }
            while (!stack.isEmpty()) {
                if (group[stack.peek()] == 0) {
                    rdfs(stack.peek());
                    ID++;
                }
                stack.pop();
            }
            int result = 0;
            for (int i = 1; i < ID; i++) {
                if (indegree[i] == 0) {
                    result++;
                }
            }
            System.out.println(result);

        }
        br.close();
    }

    private static void fdfs(int x) {
        visited[x] = true;
        for (int n : graph.get(x)) {
            if (!visited[n]) {
                fdfs(n);
            }
        }
        stack.add(x);
    }

    private static void rdfs(int x) {
        group[x] = ID;
        for (int n : rev.get(x)) {
            if (group[n] == 0) {
                rdfs(n);
            } else if (group[n] != group[x]) {
                indegree[group[x]]++;
            }
        }

    }
}
