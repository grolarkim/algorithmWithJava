package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273_두수의합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int X = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		int left = 0;
		int right = N-1;
		int cnt = 0;
		while(left<right) {
			if(arr[left]+arr[right]==X) {
				cnt++;
				left++;
			} else if(arr[left]+arr[right]>X) {
				right--;
			} else {
				left++;
			}
			
		}
		System.out.println(cnt);
	}
}
