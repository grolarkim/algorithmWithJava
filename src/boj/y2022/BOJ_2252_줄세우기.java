package boj.y2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기 {
	static int N;
	static int M;
	static List<List<Integer>> lists;
	static int[] indegree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lists = new ArrayList<List<Integer>>();
		for(int i = 0;i<=N;i++) {
			lists.add(new ArrayList<>());
		}
		indegree = new int[N+1];
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lists.get(a).add(b);
			indegree[b]++;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> result = new LinkedList<Integer>();
		
		for(int i = 1;i<=N;i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int a = q.poll();
			result.add(a);
			
			for(Integer i : lists.get(a)) {
				if(--indegree[i] == 0) {
					q.add(i);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!result.isEmpty()) {
			sb.append(result.poll()).append(' ');
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
		
	}
}
