package swea;

import java.util.Scanner;

public class SWEA_14413_격자판칠하기 {
	public static boolean sOrD(char[][] table ) {
		for(int i=0;i<table.length;i++) {
			for(int j=0;j<table[0].length;j++) {
				if((table[i][j] == '#' && (i+j)%2 == 0)||(table[i][j] == '.' && (i+j)%2 == 1)) {
					return true;
				} else if ((table[i][j] == '#' && (i+j)%2 == 1)||(table[i][j] == '.' && (i+j)%2 == 0)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isPossible(char[][] table, boolean a) {
		char b;
		char c;
		if(a) {
			b = '#';
			c = '.';
		} else {
			b = '.';
			c = '#';
		}
		
		for(int i=0;i<table.length;i++) {
			for(int j=0;j<table[0].length;j++) {
				if (((i+j)%2 == 0 && table[i][j] == c)||((i+j)%2 == 1 && table[i][j] == b)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			char[][] table = new char[N][M];
			String inputs;
			for(int i=0;i<N;i++) {
				inputs = sc.next();
				for(int j=0;j<M;j++) {
					table[i][j] = inputs.charAt(j);
				}				
			}
			
			boolean a = sOrD(table);
			if(isPossible(table, a)) {
				System.out.println("#"+test_case+" possible");
			} else {
				System.out.println("#"+test_case+" impossible");				
			}
		}
	}

}
