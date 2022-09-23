package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17435_합성함수와쿼리 {
	static int M, Q;
	static int[][] func;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		M = Integer.parseInt(br.readLine());
		func = new int[M + 1][21];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			func[i][0] = Integer.parseInt(st.nextToken());
		}

		setFunc();

		Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			bw.write(getFunc(n, x) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

	private static void setFunc() {
		for (int j = 1; j < 21; j++) {
			for (int i = 1; i <= M; i++) {
				func[i][j] = func[func[i][j - 1]][j - 1];
			}
		}

	}

	private static int getFunc(int n, int x) {
		int cur = x;
		for (int i = 20; i >= 0; i--) {
			if ((n & (1 << i)) != 0) {
				cur = func[cur][i];
			}
		}
		return cur;
	}
}
