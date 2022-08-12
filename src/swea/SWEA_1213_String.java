package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1213_String {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			String tc = br.readLine();
			String target = br.readLine();
			String str = br.readLine();
			int result = search(str, target);
			System.out.printf("#%d %d", test_case, result).println();
		}
	}

	public static int search(String str, String target) {
		int result = 0;
		int sl = str.length();
		int tl = target.length();
		for (int i = 0; i <= sl - tl; i++) {
			int cnt = 0;
			for (int j = 0; j < tl; j++) {
				if (str.charAt(i + j) == target.charAt(j)) {
					cnt++;
				}
			}
			if (cnt == tl) {
				result++;
			}
		}

		return result;
	}
}
