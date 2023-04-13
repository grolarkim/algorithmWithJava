package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10775_공항 {
    static int G, P;
    static int[] nextGates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        nextGates = new int[G + 1];
        for (int i = 0; i <= G; i++) {
            nextGates[i] = i;
        }
        int cnt = 0;
        for (int i = 0; i < P; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = getNextGate(a);
            if (b == 0) {
                break;
            }
            union(b, b - 1);
            cnt++;
        }

        System.out.println(cnt);


    }

    private static void union(int x, int y) {
        int a = getNextGate(x);
        int b = getNextGate(y);
        nextGates[a] = b;
    }

    private static int getNextGate(int x) {
        if (x == nextGates[x]) {
            return nextGates[x];
        }
        return nextGates[x] = getNextGate(nextGates[x]);
    }
}
