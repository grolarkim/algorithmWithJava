package programmers;

public class CM2 {
    //그리디
    public static void main(String[] args) {
        int result = new CM2().solution(300, new int[]{2000, 1000, 3000, 200, 600, 500}, new int[][]{{2, 3, -1, -1, -1}, {4, 0, -1, -1, 6}, {5, 0, 0, 0, 0}, {-1, 0, 0, 0, 0}, {-1, -1, -1, -1, -1}, {-1, -1, 0, 0, 0}});
        System.out.println(result);
    }


    static int K;
    static int[] limitArr;
    static int[][] socketArr;
    static int cnt;
    public int solution(int k, int[] limits, int[][] sockets){
        K = k;
        limitArr = limits;
        socketArr = sockets;
        cnt = 0;
        dfs(socketArr[0], 0);
        return cnt;
    }

    public static int dfs(int[] arr, int index){
        int con = 0;
        for (int i = 0; i < 5; i++) {
            if(arr[i] > 0){
                arr[i] = dfs(socketArr[arr[i]-1], arr[i]-1);
            }
            con += arr[i];
        }
        int limit = limitArr[index];
        while(true){
            if(limit + con*K >= 0){
                break;
            }
            con++;
            cnt++;
        }

        return con;
    }
}
