package codetree;

import java.util.*;

public class 정수명령어 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			TreeSet<Integer> set = new TreeSet<>();
			int N = sc.nextInt();

			for (int i = 0; i < N; i++) {
				String a = sc.next();
				int x = sc.nextInt();

				if (a.equals("I")) {
					set.add(x);
				} else if (!set.isEmpty() && x == -1) {
					set.remove(set.first());
				} else if (!set.isEmpty() && x == 1) {
					set.remove(set.last());
				}
			}
			
			if(set.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(set.last()+" "+set.first());
			}

		}

	}
}
