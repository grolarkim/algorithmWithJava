package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1209_sum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc = 1;tc<=10;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100]; 
			for(int i = 0;i<100;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0;j<100;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = Integer.MIN_VALUE;
			for(int i = 0;i<100;i++) {
				int sumr = 0;
				int sumc = 0;
				for(int j=0;j<100;j++) {
					sumr+=arr[i][j];
					sumc+=arr[j][i];
				}
				result = Math.max(Math.max(sumr, sumc), result);
			}
			int sumrc = 0;
			int sumcr = 0;
			for(int i = 0;i<100;i++) {
				sumrc+=arr[i][i];
				sumcr+=arr[i][99-i];
			}
			result = Math.max(Math.max(sumrc, sumcr), result);
			
			System.out.printf("#%d %d",tc,result).println();	
			
			
		}
	}
}
