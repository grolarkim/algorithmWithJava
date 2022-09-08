package swea;

import java.util.Scanner;

public class SWEA_1979_2refactored {
	public static int cntRow(int K, int[][] crossWord) {
		int cnt = 0;
		for(int i=0;i<crossWord.length;i++) {
			int stack = 0;
			for(int j=0;j<crossWord.length;j++) {
				if(crossWord[i][j]==1) {
					stack+=1;
				} else {
					if(stack==K) {
						cnt+=1;
					}
					stack = 0;
				}
			}
			if(stack==K) {
				cnt+=1;
			}
		}
		return cnt;
	}
	
	public static int cntColumn(int K, int[][] crossWord) {
		int cnt = 0;
		for(int i=0;i<crossWord.length;i++) {
			int stack = 0;
			for(int j=0;j<crossWord.length;j++) {
				if(crossWord[j][i]==1) {
					stack+=1;
				} else {
					if(stack==K) {
						cnt+=1;
					}
					stack = 0;
				}
			}
			if(stack==K) {
				cnt+=1;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] crossWord = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					crossWord[i][j] = sc.nextInt();
				}
			}
			System.out.println("#"+test_case+" "+(cntRow(K,crossWord)+cntColumn(K, crossWord)));
		}
	}
}
