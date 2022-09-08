package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1216_회문2 {
	static char[][] table;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			String tc = br.readLine();
			table = new char[100][100];
			for (int i = 0; i < 100; i++) {
				table[i] = br.readLine().toCharArray();
			}
			result = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					for (int size = 1; size <= 100; size++) {
						isPalinRow(i, j, size);
						isPalinCol(i, j, size);
					}
				}
			}
			System.out.println("#" + test_case + " " + result);

		}
	}

	private static void isPalinRow(int r, int c, int size) {
		if (r + size <= 100) {
			for (int i = 0; i < size; i++) {
				if (table[r + i][c] != table[r + size - 1 - i][c]) {
					return;
				}
			}
			result = Math.max(result, size);
		}

	}

	private static void isPalinCol(int r, int c, int size) {
		if (c + size <= 100) {
			for (int i = 0; i < size; i++) {
				if (table[r][c + i] != table[r][c + size - 1 - i]) {
					return;
				}
			}
			result = Math.max(result, size);
		}

	}

}
