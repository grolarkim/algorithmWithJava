package codetree;

import java.util.Scanner;
import java.util.TreeSet;

public class treeset기본 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        int N = sc.nextInt();
        for(int i = 0;i<N;i++) {
        	String a = sc.next();
        	int x;
        	switch (a) {
        	case "add":
        		x = sc.nextInt();
        		set.add(x);
        		break;
        	case "remove":
        		x = sc.nextInt();
        		set.remove(x);
        		break;
        	case "find":
        		x = sc.nextInt();
        		System.out.println(set.contains(x));
        		break;
        	case "lower_bound":
        		x = sc.nextInt();
        		System.out.println(set.ceiling(x) == null ? "None" : set.ceiling(x));
        		break;
        	case "upper_bound":
        		x = sc.nextInt();
        		System.out.println(set.higher(x) == null ? "None" : set.higher(x));
        		break;
        	case "largest":
        		System.out.println(set.size() == 0 ? "None" : set.last());
        		break;
        	case "smallest":
        		System.out.println(set.size() == 0 ? "None" : set.first());
        		break;
        	}
        	
        }
        
    }
}
