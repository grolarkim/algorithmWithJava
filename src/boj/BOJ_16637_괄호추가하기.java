package boj;

import java.util.Scanner;

public class BOJ_16637_괄호추가하기 {
	public static int N;
	public static int[] nArr;
	public static boolean[] bArr;
	public static char[] oArr;
	public static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		String line = sc.next();
		sc.close();

		nArr = new int[N / 2 + 1];
		bArr = new boolean[N / 2 + 1];
		oArr = new char[N / 2];
		for (int i = 0; i < N / 2 + 1; i++) {
			nArr[i] = line.charAt(i * 2) - '0';
		}
		for (int i = 0; i < N / 2; i++) {
			oArr[i] = line.charAt(i * 2 + 1);
		}
		dfs(0);

		System.out.println(max);

	}

	public static void dfs(int depth) {
		if (depth >= N / 2) {
			max = Math.max(max, getValue());
			return;
		}

		dfs(depth + 1);
		if (depth == 0 || !bArr[depth - 1]) {
			bArr[depth] = true;
			dfs(depth + 1);
			bArr[depth] = false;
		}

	}

	public static int getValue() {
		int[] nList = nArr.clone();
		char[] oList = oArr.clone();

		for (int i = 0; i < N / 2; i++) {
			if (bArr[i]) {
				int temp = operate(nList[i], oList[i], nList[i + 1]);
				nList[i] = temp;
				nList[i + 1] = 0;
				oList[i] = '+';
			}
		}
		int result = nList[0];
		for (int i = 0; i < N / 2; i++) {
			result = operate(result, oList[i], nList[i + 1]);
		}

		return result;
	}

	public static int operate(int num, char op, int next) {
		if (op == '+') {
			return num + next;
		} else if (op == '-') {
			return num - next;
		} else {
			return num * next;
		}
	}

}
