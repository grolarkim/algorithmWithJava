package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279_최대힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(in.readLine());
			if (a == 0 && q.isEmpty()) {
				System.out.println(0);
			} else if (a == 0) {
				System.out.println(q.poll());
			} else {
				q.add(a);
			}
		}

	}

}
