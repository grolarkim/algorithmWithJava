package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13460_구슬탈출2 {
	static int N, M;
	static char[][] map;
	static int rx, ry, bx, by, ox, oy;
	static int min;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'R') {
					rx = i;
					ry = j;
				} else if (map[i][j] == 'B') {
					bx = i;
					by = j;
				} else if (map[i][j] == 'O') {
					ox = i;
					oy = j;
				}
			}
		}

		min = Integer.MAX_VALUE;

		bfs();

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { rx, ry, bx, by, 1 });
		while (!q.isEmpty()) {
			int[] marbles = q.poll();

			if (marbles[4] > 10) {
				return;
			}

			for (int i = 0; i < 4; i++) {
				int[] nr = move(marbles[0], marbles[1], i);
				int[] nb = move(marbles[2], marbles[3], i);

				if (nb[2] == 1) {
					continue;
				}
				if (nr[2] == 1) {
					min = marbles[4];
					return;
				}
				if (nr[0] == nb[0] && nr[1] == nb[1]) {
					switch (i) {
					case 0:
						if (marbles[0] < marbles[2]) {
							nb[0]++;
						} else {
							nr[0]++;
						}
						break;
					case 1:
						if (marbles[0] > marbles[2]) {
							nb[0]--;
						} else {
							nr[0]--;
						}
						break;
					case 2:
						if (marbles[1] < marbles[3]) {
							nb[1]++;
						} else {
							nr[1]++;
						}
						break;
					case 3:
						if (marbles[1] > marbles[3]) {
							nb[1]--;
						} else {
							nr[1]--;
						}
						break;
					}
				}
				if (marbles[0] == nr[0] && marbles[1] == nr[1]) {
					continue;
				}
				q.add(new int[] { nr[0], nr[1], nb[0], nb[1], marbles[4] + 1 });
			}

		}
	}

	private static int[] move(int xx, int yy, int dir) {
		int[] arr = { xx, yy, 0 };
		int cnt = 1;
		while (true) {
			int nx = arr[0] + dx[dir] * cnt;
			int ny = arr[1] + dy[dir] * cnt;
			if (map[nx][ny] == '#') {
				break;
			} else if (nx == ox && ny == oy) {
				arr[0] = nx;
				arr[1] = ny;
				arr[2] = 1;
				break;
			} else {
				arr[0] = nx;
				arr[1] = ny;
			}
		}
		return arr;
	}

}
