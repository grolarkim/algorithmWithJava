package boj.y2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Stack;


public class BOJ_9935_문자열폭발 {
	static char[] str;
	static char[] exp;
	static HashMap<Character, Integer> map;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		str = br.readLine().toCharArray();
		exp = br.readLine().toCharArray();
		br.close();
		map = new HashMap<>();
		for (int i = 0; i < exp.length; i++) {
			map.put(exp[i], i);
		}
		sb = new StringBuilder();
		search();
		if (sb.length() == 0) {
			System.out.println("FRULA");
			return;
		} else {
			bw.write(sb.toString() + "\n");
		}
		bw.flush();
		bw.close();

	}

	static void search() {
		Stack<Character> stack = new Stack<>();
		for (char ch : str) {
			stack.add(ch);
			if (stack.size() >= exp.length) {
				boolean isExp = true;

				int s = stack.size();
				for (int i = 0; i < exp.length; i++) {
					if (stack.get(s - 1 - i) != exp[exp.length - 1 - i]) {
						isExp = false;
						break;
					}
				}
				if (isExp) {
					for (int i = 0; i < exp.length; i++) {
						stack.pop();
					}
				}

			}

		}
		for (char ch : stack) {
			sb.append(ch);
		}

	}
}
