package boj.y2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_2309_일곱난쟁이 {
	public static int[] search(int[] arr) {
		int sum = Arrays.stream(arr).sum();
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < i; j++) {
				if(sum-arr[i]-arr[j]==100) {
					for(int k = 0;k<9;k++) {
						if(k!=i&&k!=j) {
							result.add(arr[k]);
						}
					}
					Collections.sort(result);
					int[] answer = new int[7];
					for(int k = 0;k<7;k++) {
						answer[k] = result.get(k);
					}
					return answer;
					
				}
			}
			for (int j = i + 1; j < 9; j++) {
				if(sum-arr[i]-arr[j]==100) {
					for(int k = 0;k<9;k++) {
						if(k!=i&&k!=j) {
							result.add(arr[k]);
						}
					}
					Collections.sort(result);
					int[] answer = new int[7];
					for(int k = 0;k<7;k++) {
						answer[k] = result.get(k);
					}
					return answer;
				}
				
			}
		}
		int[] no = {1};
		return no;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		int[] result = search(arr);
		for(int r : result) {
			System.out.println(r);
		}
	}

}
