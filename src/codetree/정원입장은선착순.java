package codetree;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 정원입장은선착순 {
	static class Person implements Comparable<Person>{
		int ii;
		int aa;
		int tt;
		
		public Person(int ii, int aa, int tt) {
			this.ii = ii;
			this.aa = aa;
			this.tt = tt;
		}

		@Override
		public int compareTo(Person o) {
			return this.ii - o.ii;
		}

		@Override
		public String toString() {
			return "Person [ii=" + ii + ", aa=" + aa + ", tt=" + tt + "]";
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Person> come = new PriorityQueue<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.aa - o2.aa;
			}
		});
		PriorityQueue<Person> queue = new PriorityQueue<>();
		for(int i = 0;i<N;i++) {
			come.add(new Person(i, sc.nextInt(), sc.nextInt()));
		}
		int max = 0;
		int time = 0;
		while(!come.isEmpty() || !queue.isEmpty()) {
			while(!come.isEmpty()) {
				if(come.peek().aa <= time) {
					queue.add(come.poll());
				} else {
					break;
				}
			}
			if(!queue.isEmpty() && queue.peek().aa <= time) {
				Person p = queue.poll();
				max = Math.max(max, time - p.aa);
				time += p.tt;
			} else {
				time++;				
			}
		}
		System.out.println(max);
	}
}
