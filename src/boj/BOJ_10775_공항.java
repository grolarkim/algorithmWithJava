package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10775_공항 {
    static int G, P;
    static boolean[] gates;
    static int[] nextGates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        gates = new boolean[G + 1];
        nextGates = new int[G + 1];
        for (int i = 0; i <= G; i++) {
            nextGates[i] = i;
        }
        for (int i = 0; i < P; i++) {

        }


    }

    private static int getNextGate(int x) {
        if (nextGates[x] == x) {
            return x;
        }
        return nextGates[x] = getNextGate(x);
    }
}
