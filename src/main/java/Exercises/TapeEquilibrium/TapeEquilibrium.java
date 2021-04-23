package Exercises.TapeEquilibrium;

public class TapeEquilibrium {

    /**
     * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
     * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
     * <p>
     * For example, consider array A such that:
     * <p>
     * A[0] = 3
     * A[1] = 1
     * A[2] = 2
     * A[3] = 4
     * A[4] = 3
     * <p>
     * Write a function:
     * <p>
     * class Solution { public int solution(int[] A); }
     * <p>
     * that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
     * <p>
     * For example, given:
     * <p>
     * A[0] = 3
     * A[1] = 1
     * A[2] = 2
     * A[3] = 4
     * A[4] = 3
     * <p>
     * We can split this tape in four places:
     * P = 1, difference = |3 − 10| = 7
     * P = 2, difference = |4 − 9| = 5
     * P = 3, difference = |6 − 7| = 1
     * P = 4, difference = |10 − 3| = 7
     * <p>
     * the function should return 1, as explained above.
     */

    public int solution(int[] A) {
        // write your code in Java SE 8

        long length = A.length;
        int leftSum = A[0];
        int rightSum = 0;

        for (int i = 1; i < length; i++) {
            rightSum = rightSum + A[i];
        }

        short currentDiff = (short) Math.abs(rightSum - leftSum);
        short minDiff = currentDiff;

        for (int j = 1; j < length; j++) {
            leftSum = leftSum + A[j];
            rightSum = rightSum - A[j];
            currentDiff = (short) Math.abs(rightSum - leftSum);
            minDiff = (short) Math.min(currentDiff, minDiff);
        }

        return minDiff;
    }
}
