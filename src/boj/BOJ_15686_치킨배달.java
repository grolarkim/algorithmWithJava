package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15686_치킨배달 {
	static int N;
	static int M;
	static int[][] table;
	static ArrayList<Place> chickens = new ArrayList<>();
	static ArrayList<Place> homes = new ArrayList<>();
	static boolean[] chick;
	static int[][] dis;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		table = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				table[i][j] = sc.nextInt();
				if (table[i][j] == 1) {
					homes.add(new Place(i, j));
				}
				if (table[i][j] == 2) {
					chickens.add(new Place(i, j));
				}
			}
		}
		chick = new boolean[chickens.size()];

		dis = new int[homes.size()][chickens.size()];

		for (int i = 0; i < dis.length; i++) {
			for (int j = 0; j < dis[0].length; j++) {
				dis[i][j] = getDistance(homes.get(i), chickens.get(j));
			}
		}

		dfs(0, 0);

		System.out.println(min);
	}

	public static void dfs(int depth, int mm) {
		if (depth == chick.length) {
			if (mm == M) {
				min = Math.min(min, getResult());
			}
			return;
		}

		if (chick[depth] == false) {
			chick[depth] = true;
			dfs(depth + 1, mm + 1);
			chick[depth] = false;
			dfs(depth + 1, mm);
		}

	}

	static int getResult() {
		int result = 0;
		for (int i = 0; i < dis.length; i++) {
			int temp = Integer.MAX_VALUE;
			for (int j = 0; j < dis[0].length; j++) {
				if (chick[j]) {
					temp = Math.min(temp, dis[i][j]);
				}
			}
			result += temp;
		}
		return result;
	}

	public static class Place {
		public int x;
		public int y;

		public Place(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static int getDistance(Place p1, Place p2) {
		int result = 0;
		result += Math.abs(p1.x - p2.x);
		result += Math.abs(p1.y - p2.y);
		return result;
	}
}
