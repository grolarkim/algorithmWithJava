package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715_카드정렬하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			q.offer(temp);
		}

		int result = 0;

		for (int i = 1; i < N; i++) {
			int x = q.poll();
			int y = q.poll();
			int temp = x + y;
			result += temp;
			q.offer(temp);
		}
		System.out.println(result);

	}
}
