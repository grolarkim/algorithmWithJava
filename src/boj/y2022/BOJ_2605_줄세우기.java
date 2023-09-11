package boj.y2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2605_줄세우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] arr = new int[a];
		for(int i=0;i<a;i++) {
			arr[i] = sc.nextInt();
		}
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<a;i++) {
			list.add(list.size()-arr[i], i+1);
		}
		for(int i = 0;i<a;i++) {
			System.out.print(list.get(i)+" ");
		}
		
	}
}
