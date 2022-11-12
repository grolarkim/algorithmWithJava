package programmers;

public class jarisuplus {
    public static void main(String[] args) {
        System.out.println(new jarisuplus().solution(123));
        System.out.println(new jarisuplus().solution(987));
    }

    public int solution(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int answer = 0;
        for (char a : arr) {
            answer += a - '0';
        }

        return answer;
    }
}
