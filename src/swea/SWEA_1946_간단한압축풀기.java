package swea;

import java.util.Scanner;

public class SWEA_1946_간단한압축풀기 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringBuffer sbf = new StringBuffer();
			int N = sc.nextInt();
			for(int i = 1; i <= N; i++) {
				String Ci = sc.next();
				int Ki = sc.nextInt();
				for(int j=0; j<Ki;j++) {
					sbf.append(Ci);
				}
				
			}
			String document = sbf.toString();
			int len = document.length()/10;
			int rem = document.length()%10;
			System.out.println("#"+test_case);
			for(int i=0; i<len;i++) {
				System.out.println(document.substring(10*i, 10*i+10));
			}
			if(rem != 0) {
				System.out.println(document.substring(len*10));
			}
		}
		
	}
}
