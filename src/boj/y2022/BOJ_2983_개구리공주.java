package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_2983_개구리공주 {
	static int N, K;
	static char[] arr;
	static Plant[] ps = new Plant[N];
	static Map<Integer, TreeSet<Plant>> plusMap;
	static Map<Integer, TreeSet<Plant>> minusMap;
	// D C
	// B A
	static Plant now;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = br.readLine().toCharArray();

		ps = new Plant[N];
		plusMap = new HashMap<Integer, TreeSet<Plant>>();
		minusMap = new HashMap<Integer, TreeSet<Plant>>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ps[i] = new Plant(x, y);
			if (!plusMap.containsKey(ps[i].plus)) {
				plusMap.put(ps[i].plus, new TreeSet<>());
			}
			plusMap.get(ps[i].plus).add(ps[i]);
			if (!minusMap.containsKey(ps[i].minus)) {
				minusMap.put(ps[i].minus, new TreeSet<>());
			}
			minusMap.get(ps[i].minus).add(ps[i]);
		}
		now = ps[0];

		for (char ch : arr) {
			simulate(ch);
		}

		System.out.println(now.x + " " + now.y);

	}

	private static void simulate(char ch) {
		TreeSet<Plant> pset = plusMap.get(now.plus);
		TreeSet<Plant> mset = minusMap.get(now.minus);
		Plant next = null;
		switch (ch) {
		case 'A':
			next = mset.higher(now);
			break;
		case 'B':
			next = pset.higher(now);
			break;
		case 'C':
			next = pset.lower(now);
			break;
		case 'D':
			next = mset.lower(now);
			break;
		}
		if (next != null) {
			pset.remove(now);
			mset.remove(now);
			now = next;
		}

	}

	static class Plant implements Comparable<Plant> {
		int x;
		int y;
		int plus;
		int minus;

		public Plant(int x, int y) {
			this.x = x;
			this.y = y;
			this.plus = x + y;
			this.minus = x - y;
		}

		@Override
		public int compareTo(Plant o) {
			return this.x - o.x;
		}

	}
}
