package boj;

import java.util.Scanner;

public class BOJ_1629_곱셈 {
	public static long A;
	public static long B;
	public static long C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextLong();
		B = sc.nextLong();
		C = sc.nextLong();
		sc.close();

		long result = multi(B);
		System.out.println(result);
	}

	public static long multi(Long now) {
		if (now == (long) 1) {
			return A % C;
		}

		long temp = multi(now / 2) % C;
		long result;
		if (now % 2 == 0) {
			result = temp * temp % C;
		} else {
			result = ((temp * temp) % C) * A % C;
		}
		return result;
	}
}
