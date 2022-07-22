package boj;

import java.util.Scanner;

public class BOJ_2563_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] papers = new int[N][2];
		for(int i = 0;i<N;i++) {
			papers[i][0] = sc.nextInt();
			papers[i][1] = sc.nextInt();			
		}
		int[][] bigPaper = new int[100][100];
		for(int i=0;i<N;i++) {
			int a = papers[i][0];
			int b = papers[i][1];
			for(int j = a;j<a+10;j++) {
				for(int k=b;k<b+10;k++) {
					bigPaper[j][k] = 1;
				}
			}
		}
		int sum = 0;
		for(int[] bp : bigPaper) {
			for(int b :bp) {
				sum += b;
			}
		}
		System.out.println(sum);
		
	}
}
