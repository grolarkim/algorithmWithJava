package swea;

import java.util.Scanner;

public class SWEA_6485_삼성시의버스노선 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] Aarr = new int[N];
			int[] Barr = new int[N];
			
			for(int i = 0; i < N; i++) {
				Aarr[i] = sc.nextInt();
				Barr[i] = sc.nextInt();				
			}
			
			int P = sc.nextInt();
			int[] Carr = new int[P];
			for(int i = 0; i < P; i++) {
				Carr[i] = sc.nextInt();
			}
			
			int[] result = new int[P];
			
			for(int i = 0; i < P; i++) {
				int cnt = 0;
				for(int j = 0; j < N; j++) {
					if(Carr[i] >= Aarr[j] && Carr[i] <= Barr[j]) {
						cnt++;
					}
				}
				result[i] = cnt;
			}		
			System.out.print("#"+test_case);
			for(int i = 0; i < P; i++) {
				System.out.print(" "+result[i]);
			}
			System.out.println();
			
		}
		
	}

}
