package codetree;

import java.util.*;

public class 최대숫자구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		TreeSet<Integer> set = new TreeSet<>();
		for(int i = 1;i<=M;i++) {
			set.add(i);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<N;i++) {
			set.remove(sc.nextInt());
			sb.append(set.last()).append('\n');
		}
		System.out.println(sb.toString());
	}
}
