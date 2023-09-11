package boj.y2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11003_최소값찾기 {
	static int N;
	static int L;
	
	static class Node {
		int idx;
		int val;
		
		public Node(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		Deque<Node> deq = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			while(!deq.isEmpty() && deq.peekLast().val > now) {
				deq.pollLast();
			}
			deq.addLast(new Node(i, now));
			
			if(deq.peekFirst().idx <= i-L) {
				deq.pollFirst();
			}

			bw.write(deq.peekFirst().val+" ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
