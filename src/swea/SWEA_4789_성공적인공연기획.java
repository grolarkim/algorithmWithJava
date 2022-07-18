package swea;

import java.util.Scanner;

public class SWEA_4789_성공적인공연기획 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String inputs = sc.next();
			int[] arr = new int[inputs.length()];
			for (int i = 0; i < inputs.length(); i++) {
				arr[i] = Character.getNumericValue(inputs.charAt(i));
			}
			int sum = 0;
			int result = 0;
			for (int i = 0; i < arr.length; i++) {
				if(i>sum) {
					result = Math.max(result, i-sum);
				}
				sum += arr[i];
			}
			System.out.println("#"+test_case+" "+result);

		}
	}
}
