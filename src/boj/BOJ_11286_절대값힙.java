package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286_절대값힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) < Math.abs(o2)) {
					return -1;
				} else if (Math.abs(o1) > Math.abs(o2)) {
					return 1;
				} else if (o1 < o2) {
					return -1;
				} else if (o1 > o2) {
					return 1;
				} else {
					return 0;
				}

			}
		});

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
