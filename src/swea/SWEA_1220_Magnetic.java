package swea;

import java.util.Scanner;

public class SWEA_1220_Magnetic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			int[][] table = new int[N][N];
			int[][] recordTable = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (table[i][j] == 1) {
						for (int k = i; k < N; k++) {
							if (table[k][j] == 2) {
								recordTable[k][j] = 1;
								break;
							}
						}
					} 
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(recordTable[i][j] == 1) {
						result += 1;
					}
				}
			}

			System.out.println("#" + test_case + " " + result);

		}

	}

}
