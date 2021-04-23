package Exercises.Arrays;

import java.util.PriorityQueue;

public class Orderer {

    public int[] solution(int[] A) {

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int value : A) {
            q.add(value);
        }

        int[] ret = new int[A.length];
        for(int i=0; i< A.length; i++) {
            ret[i] = q.poll();
            System.out.print(ret[i] + "- ");
        }

        return ret;
    }
}
