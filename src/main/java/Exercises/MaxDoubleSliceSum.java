package Exercises;

/**
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
 * <p>
 * The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 2
 * A[2] = 6
 * A[3] = -1
 * A[4] = 4
 * A[5] = 5
 * A[6] = -1
 * A[7] = 2
 * contains the following example double slices:
 * <p>
 * double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
 * double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
 * double slice (3, 4, 5), sum is 0.
 * The goal is to find the maximal sum of any double slice.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3
 * A[1] = 2
 * A[2] = 6
 * A[3] = -1
 * A[4] = 4
 * A[5] = 5
 * A[6] = -1
 * A[7] = 2
 * the function should return 17, because no double slice of array A has a sum of greater than 17.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 */
public class MaxDoubleSliceSum {

    public int solution(int[] A) {

        int length = A.length;
        int sum1 = 0, sum2 = 0, maxSum = 0;

        // Minimal default bounds
        int X = 0, Y = 1, Z = 2;

        // Calculate bounds
        for (X = 0; X < length-2; X++) {
            for (Y = X + 1; Y < length - 1; Y++) {
                for (Z = Y + 1; Z < length; Z++) {

                    // Bounds calculated
                    System.out.println("X=" + X + ";Y=" + Y + ";Z=" + Z);

                    // Calculate sums
                    int originalX = X;
                    if (X < Y - 1) {
                        for (; X < Y - 1; X++) {
                            sum1 += A[X + 1];
                        }
                    }
                    X = originalX;  // X value was modified on iteration

                    int originalY = Y;
                    if (Y < Z - 1) {
                        for (; Y < Z - 1; Y++) {
                            sum2 += A[Y + 1];
                        }
                    }
                    Y = originalY;  // Y value was modified on iteration

                    int currentSum = sum1 + sum2;
                    System.out.println("Sum: " + currentSum);
                    System.out.println("--------------------------------------------------------------------------------");

                    maxSum = Math.max(currentSum, maxSum);

                    // Reset sums
                    sum1 = 0;
                    sum2 = 0;
                }
            }
        }

        System.out.println("MaxSum: " + maxSum);
        return maxSum;
    }

}