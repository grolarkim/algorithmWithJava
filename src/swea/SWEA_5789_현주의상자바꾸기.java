package swea;

import java.util.Scanner;

public class SWEA_5789_현주의상자바꾸기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int Q = sc.nextInt();
			int[] boxes = new int[N];
			int[] larr = new int[Q];
			int[] rarr = new int[Q];
			for (int i = 0; i < Q; i++) {
				larr[i] = sc.nextInt();
				rarr[i] = sc.nextInt();
			}
			for (int i = 0; i < Q; i++) {
				for (int j = larr[i] - 1; j < rarr[i]; j++) {
					boxes[j] = i + 1;
				}
			}
			System.out.print("#" + test_case);
			for (int i = 0; i < N; i++) {
				System.out.print(" "+boxes[i]);
			}
			System.out.println();
		}
	}
}
