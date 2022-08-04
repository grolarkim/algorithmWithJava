package boj;

import java.util.Scanner;
import java.util.stream.Stream;

public class BOJ_1541_잃어버린괄호 {
	static String[] str;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.next().split("\\-");
		sc.close();

		int result = strToInt(str[0]);
		for (int i = 1; i < str.length; i++) {
			result -= strToInt(str[i]);
		}
		System.out.println(result);

	}

	public static int strToInt(String string) {
		int sum = Stream.of(string.split("\\+")).mapToInt(Integer::parseInt).sum();
		return sum;
	}
}
