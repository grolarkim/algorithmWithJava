package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1959_두개의숫자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i<=T;i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] Ai = new int[N];
			int[] Bj = new int[M];
			for (int j =0; j<N; j++) {
				Ai[j] = sc.nextInt();
			}
			for (int j =0; j<M; j++) {
				Bj[j] = sc.nextInt();
			}
			int cases;
			int[] l;
			int[] s;
			if (N>M) {
				cases = N-M+1;
				l = Ai;
				s = Bj;				
			} else {
				cases = M-N+1;
				l = Bj;
				s = Ai;
			}
			int[] arr = new int[cases];
			for (int j =0; j<cases; j++) {
				int sum = 0;
				for (int k =0; k<s.length;k++) {
					sum += s[k]*l[k+j];
				}
				arr[j] = sum;
			}
			int max = Arrays.stream(arr).max().getAsInt();
			System.out.println("#"+i+" "+max);
		}
	}
}
