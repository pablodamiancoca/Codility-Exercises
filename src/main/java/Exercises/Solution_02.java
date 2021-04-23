package Exercises;

import java.util.Arrays;

/**
 *
 */
public class Solution_02 {

    public int solution(int[] P, int[] S) {
        // write your code in Java SE 8

        int LENGTH = P.length;

        // PSEUDO CODE
        // Count total number of passengers
        // Order cars from max to minimun Seats
        // Start to complete the cars with people

        int totalPassengers = 0;

        for( int i = 0; i < LENGTH; i++) {
            totalPassengers += P[i];
        }

        Arrays.sort(S);

        int usedCars = 0;

        for( int j = LENGTH -1; ( j < LENGTH && totalPassengers > 0 ); j--) {
            int availableSeats = S[j];
            totalPassengers -= availableSeats;
            usedCars++;
        }

        return usedCars;
    }

}