package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1222_계산기1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();
			int result = 0;
			for(int i = 0;i<arr.length;i+=2) {
				result+=arr[i]-'0';
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}
