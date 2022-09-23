package swea;

import java.util.*;

public class SWEA_2112_보호필름 {
	static int T;
	static int D, W, K;
	static int[][] film;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			film = new int[D][W];
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					film[i][j] = sc.nextInt();
				}
			}
			result = Integer.MAX_VALUE;
			sim();
			System.out.println("#" + tc + " " + result);

		}
		sc.close();
	}

	private static void sim() {
        int[] check = new int[D];
        Arrays.fill(check, -1);
         
        dfs(0, check, 0);
 
    }
 
 
    private static void dfs(int depth, int[] check, int cnt) {
        if(depth == D) {
            if(test(check)) {
                result = Math.min(result, cnt);
            }
            return;
        }
         
        dfs(depth+1, check, cnt);
        check[depth] = 1;
        dfs(depth+1, check, cnt+1);
        check[depth] = 0;
        dfs(depth+1, check, cnt+1);
        check[depth] = -1;
         
         
    }
 
    private static boolean test(int[] check) {
        for (int j = 0; j < W; j++) {
            int ab = film[0][j];
            if(check[0] != -1) {
                ab = check[0];
            }
            int cnt = 1;
            for (int i = 1; i < D; i++) {
                if ((check[i] != -1 && check[i] == ab)) {
                    cnt++;                  
                } else if (check[i] != -1 && check[i] != ab) {
                    ab = check[i];
                    cnt = 1;
                } else if (film[i][j] == ab) {
                    cnt++;
                } else {
                    ab = film[i][j];
                    cnt = 1;
                }
 
                if (cnt == K) {
                    break;
                }
            }
            if (cnt < K) {
                return false;
            }
        }
        return true;
    }
}