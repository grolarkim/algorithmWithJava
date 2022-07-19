package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2805_농작물수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				farm[i] = Arrays.stream(sc.next().split("")).mapToInt(Integer::parseInt).toArray();
			}
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if(i<=N/2) {
					for(int j=N/2-i;j<=N/2+i;j++) {
						sum += farm[i][j];
					}					
				} else {
					for(int j=i-N/2;j<=(N/2)*3-i;j++) {
						sum += farm[i][j];
					}										
				}
			}
			System.out.println("#"+test_case+" "+sum);
		}
	}
}
