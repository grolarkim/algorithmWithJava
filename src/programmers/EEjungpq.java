package programmers;

import java.util.*;

public class EEjungpq {
    public static void main(String[] args) {
        String[] a1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] a2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(new Solution().solution(a1)));
        System.out.println(Arrays.toString(new Solution().solution(a2)));
    }


    static class Solution {
        public int[] solution(String[] operations) {
            StringTokenizer st;
            TreeSet<Integer> pq = new TreeSet<>();

            for (String oper : operations) {
                st = new StringTokenizer(oper);
                String str = st.nextToken();
                int target = Integer.parseInt(st.nextToken());

                if (str.equals("I")) {
                    pq.add(target);
                } else if (!pq.isEmpty() && target == 1) {
                    pq.pollLast();
                } else if (!pq.isEmpty()) {
                    pq.pollFirst();
                }
            }
            if (pq.isEmpty()) {
                return new int[]{0, 0};
            }
            int[] answer = {pq.last(), pq.first()};
            return answer;
        }
    }
}
