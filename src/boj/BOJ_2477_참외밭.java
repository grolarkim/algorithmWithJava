package boj;

import java.util.Scanner;

public class BOJ_2477_참외밭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int[][] map = new int[6][2];

		int maxr = 0;
		int maxc = 0;
		int maxrIdx = -1;
		int maxcIdx = -1;

		for (int i = 0; i < 6; i++) {
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
			if ((map[i][0] == 1 || map[i][0] == 2) && (maxr < map[i][1])) {
				maxr = map[i][1];
				maxrIdx = i;
			} else if ((map[i][0] == 3 || map[i][0] == 4) && (maxc < map[i][1])) {
				maxc = map[i][1];
				maxcIdx = i;
			}
		}
		int result = 0;
		if (maxcIdx-maxrIdx == 1 || maxcIdx-maxrIdx == -5) {
			result = maxr * maxc - map[(maxcIdx + 2) % 6][1] * map[(maxcIdx + 3) % 6][1];
		} else {
			result = maxr * maxc - map[(maxrIdx + 2) % 6][1] * map[(maxrIdx + 3) % 6][1];
		}
		System.out.println(result * K);

	}

}
