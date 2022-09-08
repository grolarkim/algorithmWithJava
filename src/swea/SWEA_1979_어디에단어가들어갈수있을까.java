package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1979_어디에단어가들어갈수있을까 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] crossWord = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					crossWord[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cntr = 0;
			int cntc = 0;
			for (int i = 0; i < N; i++) {
				int stackr = 0;
				int stackc = 0;
				for (int j = 0; j < N; j++) {
					if(crossWord[i][j]==1) {
						stackr++;
					} else if(stackr==K) {
						cntr++;
						stackr=0;
					} else {
						stackr=0;
					}
					if(crossWord[j][i]==1) {
						stackc++;
					} else if(stackc==K) {
						cntc++;
						stackc=0;
					} else {
						stackc=0;
					}
				}
				if(stackr==K) {
					cntr++;
				}
				if(stackc==K) {
					cntc++;
				}
			}
			System.out.printf("#%d %d", test_case, cntr+cntc).println();

		}
	}
}
