package swea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA_2383_점심식사시간 {
	static int T, N, min;
	static int[][] people;
	static int[][] stair;
	static int peopleIdx, stairIdx;
	static boolean[] firstStair;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			min = Integer.MAX_VALUE;
			people = new int[10][4];
			stair = new int[2][3];

			peopleIdx = 0;
			stairIdx = 0;
			
			// 테이블을 저장하는 것이 아니라 사람과 계단의 정보만 배열에 넣어서 저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int a = sc.nextInt();
					if (a == 1) {
						// 사람의 좌표
						people[peopleIdx][0] = i;
						people[peopleIdx][1] = j;
						peopleIdx++;
					} else if (a > 1) {
						// 계단의 좌표와 계단내려가는 시간
						stair[stairIdx][0] = i;
						stair[stairIdx][1] = j;
						stair[stairIdx][2] = a;
						stairIdx++;
					}
				}
			}
			
			// 사람 배열에 사람이 계단에 도착하는 시간들 저장
			getDistances();

			// 첫번째 계단에 내려가는 사람을 저장하는 불린 배열
			firstStair = new boolean[peopleIdx];
			dfs(0);
			
			System.out.println("#"+tc+" "+min);
		}
		sc.close();
	}

	private static void getDistances() {
		for (int i = 0; i < peopleIdx; i++) {
			// 배열의 3번째칸에는 첫 계단 까지의 시간 + 계단 내려가는 준비시간 1
			people[i][2] = Math.abs(people[i][0] - stair[0][0]) + Math.abs(people[i][1] - stair[0][1]) + 1;
			// 배열의 4번째칸에는 두번째 계단 까지의 시간 + 계단 내려가는 준비시간 1
			people[i][3] = Math.abs(people[i][0] - stair[1][0]) + Math.abs(people[i][1] - stair[1][1]) + 1;
		}

	}

	private static void dfs(int depth) {
		// 기저조건 : 모든 사람이 어떤 계단을 통할건지 정한뒤 시뮬레이션
		if (depth == peopleIdx) {
			simulate();
			return;
		}

		dfs(depth + 1);
		firstStair[depth] = true;
		dfs(depth + 1);
		firstStair[depth] = false;

	}

	private static void simulate() {
		// 첫계단에 도착하는 사람 리스트
		List<Integer> fir = new ArrayList<>();
		// 두번쨰계단에 도착하는 사람 리스트
		List<Integer> sec = new ArrayList<>();
		// 첫계단 내려가는 시간
		int firTime = stair[0][2];
		// 두번쨰 계단 내려가는 시간
		int secTime = stair[1][2];

		// dfs결과에 따라 어떤 계단으로 내려갈지 결정
		for (int i = 0; i < firstStair.length; i++) {
			if (firstStair[i]) {
				fir.add(people[i][2]);
			} else {
				sec.add(people[i][3]);
			}
		}

		// 시간 순으로 정렬
		Collections.sort(fir);
		Collections.sort(sec);

		// 각 계단 별 걸리는 시간
		int firstTime = getTime(fir, firTime);
		int stime = getTime(sec, secTime);

		// 계단 별 시간 중 오래걸리는 것과 최소값 비교
		min = Math.min(min, Math.max(firstTime, stime));

	}

	private static int getTime(List<Integer> fir, int firTime) {
		// 계단에 온 사람이 없으면 0초
		if(fir.size() == 0) {
			return 0;
		}
		// 계단에 온 사람이 3명 이하면 마지막 사람이 온시간 + 계단 내려가는 시간
		if (fir.size() <= 3) {
			return fir.get(fir.size() - 1) + firTime;
		}
		
		int result = 0;
		// 세번째 사람까지는 계단에 바로 갈 수 있음 
		for (int i = 0; i < 3; i++) {
			fir.set(i, fir.get(i) + firTime);
		}
		
		// 네번째 사람부터는 전전전 사람이 빠져나가야 나갈 수 있음
		for (int i = 3; i < fir.size(); i++) {
			// 전 사람이 빠져나간 시간과 이번 사람이 도착한 시간중 뒤에것 선택 + 계단 내려가는 시간
			fir.set(i, Math.max(fir.get(i), fir.get(i-3))+firTime);		
			result = fir.get(i);
		}
		return result;
	}

}
