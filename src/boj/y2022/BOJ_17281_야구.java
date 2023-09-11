package boj.y2022;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_17281_야구 {
	static int N;
	static int[][] scores;
	static boolean[] visited = new boolean[9];
	static int[] bat = new int[9];
	static int max = 0;
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		scores = new int[N][9];
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<9;j++) {
				scores[i][j] = sc.nextInt();
			}
		}
		visited[3] = true;
		bat[3] = 0;
		dfs(1);
		System.out.println(max);
		
	}

	public static void dfs(int depth) {
		if(depth==9) {
			getScore();
			return;
		}
		
		for(int i = 0;i<9;i++) {
			if(!visited[i]) {
				visited[i] = true;
				bat[i] = depth;
				dfs(depth+1);
				visited[i] = false;
			}
		}
		
	}

	public static void getScore() {
		int result = 0;
		int idx = 0;
		int inning = 0;
		int out = 0;
		boolean[] field = new boolean[3];
		while(inning<N) {
			int player = bat[idx];
			int score = scores[inning][player];
			switch (score) {
			case 0:
				out++;
				break;
			case 1:
				if(field[2]) {
					result++;
					field[2] = false;
				}
				if(field[1]) {
					field[2] = true;
					field[1] = false;
				}
				if(field[0]) {
					field[1] = true;
				}
				field[0] = true;
				break;
			case 2:
				if(field[2]) {
					result++;
					field[2] = false;
				}
				if(field[1]) {
					result++;
					field[1] = false;
				}
				if(field[0]) {
					field[2] = true;
					field[0] = false;
				}
				field[1] = true;
				break;
			case 3:
				if(field[2]) {
					result++;
					field[2] = false;
				}
				if(field[1]) {
					result++;
					field[1] = false;
				}
				if(field[0]) {
					result++;
					field[0] = false;
				}
				field[2] = true;
				break;
			case 4:
				if(field[2]) {
					result++;
					field[2] = false;
				}
				if(field[1]) {
					result++;
					field[1] = false;
				}
				if(field[0]) {
					result++;
					field[0] = false;
				}
				result++;
				break;
			}
			
			if(out == 3) {
				inning++;
				out=0;
				field = new boolean[3];
			}			
			idx++;
			if(idx==9) {
				idx=0;
			}
		}
		if(result>max) {
			max=result;
		}
		
	}
}
