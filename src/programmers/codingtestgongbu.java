package programmers;

import java.util.*;

public class codingtestgongbu {
    public static void main(String[] args) {

    }

    public static int solution(int alp, int cop, int[][] problems) {
        int[][] dp = new int[300][300];
        List<int[]> pl = new ArrayList<>(8);
        pl.add(new int[]{0, 0, 1, 0, 1});
        pl.add(new int[]{0, 0, 0, 1, 1});
        for (int[] p : problems) {
            pl.add(p);
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{alp, cop, 0});
        while (!q.isEmpty()) {
            int[] n = q.poll();
            int x = n[0];
            int y = n[1];
            int cost = n[2];
            if (x >= alp && y >= cop) {
                continue;
            }
            for (int[] p : pl) {

            }

        }

        int answer = 0;
        return answer;
    }
}
