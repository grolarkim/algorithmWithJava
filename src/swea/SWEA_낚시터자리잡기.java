package swea;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA_낚시터자리잡기 {
	static int size;
	static boolean[] map;
	static int gate[][];
	
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			size = sc.nextInt();

			gate = new int[3][2];
			
			for (int i = 0; i < 3; i++) {
				gate[i][0] = sc.nextInt();
				gate[i][1] = sc.nextInt();
			}
			Arrays.sort(gate, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}
			});
			min = Integer.MAX_VALUE;
			
			simulate();
			System.out.println("#" + tc + " " + min);
		}
	}

	static void simulate() {
		sim(0, 1, 2);
		sim(0, 2, 1);
		sim(1, 0, 2);
		sim(1, 2, 0);
		sim(2, 0, 1);
		sim(2, 1, 0);
	}

	static void sim(int i, int j, int k) {
		map = new boolean[size + 1];
		int dis = 0;
		if (i == 0 || i == 1) {
			dis += getL(i);
		} else {
			dis += getR(i);
		}
		if (j == 0 || j == 1) {
			dis += getL(j);
		} else {
			dis += getR(j);
		}
		if (k == 0 || k == 1) {
			dis += getL(k);
		} else {
			dis += getR(k);
		}
		min = Math.min(min, dis);

		map = new boolean[size + 1];
		dis = 0;
		if (i == 0) {
			dis += getL(i);
		} else {
			dis += getR(i);
		}
		if (j == 0) {
			dis += getL(j);
		} else {
			dis += getR(j);
		}
		if (k == 0) {
			dis += getL(k);
		} else {
			dis += getR(k);
		}
		min = Math.min(min, dis);
	}

	static int getL(int num) {
		int temp = 0;
		for (int i = 0; i < gate[num][1]; i++) {
			int now = getNearL(gate[num][0]);
			temp += Math.abs(gate[num][0] - now) + 1;
			map[now] = true;
		}
		return temp;
	}

	static int getR(int num) {
		int temp = 0;
		for (int i = 0; i < gate[num][1]; i++) {
			int now = getNearR(gate[num][0]);
			temp += Math.abs(gate[num][0] - now) + 1;
			map[now] = true;
		}
		return temp;
	}

	static int getNearL(int gateNum) {
		for (int i = 0; i < 62; i++) {
			if (gateNum - i > 0 && map[gateNum - i] == false) {
				return gateNum - i;
			}
			if (gateNum + i < size + 1 && map[gateNum + i] == false) {
				return gateNum + i;
			}
		}
		return -1;
	}

	static int getNearR(int gateNum) {
		for (int i = 0; i < 62; i++) {
			if (gateNum + i < size + 1 && map[gateNum + i] == false) {
				return gateNum + i;
			}
			if (gateNum - i > 0 && map[gateNum - i] == false) {
				return gateNum - i;
			}
		}
		return -1;
	}
}
