package boj.y2022;

import java.util.Scanner;

public class BOJ_3687_성냥개비 {
    static int[] mins = {0, 0, 1, 7, 4, 2, 6, 8, 10, 18, 22, 20, 28, 68, 88, 108, 188, 200, 208, 288, 688, 888};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            String an = getMin(a) + " " + getMax(a);
            System.out.println(an);
        }
    }

    private static String getMin(int a) {
        StringBuilder sb = new StringBuilder();
        if (a < 21) {
            return Integer.toString(mins[a]);
        }
        int b = a % 7;
        int c = (a - b - 14) / 7;
        sb.append(mins[b + 14]);
        for (int i = 0; i < c; i++) {
            sb.append(8);
        }

        return sb.toString();
    }

    private static String getMax(int a) {
        StringBuilder sb = new StringBuilder();
        if (a % 2 == 1) {
            sb.append(7);
            int b = (a - 3) / 2;
            for (int i = 0; i < b; i++) {
                sb.append(1);
            }
        } else {
            for (int i = 0; i < a / 2; i++) {
                sb.append(1);
            }
        }
        return sb.toString();
    }
}
