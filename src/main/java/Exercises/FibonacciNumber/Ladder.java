package Exercises.FibonacciNumber;

/**
 * You have to climb up a ladder. The ladder has exactly N rungs, numbered from 1 to N. With each step, you can ascend by one or two rungs. More precisely:
 * <p>
 * with your first step you can stand on rung 1 or 2,
 * if you are on rung K, you can move to rungs K + 1 or K + 2,
 * finally you have to stand on rung N.
 * Your task is to count the number of different ways of climbing to the top of the ladder.
 * <p>
 * For example, given N = 4, you have five different ways of climbing, ascending by:
 * <p>
 * 1, 1, 1 and 1 rung,
 * 1, 1 and 2 rungs,
 * 1, 2 and 1 rung,
 * 2, 1 and 1 rungs, and
 * 2 and 2 rungs.
 * Given N = 5, you have eight different ways of climbing, ascending by:
 * <p>
 * 1, 1, 1, 1 and 1 rung,
 * 1, 1, 1 and 2 rungs,
 * 1, 1, 2 and 1 rung,
 * 1, 2, 1 and 1 rung,
 * 1, 2 and 2 rungs,
 * 2, 1, 1 and 1 rungs,
 * 2, 1 and 2 rungs, and
 * 2, 2 and 1 rung.
 * The number of different ways can be very large, so it is sufficient to return the result modulo 2P, for a given integer P.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] A, int[] B); }
 * <p>
 * that, given two non-empty arrays A and B of L integers, returns an array consisting of L integers specifying the consecutive answers; position I should contain the number of different ways of climbing the ladder with A[I] rungs modulo 2B[I].
 * <p>
 * For example, given L = 5 and:
 * <p>
 * A[0] = 4   B[0] = 3
 * A[1] = 4   B[1] = 2
 * A[2] = 5   B[2] = 4
 * A[3] = 5   B[3] = 3
 * A[4] = 1   B[4] = 1
 * the function should return the sequence [5, 1, 8, 0, 1], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * L is an integer within the range [1..50,000];
 * each element of array A is an integer within the range [1..L];
 * each element of array B is an integer within the range [1..30].
 */
public class Ladder {

    public int[] solution(int[] A, int[] B) {

        int length = A.length;

        // Maximum Fibonacci input to calculate, so we avoid to calculate same values multiple times
        int maxFibInput = 0;
        for (int i = 0; i < length; i++) {
            maxFibInput = Math.max(A[i], maxFibInput);
        }

        // Calculate Fibonacci progression until the maximum calculated value
        int[] fib = new int[maxFibInput + 1];   // We sum 1, because we have 2 seeds

        // Fibonacci seeds
        fib[0] = 1;
        fib[1] = 1;

        for (int j = 2; j <= maxFibInput; j++) {
            fib[j] = fib[j - 1] + fib[j - 2];
        }

        int[] ret = new int[length];
        System.out.print("OUTPUT: ");
        for (int i = 0; i < length; i++) {
            ret[i] = fib[A[i]] % (1 << B[i]);    // Math property: 2 power B[i] == 1 << B[i]
            System.out.print(ret[i] + ", ");
        }

        return ret;
    }

}