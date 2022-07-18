package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2063_중간값찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int a = (T/2);
		int[] arr = new int[T];
		for (int i =0; i<T; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		System.out.println(arr[a]);
	}
}
