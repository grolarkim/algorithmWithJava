package swea;

import java.io.*;
import java.util.*;

public class SWEA_1218_괄호짝짓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();

			if (isOk(arr)) {
				System.out.println("#"+tc+" 1");
			} else {
				System.out.println("#"+tc+" 0");				
			}

		}
	}

	static boolean isOk(char[] arr) {
		Stack<Character> stack = new Stack<>();
		for (char ch : arr) {
			if (ch == '[' || ch == '{' || ch == '<' || ch == '(') {
				stack.add(ch);
			} else if (stack.isEmpty()) {
				return false;
			} else if (ch == ')' && stack.peek() != '(') {
				return false;
			} else if (ch == '}' && stack.peek() != '{') {
				return false;
			} else if (ch == ']' && stack.peek() != '[') {
				return false;
			} else if (ch == '>' && stack.peek() != '<') {
				return false;
			} else {
				stack.pop();
			}
		}

		return stack.isEmpty();
	}
}
