package swea;

import java.util.Scanner;

public class SWEA_5432_쇠막대기자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			char[] arr = sc.next().toCharArray();
			int bars = 0;
			int result = 0;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] == '(') {
					if(arr[i+1] == ')') {
						result += bars;
					} else {
						result++;
						bars++;
					}
				} else {
					if(arr[i-1] == '(') {
						
					} else {
						bars--;
					}
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}
