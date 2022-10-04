package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_13977_이항계수와쿼리 {
	static long[] fac;
	static final long MOD = 1_000_000_007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		fac = new long[4_000_001];
		fac[0] = 1;
		for (int i = 1; i < fac.length; i++) {
			fac[i] = (fac[i - 1] * i) % MOD;
		}

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			bw.write(getResult(N, K) + "\n");

		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static long getResult(int n, int k) {
		// 페르마의 소정리 Fermat's little theorem
		long fn = fac[n];
		long fk = (fac[n - k] * fac[k]) % MOD;
		fk = pow(fk, MOD - 2);
		return (fn * fk) % MOD;
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
