package swea;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1226_미로1 {
	public static int[] findArea(int[][] table, int n) {
		int[] result = {0,0};
		for(int i = 0; i<16; i++) {
			for(int j = 0;j<16;j++) {
				if(table[i][j] == n) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}
		
	public static boolean dfs(int[][] table) {
		Stack<Integer> stack = new Stack<>();
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		int[] start = findArea(table, 2);
		int[] end = findArea(table, 3);
				
		stack.push(start[0]);
		stack.push(start[1]);
		
		while(!stack.isEmpty()) {
			int y = stack.pop();
			int x = stack.pop();
			for(int i=0;i<4;i++) {
				if(x+dx[i]<table.length && x+dx[i]>=0 && y+dy[i]<table.length && y+dy[i]>=0) {
					if(table[x+dx[i]][y+dy[i]] == 0 || table[x+dx[i]][y+dy[i]] == 3) {
						stack.push(x+dx[i]);
						stack.push(y+dy[i]);
						table[x+dx[i]][y+dy[i]] = 2;
					}
				}
			}
		}

		
		if (table[end[0]][end[1]]==2) {
			return true;			
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case=1;test_case<=10;test_case++) {
			int T = sc.nextInt();
			int[][] table = new int[16][16];
			String inputs;
			for(int i=0;i<16;i++) {
				inputs = sc.next();
				for(int j=0;j<16;j++) {
					table[i][j] = Character.getNumericValue(inputs.charAt(j));
				}				
			}
			if (dfs(table)) {
				System.out.println("#" + test_case + " "+1);
			} else {
				System.out.println("#" + test_case + " "+0);				
			}
			
		}
	}
}
