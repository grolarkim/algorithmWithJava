package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CM4 {
    //최소공통조상
    public static void main(String[] args) {
        int[] a = new CM4().solution(new int[][]{{1, 3}, {1, 2}, {2, 4}, {2, 5}}, new int[]{2, 3});
        int[] b = new CM4().solution(new int[][]{{1, 2}, {1, 3}, {2, 4}}, new int[]{3, 4, 1, 2});
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    static int N;
    static List<List<Integer>> lists;
    static int[][] parents;
    static int[] depths;
    static int[] indexes;

    static int[] result;

    public int[] solution(int[][] edges, int[] roots) {
        N = edges.length + 1;
        result = new int[edges.length];
        lists = new ArrayList<List<Integer>>();
        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }
        parents = new int[20][N + 1];
        depths = new int[N + 1];
        indexes = new int[N + 1];
        indexes[1] = -1;

        for (int i = 0; i < N - 1; i++) {
            int[] e = edges[i];
            lists.get(e[0]).add(e[1]);
            indexes[e[1]] = i;
            parents[0][e[1]] = e[0];
        }
        makeTree(1, 1);
        findAllParents();
        for (int i = 0; i < roots.length; i++) {
            int rr = 0;
            if (i == 0) {
                rr = lca(1, roots[i]);
                get(1, rr);
            } else {
                rr = lca(roots[i - 1], roots[i]);
                get(roots[i - 1], rr);
            }
            get(roots[i], rr);
        }


        return result;
    }

    private static void makeTree(int cur, int depth) {
        depths[cur] = depth;

        if (lists.get(cur).size() == 0 && cur != 1) {
            return;
        }

        for (int node : lists.get(cur)) {
            makeTree(node, depth + 1);
        }
    }

    private static void findAllParents() {
        for (int i = 1; i < 20; i++) {
            for (int j = 1; j <= N; j++) {
                parents[i][j] = parents[i - 1][parents[i - 1][j]];
            }
        }

    }

    private static int lca(int a, int b) {
        if (depths[a] > depths[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (depths[a] != depths[b]) {
            for (int i = 19; i >= 0; i--) {
                if (depths[parents[i][b]] >= depths[a]) {
                    b = parents[i][b];
                }
            }
        }
        if (a == b)
            return a;
        for (int i = 19; i >= 0; i--) {
            if (parents[i][b] != parents[i][a]) {
                a = parents[i][a];
                b = parents[i][b];
            }
        }

        return parents[0][a];
    }

    private static void get(int a, int rr) {
        if (a == 1) {
            return;
        }
        while (a != rr) {
            result[indexes[a]] += 1;
            a = parents[0][a];
        }
    }


}
