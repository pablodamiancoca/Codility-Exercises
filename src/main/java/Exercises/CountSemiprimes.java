package Exercises;

import java.util.ArrayList;

/**
 * A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
 * <p>
 * A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
 * <p>
 * You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.
 * <p>
 * Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.
 * <p>
 * For example, consider an integer N = 26 and arrays P, Q such that:
 * <p>
 * P[0] = 1    Q[0] = 26
 * P[1] = 4    Q[1] = 10
 * P[2] = 16   Q[2] = 20
 * The number of semiprimes within each of these ranges is as follows:
 * <p>
 * (1, 26) is 10,
 * (4, 10) is 4,
 * (16, 20) is 0.
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int N, int[] P, int[] Q); }
 * <p>
 * that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.
 * <p>
 * For example, given an integer N = 26 and arrays P, Q such that:
 * <p>
 * P[0] = 1    Q[0] = 26
 * P[1] = 4    Q[1] = 10
 * P[2] = 16   Q[2] = 20
 * the function should return the values [10, 4, 0], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..50,000];
 * M is an integer within the range [1..30,000];
 * each element of arrays P, Q is an integer within the range [1..N];
 * P[i] ≤ Q[i].
 */

// BAD CODE IDEA. Improve or Delete
public class CountSemiprimes {

    public int[] solution(int N, int[] P, int[] Q) {

        // Calculate SemiPrimes
        ArrayList semiPrimes = new ArrayList<Integer>();

        for (int i = 0; i < P.length; i++) {
            int dist = Q[i] - P[i];

            for (int j = P[i]; j <= Q[i]; j++) {

                int foundedPrimeDivisors = 0;

                for (int k = 2; k < dist / 2; k++) {

                    if (j <= k) {
                        break;
                    }


                    if (j % k == 0) {
                        boolean isFirstDivisorPrime = true;

                        // CANDIDATE. If this Candidate a Prime number
                        for (int l = 2; l < k / 2; l++) {
                            if (k % l == 0) {
                                // Not a Prime number
                                isFirstDivisorPrime = false;
                                break;
                            }
                        }

                        if (isFirstDivisorPrime == true) {
                            foundedPrimeDivisors++;
                        }
                    }

                    if (foundedPrimeDivisors == 1 && (j == k * k)) {
                        semiPrimes.add(j);
                    }

                }

                if (foundedPrimeDivisors == 2) {
                    semiPrimes.add(j);
                }
            }
        }

        int[] ret = new int[semiPrimes.size()];

        for (int z = 0; z < semiPrimes.size(); z++) {
            System.out.print(semiPrimes.get(z) + ", ");
            ret[z] = (int) semiPrimes.get(z);
        }

        return ret;
    }

}
