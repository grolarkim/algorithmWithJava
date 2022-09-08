package boj;

import java.util.Scanner;

public class BOJ_1669_멍멍이쓰다듬기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.close();
		int a = (int) Math.sqrt(M-N);
		int result = 0;
		if(M==N) {
			result = 0;
		} else if(M-N==(a)*(a)) {
			result = 2*a-1;
		} else if(M-N==(a+1)*(a+1)) {
			result = 2*a+1;
		} else if(M-N>(a+1)*a) {
			result = 2*a+1;
		} else {
			result = 2*a;
		}
		System.out.println(result);
		
	}
}
