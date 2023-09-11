package boj.y2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1655_가운데를말해요 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> big = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			big.add(temp);
			if (i % 2 == 1) {
				small.add(big.poll());
				bw.write(small.peek() + "\n");
			} else {
				small.add(big.poll());
				big.add(small.poll());
				bw.write(big.peek() + "\n");
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
