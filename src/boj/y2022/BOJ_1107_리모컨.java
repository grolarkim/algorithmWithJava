package boj.y2022;

import java.util.Scanner;

public class BOJ_1107_리모컨 {
	static String target;
	static int targetInt;
	static int M;
	static boolean[] broken = new boolean[10];
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		target = sc.next();
		targetInt = Integer.parseInt(target);
		M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			broken[sc.nextInt()] = true;
		}
		sc.close();
		result = Math.abs(targetInt - 100);

		for (int i = 0; i < 1000000; i++) {
			String str = String.valueOf(i);
			boolean breaked = false;
			for (int j = 0; j < str.length(); j++) {
				if (broken[str.charAt(j) - '0']) {
					breaked = true;
					break;
				}
			}
			if (!breaked) {
				result = Math.min(result, Math.abs(targetInt - i) + str.length());
			}

		}
		System.out.println(result);
	}

}
