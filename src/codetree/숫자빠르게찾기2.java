package codetree;

import java.util.*;

public class 숫자빠르게찾기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		TreeSet<Integer> set = new TreeSet<>();
		for(int i = 0;i<N;i++) {
			set.add(sc.nextInt());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<M;i++) {
			Integer x = set.ceiling(sc.nextInt());
			if(x==null) {
				sb.append("-1\n");
			} else {
				sb.append(x).append('\n');
			}
		}
		
		System.out.println(sb.toString());
		
	}
}
