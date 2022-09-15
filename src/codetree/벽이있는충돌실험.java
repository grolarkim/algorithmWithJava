package codetree;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 벽이있는충돌실험 {
	static int T;
	static int N;
	static int M;
	static int[][] tbl;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static Set<Pair> marbles;
	
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1;tc<=T;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			tbl = new int[N+1][N+1];
			marbles = new HashSet<Pair>();
			for(int i = 0;i<M;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				char a = sc.next().charAt(0);
				int d = -1;
				switch (a) {
				case 'U':
					d = 0;
					break;
				case 'D':
					d = 1;
					break;
				case 'R':
					d = 2;
					break;
				case 'L':
					d = 3;
					break;
				}
				marbles.add(new Pair(x,y,d));
			}
			sim();
			result = marbles.size();
			System.out.println(result);
		}
		
		
	}

	static void sim() {
		int tt = 0;
		while(tt++ <3*N) {
			Set<Pair> set = new HashSet<>();
			Set<Pair> dset = new HashSet<>();
			for(Pair p : marbles) {
				Pair np = Pair.getNext(p);
				if(set.contains(np)) {
					dset.add(np);
				} else {
					set.add(np);
				}
			}
			set.removeAll(dset);
//			System.out.println(set);
			marbles = set;
		}		
	}
	
	static class Pair {

		public int x;
		public int y;
		public int d;
		
		public Pair() {
		}
		
		public Pair(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
		

		public static Pair getNext(Pair now) {
			Pair p = new Pair();
			switch (now.d) {
			case 0:
				if(now.x == 1) {
					p.x=now.x;
					p.y=now.y;
					p.d=1;
				} else {
					p.x=now.x-1;
					p.y=now.y;
					p.d=now.d;					
				}
				break;
			case 1:
				if(now.x == N) {
					p.x=now.x;
					p.y=now.y;
					p.d=0;
				} else {
					p.x=now.x+1;
					p.y=now.y;
					p.d=now.d;					
				}
				break;
			case 2:
				if(now.y == N) {
					p.x=now.x;
					p.y=now.y;
					p.d=3;
				} else {
					p.x=now.x;
					p.y=now.y+1;
					p.d=now.d;					
				}
				break;
			case 3:
				if(now.y == 1) {
					p.x=now.x;
					p.y=now.y;
					p.d=2;
				} else {
					p.x=now.x;
					p.y=now.y-1;
					p.d=now.d;					
				}
				break;
			}
			
			return p;
		}
		
		@Override
		public int hashCode() {
			return (107*x)+y;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Pair) {
				Pair p = (Pair) obj;
				return this.x==p.x&&this.y==p.y;				
			}
			return false;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
		
	}
}
