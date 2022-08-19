package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_3499_퍼펙트셔플 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			LinkedList<String> list = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			int len = N / 2;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len; i++) {
				list.add(st.nextToken());
			}
			if (N % 2 == 1) {
				list.add(st.nextToken());
			}
			for (int i = 0; i < len; i++) {
				list.add(2 * i + 1, st.nextToken());
			}

			StringBuilder sb = new StringBuilder();
			sb.append('#').append(tc).append(' ');
			for(String str : list) {
				sb.append(str).append(' ');
			}
			sb.deleteCharAt(sb.lastIndexOf(" "));
			System.out.println(sb.toString());

		}
	}
}
