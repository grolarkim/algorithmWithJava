package boj.y2022;

import java.util.Scanner;

public class BOJ_2491_수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int result = Math.max(up(arr), down(arr));
		System.out.println(result);
	}

	public static int up(int[] arr) {
		int result = 1;
		int cnt = 1;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i-1]<=arr[i]) {
				cnt += 1;
			} else {
				cnt = 1;
			}
			result = Math.max(result, cnt);
		}		
		return result;
	}

	public static int down(int[] arr) {
		int result = 1;
		int cnt = 1;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i-1]>=arr[i]) {
				cnt += 1;
			} else {
				cnt = 1;
			}
			result = Math.max(result, cnt);
		}
		return result;
	}

}
