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
public class CountSemiprimes_v02 {

    public int[] solution(int N, int[] P, int[] Q) {
        ArrayList usedPrimes = calculatePrimes(N);

        int[] ret = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            ArrayList<Integer> semiPrimes = countSemiPrimes(P[i], Q[i], usedPrimes);
            ret[i] = semiPrimes.size();
        }

        return ret;
    }

    private ArrayList calculatePrimes(int maxBound) {
        boolean[] primes = new boolean[maxBound + 1];
        ArrayList primeList = new ArrayList<Integer>();

        int primesL = primes.length;

        for (int p = 2; p < primesL; p++) {
            primes[p] = true;   // Starting value: true
        }

        for (int p = 2; p < primesL; p++) {
            if (primes[p] == true) {
                primeList.add(p);

                for( int i = 2; p*i < primesL; i++ ) {
                    primes[p*i] = false;    // Not a Prime
                }
            }
        }

        return primeList;
    }

    private ArrayList<Integer> countSemiPrimes(int beg, int end, ArrayList usedPrimes) {
        ArrayList<Integer> semiPrimes = new ArrayList<>();
        for (int j = beg; j <= end; j++) {

            for (int z = 0; z < usedPrimes.size(); z++) {
                int currentPrime = (int) usedPrimes.get(z);
                if( j % currentPrime == 0) {
                    int divisor = j / currentPrime;
                    if(usedPrimes.contains(divisor)) {
                        semiPrimes.add(j);
                        break;
                    }
                }
            }
        }
        return semiPrimes;
    }

}
