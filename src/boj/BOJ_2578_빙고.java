package boj;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ_2578_빙고 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, int[]> map = new HashMap<>();
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				int[] a = {i,j};
				map.put(sc.nextInt(),a);
			}
		}
		int[] game = new int[25];
		boolean[][] bingo = new boolean[5][5];
		for(int i=0;i<25;i++) {
			game[i] = sc.nextInt();
		}
		int result = numOfBingo(bingo, game, map);
		System.out.println(result);
	}

	public static int numOfBingo(boolean[][] bingo, int[] game, HashMap<Integer, int[]> map) {
		for(int i = 0;i<25;i++) {
			bingo[map.get(game[i])[0]][map.get(game[i])[1]] = true;
			if(isBingo(bingo)) {
				return i+1;
			}
		}
				
		return 0;
	}

	public static boolean isBingo(boolean[][] bingo) {
		int stack = 0;
		for(int i = 0;i<5;i++) {
			int cnt = 0;
			for(int j = 0;j<5;j++) {
				if(bingo[i][j]==true) {
					cnt++;
				}
			}
			if(cnt==5) {
				stack++;
			}
		}
		for(int i = 0;i<5;i++) {
			int cnt = 0;
			for(int j = 0;j<5;j++) {
				if(bingo[j][i]==true) {
					cnt++;
				}
			}
			if(cnt==5) {
				stack++;
			}
		}
		int cnt = 0;
		for(int i = 0;i<5;i++) {
			if(bingo[i][i]==true) {
				cnt++;
			}
		}
		if(cnt==5) {
			stack++;
		}
		cnt = 0;
		for(int i = 0;i<5;i++) {
			if(bingo[i][4-i]==true) {
				cnt++;
			}
		}
		if(cnt==5) {
			stack++;
		}
		if(stack>=3) {
			return true;
		}else {
			return false;
			
		}
	}
}
