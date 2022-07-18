package swea;

import java.util.Scanner;

public class SWEA_1989_초심자의회문검사 {
	public static int is_palindrome(String str) {
		for(int i=0;i<str.length();i++) {
			if(str.charAt(str.length()-1-i)!=str.charAt(i)) {
				return 0;
			}
		}
		
		return 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String str = sc.next();
			System.out.println("#"+test_case+" "+is_palindrome(str));
		}
	}

}
