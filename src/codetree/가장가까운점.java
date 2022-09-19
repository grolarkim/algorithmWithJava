package codetree;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 가장가까운점 {
	static class Node implements Comparable<Node>{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			if(Math.abs(this.x+this.y) == Math.abs(o.x+o.y) && this.x == o.x) {
				return this.y - o.y;
			}
			
			if(Math.abs(this.x+this.y) == Math.abs(o.x+o.y)) {
				return this.x - o.x;
			}
			
			return Math.abs(this.x+this.y)-Math.abs(o.x+o.y);
		}

		@Override
		public String toString() {
			return x+" "+y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i = 0;i<N;i++) {
			pq.add(new Node(sc.nextInt(), sc.nextInt()));
		}
		for(int i = 0;i<M;i++) {
			Node no = pq.poll();
			no.x += 2;
			no.y += 2;
			pq.add(no);
		}
		System.out.println(pq.peek());
	}
}
