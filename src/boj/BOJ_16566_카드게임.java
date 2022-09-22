package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16566_카드게임 {
	static int N;
	static int M;
	static int K;
	static int[] arr;
	static int[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[M];
		check = new int[M];
		for(int i = 0;i<M;i++) {
			check[i] = i;
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0;i<K;i++) {
			int a = Integer.parseInt(st.nextToken());
			int idx = Arrays.binarySearch(arr, a+1);
			if(idx < 0) {
				idx = -idx-1;
			}
			
			int result = arr[get(idx)];
			remove(get(idx));
			bw.write(result+"\n");
			
		}
		bw.flush();
		bw.close();
		br.close();

	}

	private static void remove(int idx) {
		check[idx] = idx+1;
		
	}

	private static int get(int idx) {
		if(check[idx] == idx) {
			return idx;
		}
		
		return check[idx] = get(check[idx]);
	}
}
