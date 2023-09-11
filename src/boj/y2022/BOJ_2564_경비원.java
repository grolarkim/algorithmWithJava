package boj.y2022;

import java.util.Scanner;

public class BOJ_2564_경비원 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int n = sc.nextInt();
		int[][] stores = new int[n][2];
		for(int i = 0;i<n;i++) {
			stores[i][0] = sc.nextInt();
			stores[i][1] = sc.nextInt();
		}
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		sc.close();
		
		int sum = 0;
		for(int i = 0;i<n;i++) {
			int a = stores[i][0];
			int b = stores[i][1];
			int[][] yarr = {{0,0,0,0,0},{0,y,y,y,r-y},{0,y,y,y,r-y},{0,y,c-y,y,y},{0,y,c-y,y,y}};
			int[][] barr = {{0,0,0,0,0},{0,-b,b,b,b},{0,b,-b,c-b,c-b},{0,b,b,-b,b},{0,r-b,r-b,b,b}};
			if(a == x) {
				sum += Math.abs(y-b);
			} else if(a + x == 3) {
				sum += Math.min((y+b), 2*r-(y+b))+(c);
			} else if(a + x == 7) {
				sum += Math.min((y+b), 2*c-(y+b))+(r);				
			} else {
				sum += (yarr[x][a])+(barr[x][a]);
			}
		}
		System.out.println(sum);
	}
}
