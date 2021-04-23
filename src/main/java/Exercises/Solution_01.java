package Exercises;

/**
 *
 */


public class Solution_01 {

    public int solution(int[] A) {
        // write your code in Java SE 8

        int LENGTH = A.length;

        if(LENGTH < 2) {
            return 0;
        }

        int pairs = 0;
        boolean ZERO_INDEX_WAS_USED = false;

        for(int i = 0; i < LENGTH; i++) {

            if(i == LENGTH -1 && ZERO_INDEX_WAS_USED == false) {
                if( ( A[i] + A[0] ) % 2 == 0 ) {
                    pairs++;
                    ZERO_INDEX_WAS_USED = true;
                    break;
                }
            }

            if( (i < LENGTH -1) && ( ( A[i] + A[i+1] ) % 2 ) == 0 ) {
                pairs++;
                if( i == 0 ) {
                    ZERO_INDEX_WAS_USED = true;
                }
                i++;
            }

        }

        return pairs;
    }

}