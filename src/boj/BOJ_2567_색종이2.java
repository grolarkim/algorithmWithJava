package boj;

import java.util.Scanner;

public class BOJ_2567_색종이2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] papers = new int[N][2];
		for(int i = 0;i<N;i++) {
			papers[i][0] = sc.nextInt();
			papers[i][1] = sc.nextInt();			
		}
		sc.close();
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
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		for(int i = 0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(bigPaper[i][j]==1) {
					for(int k = 0;k<4;k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(nx>=100||nx<0||ny>=100||ny<0||bigPaper[nx][ny]==0) {
							sum++;
						}
					}
				}
			}
		}
		
		System.out.println(sum);
		
	}
}
