package Exercises;

import java.util.ArrayList;

/**
 * A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
 * <p>
 * A prime D is called a prime divisor of a positive integer P if there exists a positive integer K such that D * K = P. For example, 2 and 5 are prime divisors of 20.
 * <p>
 * You are given two positive integers N and M. The goal is to check whether the sets of prime divisors of integers N and M are exactly the same.
 * <p>
 * For example, given:
 * <p>
 * N = 15 and M = 75, the prime divisors are the same: {3, 5};
 * N = 10 and M = 30, the prime divisors aren't the same: {2, 5} is not equal to {2, 3, 5};
 * N = 9 and M = 5, the prime divisors aren't the same: {3} is not equal to {5}.
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A, int[] B); }
 * <p>
 * that, given two non-empty arrays A and B of Z integers, returns the number of positions K for which the prime divisors of A[K] and B[K] are exactly the same.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 15   B[0] = 75
 * A[1] = 10   B[1] = 30
 * A[2] = 3    B[2] = 5
 * the function should return 1, because only one pair (15, 75) has the same set of prime divisors.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * Z is an integer within the range [1..6,000];
 * each element of arrays A, B is an integer within the range [1..2,147,483,647].
 */
public class CommonPrimeDivisors {

    public int solution(int[] A, int[] B) {

        int length = A.length;
        int positionsOnWhichPrimeDivisorsAreEquals = 0;

        for (int i = 0; i < length; i++) {
            boolean areSamePrimeDivisors = false;

            int elementA = A[i];
            int elementB = B[i];

            // Calculate Prime divisor of elementA & elementB
            ArrayList primesDivisorA = getPrimeDivisors(elementA);
            ArrayList primesDivisorB = getPrimeDivisors(elementB);

            if (primesDivisorA.size() != 0 && primesDivisorA.size() == primesDivisorB.size()) {
                for (int j = 0; j < primesDivisorA.size(); j++) {
                    if (primesDivisorA.get(j) != primesDivisorB.get(j)) {
                        break;
                    }
                }
                areSamePrimeDivisors = true;
            }

            if (areSamePrimeDivisors == true) {
                positionsOnWhichPrimeDivisorsAreEquals++;
            }

        }

        return positionsOnWhichPrimeDivisorsAreEquals;
    }

    private ArrayList getPrimeDivisors(int number) {
        ArrayList primesDivisor = new ArrayList<Integer>();

        for (int primeCandidate = 2; primeCandidate <= number / 2; primeCandidate++) {
            boolean isPrime = true;

            if (number % primeCandidate == 0) {
                // Prime candidate. Check if it is really a Prime. Could be isolated in a function.
                for (int n = 2; n <= primeCandidate / 2; n++) {
                    if (primeCandidate % n == 0) {
                        // Prime candidate is NOT a Prime
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    primesDivisor.add(primeCandidate);
                }
            }
        }

        return primesDivisor;
    }
}
