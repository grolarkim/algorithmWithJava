package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Friends4block {
    public static void main(String[] args) {
        int a = solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
        System.out.println(a);
        int b = solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"});
        System.out.println(b);
    }

    static int M;
    static int N;
    static char[][] map;

    public static int solution(int m, int n, String[] board) {
        M = m;
        N = n;
        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        checkAll();

        return countChar();
    }

    private static int countChar() {
        int result = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '.') {
                    result++;
                }
            }
        }
        return result;
    }

    public static void checkAll() {
        int[] dx = {0, 1, 1};
        int[] dy = {1, 0, 1};
        Queue<int[]> q = new LinkedList<>();
        while (true) {
            // 4block check
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (checkOne(i, j)) {
                        q.offer(new int[]{i, j});
                    }
                }
            }
            // break
            if (q.isEmpty()) {
                break;
            }
            // remove blocks
            while (!q.isEmpty()) {
                int[] arr = q.poll();
                int i = arr[0];
                int j = arr[1];
                map[i][j] = '.';
                for (int k = 0; k < 3; k++) {
                    map[i + dx[k]][j + dy[k]] = '.';
                }
            }
            //rearrange
            for (int j = 0; j < N; j++) {
                Queue<Character> cq = new LinkedList<>();
                for (int i = M - 1; i >= 0; i--) {
                    if (map[i][j] != '.') {
                        cq.add(map[i][j]);
                    }
                }
                for (int i = M - 1; i >= 0; i--) {
                    if (!cq.isEmpty()) {
                        map[i][j] = cq.poll();
                    } else {
                        map[i][j] = '.';
                    }
                }
            }

        }
    }

    public static boolean checkOne(int i, int j) {
        if (map[i][j] == '.') {
            return false;
        }
        int[] dx = {0, 1, 1};
        int[] dy = {1, 0, 1};
        boolean[] result = {false, false, false};
        for (int k = 0; k < 3; k++) {
            if (i + dx[k] < M && j + dy[k] < N && map[i][j] == map[i + dx[k]][j + dy[k]]) {
                result[k] = true;
            }
        }
        return result[0] && result[1] && result[2];

    }
}
