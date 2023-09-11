package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2075_N번째큰수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0;j<N;j++) {
				int k = Integer.parseInt(st.nextToken());
				q.offer(k);
				if(q.size()>N) {
					q.poll();
				}
			}
		}
		System.out.println(q.peek());
	}
}
