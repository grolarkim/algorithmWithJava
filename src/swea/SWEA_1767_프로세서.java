package swea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SWEA_1767_프로세서 {
	static int T;
	static int N;
	static int[][] table;
	static List<int[]> processors;
	static int[] minArr;
	static int maxConnected;
	static int result;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			table = new int[N][N]; // 프로세서가 올라간 기판 정보
			processors = new ArrayList<int[]>(); // 프로세서의 위치 리스트
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
					if (table[i][j] == 1) {
						processors.add(new int[] { i, j });
					}
				}
			}
			minArr = new int[processors.size() + 1]; // 연결길이 최소값을 저장할 배열
			Arrays.fill(minArr, Integer.MAX_VALUE);

			// 0번째 프로세서, 연결길이 0, 연결된 프로세서개수 0 부터 탐색시작
			dfs(0, 0, 0);
			
			//minArr에서 결과값 빼옴
			getResult();

			System.out.println("#" + tc + " " + result);

		}
		sc.close();
	}
	
	/**
	 * minArr에 담겨있는 최소연결길이 정보 중 연결개수가 가장 많은 값을 찾아서 반환 
	 */
	private static void getResult() {
		for (int i = minArr.length - 1; i >= 0; i--) {
			if (minArr[i] != Integer.MAX_VALUE) {
				result = minArr[i];
				return;
			}
		}

	}
	
	/**
	 * 탐색에 사용한다. 최악의 경우 5^12
	 * @param depth 탐색하는 깊이 => depth번째 프로세서를 의미한다
	 * @param sum 연결길이의 총합
	 * @param connected 연결된 프로세서의 개수
	 */
	private static void dfs(int depth, int sum, int connected) {
		// 기저조건 minArr에 연결 개수와 길이 값을 저장
		if (depth == processors.size()) {
			minArr[connected] = Math.min(minArr[connected], sum);
			return;
		}
		
		// depth번째 프로세서
		int[] processor = processors.get(depth);
		int x = processor[0];
		int y = processor[1];
		
		//프로세서가 외부와 접한 경우
		if (x == 0 || x == N - 1 || y == 0 || y == N - 1) {
			dfs(depth + 1, sum, connected + 1);
			return;
		}

		// 4방향으로 확인, 연결
		for (int dir = 0; dir < 4; dir++) {
			if (isPossible(x, y, dir)) {
				int length = connect(x, y, dir, 2);
				dfs(depth + 1, sum + length, connected + 1);
				connect(x, y, dir, 0);
			} 			
		}
		
		// 연결이 안 될때
		dfs(depth + 1, sum, connected);

	}
	
	/**
	 * 프로세서를 연결 시키기위해 맵에 칠을 함
	 * @param x 프로세서의 row값
	 * @param y 프로세서의 column값
	 * @param dir 연결하는 방향
	 * @param target 칠하는 숫자 => 연결시킬때는 2를 쓰고 복구할때는 0을 씀
	 * @return
	 */
	private static int connect(int x, int y, int dir, int target) {
		int cnt = 0;
		int i = 0;
		while (++i <= N) {
			int nextX = x + dx[dir] * i;
			int nextY = y + dy[dir] * i;

			if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
				break;
			}

			table[nextX][nextY] = target;
			cnt++;
		}
		return cnt;
	}

	/**
	 * 프로세서에서 이 방향으로 연결이 가능한지 여부 반환
	 * @param x 프로세서의 row값
	 * @param y 프로세서의 column값
	 * @param dir 연결하는 방향
	 * @return
	 */
	private static boolean isPossible(int x, int y, int dir) {
		int i = 1;
		while (i <= N) {
			int nextX = x + dx[dir] * i;
			int nextY = y + dy[dir] * i;

			if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
				break;
			}

			if (table[nextX][nextY] != 0) {
				return false;
			}

			i++;
		}
		return true;
	}

}
