package boj;

import java.util.Scanner;

public class BOJ_2749_피보나치수3 {
	static final int MOD = 1_000_000;
	static final int PISANO = 1_500_000;
	static int[] fibo = new int[PISANO + 1];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();

		N = N % PISANO;
		fibo[1] = 1;
		for (int i = 2; i <= PISANO; i++)
			fibo[i] = (fibo[i - 1] + fibo[i - 2]) % MOD;

		System.out.println(fibo[(int) N]);
	}

}
