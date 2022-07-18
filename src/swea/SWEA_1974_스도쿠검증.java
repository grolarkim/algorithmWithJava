package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1974_스도쿠검증 {
	public static boolean IsOnetoNine(int[] onetonine) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		Arrays.sort(onetonine);
		for(int i=0;i<9;i++) {
			if(arr[i]!=onetonine[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static int IsOk(int[][] sudoku) {
		int[] onetonine = new int[9];
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				onetonine[j] = sudoku[i][j];
			}
			if(!IsOnetoNine(onetonine)) {
				return 0;
			}
		}
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				onetonine[j] = sudoku[j][i];
			}
			if(!IsOnetoNine(onetonine)) {
				return 0;
			}
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				for(int a=0;a<3;a++) {
					for(int b=0;b<3;b++) {
						onetonine[3*a+b] = sudoku[i*3+a][j*3+b];
					}
				}
				if(!IsOnetoNine(onetonine)) {
					return 0;
				}
			}
		}
		
		return 1;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int[][] sudoku = new int[9][9];
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			System.out.println("#"+test_case+" "+IsOk(sudoku));			
		}
	}
}
