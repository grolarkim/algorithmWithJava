package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1231_중위순회 {
	static int N;
	static char[] tree;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			tree = new char[N + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree[i] = st.nextToken().charAt(0);
			}

			inorder(1);

			System.out.println("#" + test_case + " " + sb.toString());
		}

	}

	static void inorder(int root) {
		int l = root * 2;
		int r = root * 2 + 1;

		if (l <= N) {
			inorder(l);
		}

		sb.append(tree[root]);

		if (r <= N) {
			inorder(r);
		}

	}
}
