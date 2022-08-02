package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int size = 2;
	static int sizeStack = 0;
	static int x;
	static int y;
	static int time = 0;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					x = i;
					y = j;
					map[i][j] = 0;
				}
			}
		}
		bfs();

		System.out.println(time);

	}

	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		PriorityQueue<Node> fishes = new PriorityQueue<>();

		q.offer(new Node(x, y, 0));
		while (true) {
			boolean find = false;
			int minDis = Integer.MAX_VALUE;
			
			while (!q.isEmpty()) {
				Node cur = q.poll();
				int r = cur.x;
				int c = cur.y;
				int distance = cur.distance;
				if(minDis < distance) {
					break;
				}
				if (map[r][c] != 0 && map[r][c] < size) {
					fishes.offer(cur);
					minDis = Math.min(distance, minDis);
					find = true;
					
				} else {
					for (int i = 0; i < 4; i++) {
						if (r + dr[i] >= 0 && r + dr[i] < N && c + dc[i] >= 0 && c + dc[i] < N
								&& !visited[r + dr[i]][c + dc[i]] && map[r + dr[i]][c + dc[i]] <= size) {
							q.offer(new Node(r + dr[i], c + dc[i], distance + 1));
							visited[r + dr[i]][c + dc[i]] = true;
						}
					}
				}
			}
			if(fishes.isEmpty()) {
				break;
			}
			Node fish = fishes.poll();
			x = fish.x;
			y = fish.y;
			time = fish.distance;
			q.clear();
			fishes.clear();
			q.offer(new Node(x, y, fish.distance));
			sizeStack++;
			if (size == sizeStack) {
				size++;
				sizeStack = 0;
			}
			map[x][y] = 0;
			visited = new boolean[N][N];
			if(!find) {
				break;
			}

		}

	}

}

class Node implements Comparable<Node> {
	int x;
	int y;
	int distance;

	Node(int x, int y, int distance) {
		super();
		this.x = x;
		this.y = y;
		this.distance = distance;
	}

	@Override
	public int compareTo(Node o) {
		if (this.x != o.x) {
			return (this.x < o.x) ? -1 : 1;
		} else {
			return (this.y < o.y) ? -1 : 1;
		}
	}
}
