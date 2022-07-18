package swea;

import java.util.Scanner;

public class SWEA_1936_1대1가위바위보 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		boolean aWin = (a-b == 1)||(a-b==2); 
		if (aWin) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}

	}
}
