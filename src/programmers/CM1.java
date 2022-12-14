package programmers;

import java.util.*;

public class CM1 {
    //완탐?
    public static void main(String[] args) {
        int[] a = new CM1().solution(new int[]{1,2,3,4,4});
        System.out.println(Arrays.toString(a));
    }

    static int[] mar;
    static boolean[] vis;
    static PriorityQueue<Marble> pq;

    public int[] solution(int[] marbles) {
        mar = marbles;
        pq = new PriorityQueue<>();
        for (int i = 1; i <= marbles.length; i++) {
            vis = new boolean[marbles.length];
            dfs(new int[i], 0, i);
        }
        int[] result = pq.poll().arr;
        return result;
    }

    public static void dfs(int[] arr, int depth, int cnt) {
        if (depth == cnt) {
            Marble m = new Marble(arr);
            if(m.length>0){
                pq.add(m);
            }
            return;
        }
        for (int i = 0; i < mar.length; i++) {
            if(!vis[i]){
                vis[i] = true;
                arr[depth] = mar[i];
                dfs(arr, depth+1, cnt);
                vis[i] = false;
            }
        }

    }

    public static class Marble implements Comparable<Marble> {

        public int[] arr;
        public int length;
        public int weight;
        public String arrange;

        public Marble(int[] arr) {
            this.arr = arr.clone();
            this.length = arr.length;
            if ((this.length) % 2 == 1) {
                int wl = 0;
                int wr = 0;
                for (int i = 0; i < this.length / 2; i++) {
                    wl += arr[i];
                }
                for (int i = (this.length / 2) + 1; i < this.length; i++) {
                    wr += arr[i];
                }
                if (wl == wr) {
                    this.weight = wl + wr + arr[this.length / 2];
                    this.arrange = Arrays.toString(arr);
                } else {
                    this.length = -1;
                }

            } else {
                int wl = 0;
                int wr = 0;
                for (int i = 0; i < this.length / 2; i++) {
                    wl += arr[i];
                }
                for (int i = this.length / 2; i < this.length; i++) {
                    wr += arr[i];
                }
                if (wl == wr) {
                    this.weight = wl + wr;
                    this.arrange = Arrays.toString(arr);
                } else {
                    this.length = -1;
                }
            }
        }


        @Override
        public int compareTo(Marble o) {
            if (this.length != o.length) {
                return o.length - this.length;
            }
            if (this.weight != o.weight) {
                return o.weight = this.weight;
            }
            return this.arrange.compareTo(o.arrange);
        }
    }
}
