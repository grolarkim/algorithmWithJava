package boj.y2022;

import java.util.Scanner;

public class BOJ_1904_01타일 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		int[] arr = new int[N+1]; 
				
		for(int i = 0;i<=N;i++) {
			if(i<4) {
				arr[i] = i;
			} else {
				arr[i] = (arr[i-2]*2+arr[i-3])%15746;
			}
		}
		System.out.println(arr[N]);
		
	}

}
