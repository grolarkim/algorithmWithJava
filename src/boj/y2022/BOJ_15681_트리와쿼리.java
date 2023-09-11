package boj.y2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15681_트리와쿼리 {
	static int N, R, Q;
	static List<List<Integer>> connected;
	static int[] parents;
	static int[] sizes;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		connected = new ArrayList<List<Integer>>();
		for (int i = 0; i <= N; i++) {
			connected.add(new ArrayList<>());
		}

		parents = new int[N + 1];
		sizes = new int[N + 1];

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			connected.get(from).add(to);
			connected.get(to).add(from);
		}

		makeTree(R, -1);
		countSubtreeNode(R);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < Q; i++) {
			int nq = Integer.parseInt(br.readLine());
			bw.write(sizes[nq] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static int countSubtreeNode(int curNode) {
		if (sizes[curNode] != 0) {
			return sizes[curNode];
		}

		if (connected.get(curNode).size() == 1 && curNode != R) {
			return sizes[curNode] = 1;
		}

		int sum = 1;
		for (int node : connected.get(curNode)) {
			if (node != parents[curNode]) {
				sum += countSubtreeNode(node);
			}
		}
		return sizes[curNode] = sum;
	}

	private static void makeTree(int curNode, int parent) {
		for (int node : connected.get(curNode)) {
			if (node != parent) {
				parents[node] = curNode;
				makeTree(node, curNode);
			}
		}
	}
}
