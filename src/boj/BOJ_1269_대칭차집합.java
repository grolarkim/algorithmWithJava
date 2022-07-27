package boj;

import java.util.HashSet;
import java.util.Scanner;

public class BOJ_1269_대칭차집합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		HashSet<Integer> aSet = new HashSet<>();
		HashSet<Integer> bSet = new HashSet<>();
		
		for(int i = 0;i<a;i++) {
			aSet.add(sc.nextInt());
		}
		for(int i = 0;i<b;i++) {
			bSet.add(sc.nextInt());
		}
		sc.close();
		aSet.removeAll(bSet);
		int c = aSet.size();
		int result = b-(a-c)+c;
		System.out.println(result);
	}
}
