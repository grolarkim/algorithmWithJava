package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2930_힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());

			MaxHeapA h = new MaxHeapA();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int size = st.countTokens();
				if (size == 1) {
					int a = h.pop();
					sb.append(' ').append(a);
				} else {
					st.nextToken();
					h.insert(Integer.parseInt(st.nextToken()));
				}
			}

			System.out.println("#" + test_case + sb.toString());

		}
	}
}

class MaxHeapA {
	private int[] arr = new int[300_001];
	public int size = 0;

	public MaxHeapA() {
		arr[0] = Integer.MAX_VALUE;
		size = 0;
	}

	public void insert(int a) {
		size++;
		arr[size] = a;
		int idx = size;
		while (true) {
			if (idx <= 1) {
				break;
			}
			if (idx > 1 && arr[idx] > arr[idx / 2]) {
				int temp = arr[idx];
				arr[idx] = arr[idx / 2];
				arr[idx / 2] = temp;
				idx = idx / 2;
			} else {
				break;
			}
		}
	}

	public int pop() {
		if (size == 0) {
			return -1;
		}
		int re = arr[1];
		arr[1] = arr[size];
		size--;
		
		int idx = 1;
		
		while (true) {
			int next = idx*2;
			if(next+1>size) {
				break;
			}
			if(next+1<=size && arr[next]<arr[next+1]) {
				next++;				
			}

			if (next <= size && arr[idx] < arr[next]) {
				int temp = arr[idx];
				arr[idx] = arr[next];
				arr[next] = temp;
				idx = next;
			} else {
				break;
			}			
		}

		return re;
	}
}