package boj.y2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10942 {

    private static int N, M;
    private static int[] nums;
    private static int[][] dps;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N + 1];
        dps = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
            dps[i][i] = 1;
            dps[i - 1][i] = nums[i - 1] == nums[i] ? 1 : 0;
        }
        for (int j = 2; j < N; j++) {
            for (int i = 1; i + j <= N; i++) {
                if (nums[i] == nums[i + j] && dps[i + 1][i + j - 1] == 1) {
                    dps[i][i + j] = 1;
                }
            }
        }

        M = Integer.valueOf(br.readLine());
        for (int tc = 0; tc < M; tc++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.valueOf(st.nextToken());
            int E = Integer.valueOf(st.nextToken());
            int answer = dps[S][E];
            bw.write(String.valueOf(answer) + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }

}
