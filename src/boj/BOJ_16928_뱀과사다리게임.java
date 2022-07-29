package boj;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16928_뱀과사다리게임 {
	public static void main(String[] args) {
		boolean[] isLad = new boolean[101];
		boolean[] isSnake = new boolean[101];
		int[] visited = new int[101];
		Map<Integer, Integer> ladder = new HashMap<Integer, Integer>();
		Map<Integer, Integer> snake = new HashMap<Integer, Integer>();

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] lad = new int[N][2];
		int[][] sna = new int[M][2];

		for (int i = 0; i < N; i++) {
			lad[i][0] = sc.nextInt();
			lad[i][1] = sc.nextInt();
			ladder.put(lad[i][0], lad[i][1]);
			isLad[lad[i][0]] = true;
		}
		for (int i = 0; i < M; i++) {
			sna[i][0] = sc.nextInt();
			sna[i][1] = sc.nextInt();
			snake.put(sna[i][0], sna[i][1]);
			isSnake[sna[i][0]] = true;
		}
		sc.close();

		Queue<int[]> q = new LinkedList<>();
		int[] start = { 1, 0 };
		q.add(start);
		visited[1] = 0;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int a = now[0];
			int step = now[1];

			for (int i = 1; i <= 6; i++) {
				if (a + i <= 100 && (visited[a + i] == 0 || visited[a + i] > step + 1)) {
					int[] temp = { a + i, step + 1 };
					if (isLad[a + i]) {
						temp[0] = ladder.get(a + i);
						visited[temp[0]] = step + 1;
					} else if (isSnake[a + i]) {
						temp[0] = snake.get(a + i);
						visited[temp[0]] = step + 1;
					}
					visited[a + i] = step + 1;
					q.add(temp);
				}
			}

		}
		System.out.println(visited[100]);

	}
}
