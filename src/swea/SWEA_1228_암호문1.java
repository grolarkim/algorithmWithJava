package swea;

import java.io.*;
import java.util.*;
public class SWEA_1228_암호문1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<N;i++) {
				int a = Integer.parseInt(st.nextToken());
				list.add(a);
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<M;i++) {
				String op = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				for(int j = 0;j<y;j++) {
					int b = Integer.parseInt(st.nextToken());
					list.add(x+j, b);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append('#').append(tc).append(' ');
			for(int i =0;i<10;i++) {
				sb.append(list.get(i)).append(' ');
			}
			sb.deleteCharAt(sb.lastIndexOf(" "));
			System.out.println(sb.toString());
			
		}
	}
}
