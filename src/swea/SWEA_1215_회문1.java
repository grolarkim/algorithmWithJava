package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1215_회문1 {
	static int size;
	static char[][] table;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			size = Integer.parseInt(br.readLine());
			table = new char[8][8];
			result = 0;
			for (int i = 0; i < 8; i++) {
				table[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					isPalinRow(i, j);
					isPalinCol(i, j);
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}

	private static void isPalinRow(int r, int c) {
		if (r + size <= 8) {
			for (int i = 0; i < size; i++) {
				if (table[r + i][c] != table[r + size - 1 - i][c]) {
					return;
				}
			}
			result++;
		}
	}

	private static void isPalinCol(int r, int c) {
		if (c + size <= 8) {
			for (int i = 0; i < size; i++) {
				if (table[r][c+i] != table[r][c + size - 1 - i]) {
					return;
				}
			}
			result++;
		}
	}

}
