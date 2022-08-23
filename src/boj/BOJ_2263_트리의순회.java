package boj;

import java.io.*;
import java.util.*;

public class BOJ_2263_트리의순회 {
	static int N;
	static int[] in;
	static int[] post;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		in = new int[N];
		post = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			in[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			post[i] = Integer.parseInt(st.nextToken());
		}
		br.close();

		preorder(0, N - 1, 0, N - 1);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString() + "\n");
		bw.flush();
		bw.close();
	}

	static void preorder(int firstin, int lastin, int firstpost, int lastpost) {
		int lr = skew(firstin, lastin, firstpost, lastpost);
		if (lr != 0) {
			for (int i = lastpost; i >= firstpost; i--) {
				sb.append(post[i]).append(' ');
			}
			return;
		}

		int root = post[lastpost];
		sb.append(root).append(' ');

		int rootIdx = -1;
		for (int i = firstin; i <= lastin; i++) {
			if (in[i] == root) {
				rootIdx = i;
				break;
			}
		}

		if (firstin < rootIdx - 1) {
			preorder(firstin, rootIdx - 1, firstpost, firstpost + (rootIdx - 1 - firstin));
		} else if (firstin == rootIdx - 1) {
			sb.append(in[firstin]).append(' ');
		}

		if (rootIdx + 1 < lastin) {
			preorder(rootIdx + 1, lastin, firstpost + (rootIdx - firstin), lastpost - 1);
		} else if (rootIdx + 1 == lastin) {
			sb.append(in[lastin]).append(' ');
		}

	}

	static int skew(int firstin, int lastin, int firstpost, int lastpost) {
		boolean isLeft = true;
		boolean isRight = true;

		for (int i = 0; i <= lastin - firstin; i++) {
			if (in[firstin + i] != post[firstpost + i]) {
				isLeft = false;
				break;
			}
		}
		if (isLeft) {
			return 1;
		}

		for (int i = 0; i <= lastin - firstin; i++) {
			if (in[firstin + i] != post[lastpost - i]) {
				isRight = false;
				break;
			}
		}

		if (isRight) {
			return 2;
		}

		return 0;
	}

}
