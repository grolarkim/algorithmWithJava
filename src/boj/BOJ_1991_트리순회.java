package boj;

import java.util.*;

public class BOJ_1991_트리순회 {
	static int N;
	static HashMap<String, String[]> map;
	static HashMap<String, String> mapParent;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new HashMap<>();
		mapParent = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String key = sc.next();
			String[] arr = { sc.next(), sc.next() };
			map.put(key, arr);
			mapParent.put(arr[0], key);
			mapParent.put(arr[1], key);
		}

		preorder("A");
		sb.append('\n');
		inorder("A");
		sb.append('\n');
		postorder("A");
		
		System.out.println(sb.toString());

	}

	static void postorder(String string) {
		String left = map.get(string)[0];
		String right = map.get(string)[1];
		
		if(!left.equals(".")) {
			postorder(left);
		}
		if(!right.equals(".")) {
			postorder(right);
		}
		sb.append(string);		
	}

	static void inorder(String string) {
		String left = map.get(string)[0];
		String right = map.get(string)[1];
		
		if(!left.equals(".")) {
			inorder(left);
		}
		sb.append(string);		
		if(!right.equals(".")) {
			inorder(right);
		}
	}

	static void preorder(String string) {
		String left = map.get(string)[0];
		String right = map.get(string)[1];
		
		sb.append(string);				
		if(!left.equals(".")) {
			preorder(left);
		}
		if(!right.equals(".")) {
			preorder(right);
		}
	}
}
