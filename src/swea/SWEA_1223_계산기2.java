package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SWEA_1223_계산기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();

			int result = calculate(arr);
			System.out.println("#" + test_case + " " + result);
		}
	}

	static int calculate(char[] arr) {
		List<Character> list = postfix(arr);
		Stack<Integer> stack = new Stack<>();
		for (char c : list) {
			if (c >= '0' && c <= '9') {
				stack.push(c - '0');
			} else if (c == '+') {
				int temp = stack.pop() + stack.pop();
				stack.push(temp);
			} else {
				int temp = stack.pop() * stack.pop();
				stack.push(temp);
			}
		}

		return stack.pop();
	}

	static List<Character> postfix(char[] arr) {
		List<Character> list = new ArrayList<>();
		Stack<Character> stack = new Stack<>();
		for (char c : arr) {
			if (c >= '0' && c <= '9') {
				list.add(c);
			} else if (stack.isEmpty()) {
				stack.add(c);
			} else {
				while (!stack.isEmpty()) {
					char d = stack.peek();
					if (c == '*' && d == '+') {
						break;
					}
					list.add(stack.pop());
				}
				stack.add(c);
			}
		}
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}

		return list;
	}
}
