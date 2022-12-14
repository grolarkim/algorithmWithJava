package boj;

import java.util.*;

public class BOJ_15685_드래곤커브 {
    static int N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] checked;
    static Node[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        checked = new boolean[101][101];
        // 입력 후
        for (int i = 0; i < N; i++) {
            list = new Node[1025];
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();

            list[0] = new Node(x, y);
            makeDragonCurve(0, d, g, 0);
        }

        int result = getRectangles();
        System.out.println(result);
    }

    private static void makeDragonCurve(int lastIdx, int d, int g, int depth) {
        if (depth == 0) {
            int x = list[0].x;
            int y = list[0].y;
            list[1] = new Node(x + dx[d], y + dy[d]);
            lastIdx = 1;
        } else {
            // 1일때 0 1 2 - 1
            // 2일때 012 34 - 2
            for (int i = 1; i <= lastIdx; i++) {
                list[lastIdx + i] = getRotatedNode(list[lastIdx], list[lastIdx - i]);
            }
            lastIdx *= 2;
        }

        if (g == depth) {
            for (Node node : list) {
                if (node != null) {
                    checked[node.x][node.y] = true;
                } else {
                    break;
                }
            }
            return;
        }
        makeDragonCurve(lastIdx, d, g, depth + 1);
    }

    private static Node getRotatedNode(Node axis, Node node) {
        int ax = axis.x;
        int ay = axis.y;
        int nx = node.x;
        int ny = node.y;
        int nextx = -(ny - ay) + ax;
        int nexty = (nx - ax) + ay;
        return new Node(nextx, nexty);
    }


    private static int getRectangles() {
        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (checked[i][j] && checked[i + 1][j] && checked[i][j + 1] && checked[i + 1][j + 1]) {
                    result++;
                }
            }
        }
        return result;
    }

    static class Node {
        public int x;
        public int y;

        public Node() {
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

    }
}
