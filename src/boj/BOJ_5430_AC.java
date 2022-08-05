package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BOJ_5430_AC {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			boolean ascend = true;
			char[] oper = in.readLine().toCharArray();
			int N = Integer.parseInt(in.readLine());
			String a = in.readLine().replace("[", "").replace("]", "");
			int[] arr = new int[0];
			if (N > 0) {
				arr = Stream.of(a.split(",")).mapToInt(Integer::parseInt).toArray();
			}
			int startIdx = 0;
			int endIdx = N;
			for (char o : oper) {
				if (o == 'R') {
					ascend = !ascend;
				} else {
					if (ascend) {
						startIdx++;
					} else {
						endIdx--;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append('[');
			if (startIdx == endIdx) {

			} else if (startIdx > endIdx) {
				System.out.println("error");
				continue;
			} else if (ascend) {
				for (int i = startIdx; i < endIdx; i++) {
					sb.append(arr[i]);
					sb.append(',');
				}
			} else {
				for (int i = endIdx-1; i >= startIdx; i--) {
					sb.append(arr[i]);
					sb.append(',');
				}
			}
			if (startIdx < endIdx) {
				sb.deleteCharAt(sb.length() - 1);
			}
			sb.append(']');
			System.out.println(sb.toString());
		}
	}
}
