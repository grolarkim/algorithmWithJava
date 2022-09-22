package swea;

import java.util.Scanner;

public class SWEA_4008_숫자만들기 {
	static int N;
	static int[] opers;
	static int[] arr;
	static int[] arrOpers;
	static int max;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1;tc<=T;tc++) {
			N = sc.nextInt();
			opers = new int[4];
			arr = new int[N];
			arrOpers = new int[N-1];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			for(int i = 0;i<4;i++) {
				opers[i] = sc.nextInt();
			}
			for(int i = 0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			search(0);
			
			System.out.println("#"+tc+" "+(max-min));
		}		
		sc.close();		
	}

	private static void search(int depth) {
		if(depth == N-1) {
			getResult();
			return;
		}
		
		for(int i = 0;i<4;i++) {
			if(opers[i] > 0) {
				opers[i]--;
				arrOpers[depth] = i;
				search(depth+1);
				opers[i]++;
			}
		}
	}

	private static void getResult() {
		int result = arr[0];
		for(int i = 0;i<N-1;i++) {
			switch (arrOpers[i]) {
			case 0:
				result += arr[i+1];
				break;
			case 1:
				result -= arr[i+1];
				break;
			case 2:
				result *= arr[i+1];
				break;
			case 3:
				result /= arr[i+1];
				break;
			}
		}
		max = Math.max(max, result);
		min = Math.min(min, result);
	}
}
