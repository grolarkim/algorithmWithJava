package programmers;

public class CM3 {
    //문자열 탐색
    public static void main(String[] args) {
        System.out.println(new CM3().solution("vxrvip", "xrviprvipvxrv"));
    }

    static int max;

    public int solution(String reference, String track) {
        dfs(reference, track, 0, 10000);

        return max;
    }

    public static void dfs(String reference, String track, int startIdx, int min) {
        if (startIdx == track.length()) {
            max = Math.max(max, min);
        }
        for (int i = 1; i <= reference.length(); i++) {
            if (startIdx + i <= track.length() && reference.contains(track.substring(startIdx, startIdx + i))) {

                dfs(reference, track, startIdx + i, Math.min(min, i));
            }
        }

    }
}
