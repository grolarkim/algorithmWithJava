package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17471_게리멘더링 {
	static int N;
	static int[] population;
	static boolean[][] graph;
	static boolean[] visited;
	static boolean[] team;
	static int sum = 0;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		population = new int[N + 1];
		graph = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];
		team = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			population[i] = sc.nextInt();
			sum += population[i];
		}
		for (int i = 1; i <= N; i++) {
			int k = sc.nextInt();
			for (int j = 0; j < k; j++) {
				graph[i][sc.nextInt()] = true;
			}
		}
		search(1);
		if(min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);

	}

	static void search(int depth) {
		if (isPossible()) {
			int a = 0;
			for (int i = 0; i <= N; i++) {
				if (team[i]) {
					a += population[i];
				}
			}
			min = Math.min(Math.abs(sum - a - a), min);
		}
		if (depth > N) {
			return;
		}
		search(depth + 1);
		team[depth] = true;
		search(depth + 1);
		team[depth] = false;

	}

	static boolean isPossible() {
		int ct = 0;
		int cf = 0;
		for (int i = 1; i <= N; i++) {
			if (team[i]) {
				ct = i;
			} else {
				cf = i;
			}
		}
		if (ct == 0 || cf == 0) {
			return false;
		}
		visited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(ct);
		while (!q.isEmpty()) {
			int now = q.poll();
			visited[now] = true;
			for (int i = 1; i <= N; i++) {
				if (graph[now][i] && !visited[i] && team[i]) {
					q.offer(i);
				}
			}

		}

		q.clear();
		q.offer(cf);
		while (!q.isEmpty()) {
			int now = q.poll();
			visited[now] = true;
			for (int i = 1; i <= N; i++) {
				if (graph[now][i] && !visited[i] && !team[i]) {
					q.offer(i);
				}
			}

		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				return false;
			}
		}

		return true;
	}

}
