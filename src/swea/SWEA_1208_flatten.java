package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208_flatten {
	static int[] hMap;
	static int maxH;
	static int minH;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			hMap = new int[101];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<100;i++) {
				int tmp = Integer.parseInt(st.nextToken());
				hMap[tmp]++;
			}
			
			int step = 0;
			while(step<N) {
				maxH = getMax();
				minH = getMin();
				hMap[maxH]--;
				hMap[maxH-1]++;
				hMap[minH]--;
				hMap[minH+1]++;
				step++;
			}
			maxH = getMax();
			minH = getMin();
			System.out.printf("#%d %d",tc,maxH-minH).println();
			
		}

	}
	static int getMax() {
		for(int i = 100;i>0;i--) {
			if(hMap[i]!=0) {
				return i;
			}
		}
		return -1;
	}
	
	static int getMin() {
		for(int i = 0;i<101;i++) {
			if(hMap[i]!=0) {
				return i;
			}
		}
		return -1;
	}
}
