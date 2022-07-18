package swea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1238_Contact {
	public static int bfs(HashMap<Integer, List<Integer>> graphs, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		
		HashMap<Integer, Integer> orders = new HashMap<Integer, Integer>();
		orders.put(start, 0);
		
		boolean[] visited = new boolean[101];
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			visited[x] = true;
			if(graphs.containsKey(x)) {
				List<Integer> graph = graphs.get(x);
				for(int i = 0; i<graph.size();i++) {
					int item = graph.get(i);
					if(!visited[item] && !queue.contains(item)) {
						queue.offer(item);
						orders.put(item, orders.get(x)+1);
					}
				}				
			}
		}
		int order = Collections.max(orders.values());
		List<Integer> orderList = new ArrayList<Integer>();
		for(int key : orders.keySet()) {
			if(orders.get(key)==order) {
				orderList.add(key);
			}
		}
		
		int result = Collections.max(orderList);
		
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case=1;test_case<=10;test_case++) {
			int size = sc.nextInt();
			int start = sc.nextInt();
			HashMap<Integer, List<Integer>> graphs = new HashMap<Integer, List<Integer>>();
			for(int i = 0; i<size/2;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if (graphs.containsKey(a)) {
					List<Integer> arrList = graphs.get(a);
					arrList.add(b);
					graphs.put(a,arrList);
			
				} else {
					List<Integer> arrList = new ArrayList<Integer>();
					arrList.add(b);
					graphs.put(a,arrList);
				}
			}
			System.out.println("#"+test_case+" "+bfs(graphs,start));
			
			
		}
		
	}
}
