package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1204_최빈수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int test = Integer.parseInt(br.readLine());
			int[] arr = new int[101];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0;i<1000;i++) {
				arr[Integer.parseInt(st.nextToken())]++; 
			}
			int maxIdx = -1;
			int max = 0;
			for(int i = 0;i<=100;i++) {
				if(arr[i]>=max) {
					max = arr[i];
					maxIdx = i;
				}
			}
			System.out.printf("#%d %d",tc,maxIdx).println();
			
			
		}
	}
}
