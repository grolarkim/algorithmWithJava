package codetree;

import java.util.*;

public class 가까운숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeSet<Integer> set = new TreeSet<>();
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int min = Integer.MAX_VALUE;
		set.add(0);
		for(int i = 0;i<N;i++) {
			int x = sc.nextInt();
			set.add(x);
			Integer l = set.lower(x);
			Integer h = set.higher(x);
			if(l!=null) {
				min=Math.min(min, x-l);
			}
			if(h!=null) {
				min = Math.min(min, h-x);
			}
			sb.append(min).append('\n');
		}
		System.out.println(sb.toString());
	}
}
