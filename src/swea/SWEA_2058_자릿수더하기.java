package swea;

import java.util.Scanner;

public class SWEA_2058_자릿수더하기 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int a = (T/1000)%10;
		int b = (T/100)%10;
		int c = (T/10)%10;
		int d = T%10;
		int result = a+b+c+d;
		System.out.println(result);
	}
}
