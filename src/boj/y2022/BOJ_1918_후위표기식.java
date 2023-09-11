package boj.y2022;

import java.util.*;

public class BOJ_1918_후위표기식 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] c = str.toCharArray();

		Stack<Character> stack = new Stack<>();
		List<Character> list = new ArrayList<Character>();

		Map<Character, Integer> isp = new HashMap<>();
		isp.put('*', 2);
		isp.put('/', 2);
		isp.put('+', 1);
		isp.put('-', 1);
		isp.put('(', 0);
		Map<Character, Integer> icp = new HashMap<>();
		icp.put('*', 2);
		icp.put('/', 2);
		icp.put('+', 1);
		icp.put('-', 1);
		icp.put('(', 3);

		for (char ch : c) {
			if ('A' <= ch && ch <= 'Z') {
				list.add(ch);
			} else if (ch == ')') {
				while (!stack.isEmpty()) {
					char s = stack.pop();
					if (s == '(') {
						break;
					} else {
						list.add(s);
					}
				}
			} else if (stack.isEmpty()) {
				stack.add(ch);
			} else {
				while (!stack.isEmpty()) {
					if (isp.get(stack.peek()) < icp.get(ch)) {
						break;
					} else {
						list.add(stack.pop());
					}
				}
				stack.add(ch);
			}
		}
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}

		StringBuilder sb = new StringBuilder();
		for (char ch : list) {
			sb.append(ch);
		}
		System.out.println(sb.toString());

	}
}
