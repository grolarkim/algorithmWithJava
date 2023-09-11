package boj.y2022;

import java.util.Scanner;

public class boj_1182_부분수열의합 {
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for(int i = 0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		visited = new boolean[N];
		cnt = 0;
		
		dfs(0, 0);
		if(M == 0) {
			System.out.println(cnt-1);
		} else {
			System.out.println(cnt);			
		}
		
	}

	private static void dfs(int depth, int sum) {
		if(depth == N) {
			if (sum == M) {
				cnt++;
			}
			return;
		}
		
		dfs(depth+1, sum + arr[depth]);
		dfs(depth+1, sum);
		
	}
}
