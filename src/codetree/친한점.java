package codetree;

import java.util.*;

public class 친한점 {
	
	public static class Pair implements Comparable<Pair>{
		public int x;
		public int y;
		
		@Override
		public int compareTo(Pair o) {
			if(this.x==o.x) {
				return this.y-o.y;
			}
			return this.x-o.x;
		}

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		TreeSet<Pair> set = new TreeSet<>();
		for(int i = 0;i<N;i++) {
			set.add(new Pair(sc.nextInt(), sc.nextInt()));
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<M;i++) {
			Pair p = set.ceiling(new Pair(sc.nextInt(), sc.nextInt()));
			if(p==null) {
				sb.append("-1 -1\n");
			} else {
				sb.append(p.x+" "+p.y+"\n");
			}
		}
		System.out.println(sb.toString());
		
	}
}
