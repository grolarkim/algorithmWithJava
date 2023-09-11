package boj.y2022;

import java.util.Scanner;

public class BOJ_11401_이항계수3 {
	static long[] fac;
	static final long MOD = 1_000_000_007;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		fac = new long[4_000_001];
		fac[0] = 1;
		for (int i = 1; i < fac.length; i++) {
			fac[i] = (fac[i - 1] * i) % MOD;
		}
		
		// fermat's little theorem
		long fn = fac[N];
		long fk = (fac[N - K] * fac[K]) % MOD;
		fk = pow(fk, MOD - 2);
		long result = (fn * fk) % MOD;
		
		System.out.println(result);
	}
	
	private static long pow(long num, long degree) {
		if (degree == 0)
			return 1;
		if (degree == 1)
			return num;
		long temp = pow(num, degree / 2);
		long result = (temp * temp) % MOD;
		if (degree % 2 == 1) {
			result = (result * num) % MOD;
		}
		return result;
	}
}
