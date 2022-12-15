package programmers;

import java.util.*;

public class Daneobyunhwan {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
//        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(new Solution().solution(begin, target, words));
    }

    static class Solution {
        public int solution(String begin, String target, String[] words) {
            int targetIdx = -1;
            for (int i = 0; i < words.length; i++) {
                if (target.equals(words[i])) {
                    targetIdx = i;
                }
            }
            if (targetIdx == -1) {
                // 타겟이 워드에 없으면 0반환
                return 0;
            }
            // 워드에 비긴 추가
            String[] all = new String[words.length + 1];
            for (int i = 0; i < words.length; i++) {
                all[i] = words[i];
            }
            all[all.length - 1] = begin;
            int len = all.length;

            boolean[][] graph = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (isConnected(all[i], all[j])) {
                        graph[i][j] = true;
                    }
                }
            }

            int answer = bfs(all, targetIdx, graph);
            return answer;
        }

        private int bfs(String[] all, int targetIdx, boolean[][] graph) {
            int len = all.length;
            int answer = 0;
            boolean[] visited = new boolean[len];
            Queue<int[]> q = new ArrayDeque<>(52);
            q.add(new int[]{len - 1, 0});
            visited[len - 1] = true;
            while (!q.isEmpty()) {
                int[] now = q.poll();
                for (int i = 0; i < len; i++) {
                    if (!visited[i] && graph[now[0]][i]) {
                        if (i == targetIdx) {
                            answer = now[1] + 1;
                            break;
                        }
                        q.add(new int[]{i, now[1] + 1});
                        visited[i] = true;
                    }
                }
            }

            return answer;

        }

        private boolean isConnected(String w1, String w2) {
            int cnt = 0;
            for (int i = 0; i < w1.length(); i++) {
                if (w1.charAt(i) != w2.charAt(i)) {
                    cnt++;
                }
            }
            return cnt == 1;
        }
    }
}
