package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2001_파리퇴치 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] flys = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					flys[i][j] = sc.nextInt();
				}
			}
			int cases = N-M+1;
			int[] resultarr = new int[cases*cases];
			for(int i=0;i<cases;i++) {
				for(int j=0;j<cases;j++) {
					int mm = 0;
					for(int a=0;a<M;a++) {
						for(int b=0;b<M;b++) {
							mm += flys[i+a][j+b];
						}
					}
					resultarr[i*cases+j]=mm;
				}
			}
			Arrays.sort(resultarr);
			System.out.println("#"+test_case+" "+resultarr[resultarr.length-1]);
			
		}
	}
}
