package programmers;

import java.util.StringTokenizer;

public class Minmax {
    public static void main(String[] args) {
        Minmax m = new Minmax();
        System.out.println(m.solution("1 2 3 4"));
        System.out.println(m.solution("-1 -2 -3 -4"));
        System.out.println(m.solution("-1 -1"));
    }

    public String solution(String s) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(s);
        int n = st.countTokens();
        for (int i = 0; i < n; i++) {
            long temp = Long.parseLong(st.nextToken());
            min = Math.min(min, temp);
            max = Math.max(max, temp);
        }
        return min + " " + max;
    }
}
