package Exercises.Demo;

/**
 *
 */
public class Demo_Exercise_01 {

    public int solution(int[] A) {
        // write your code in Java SE 8

        int length = A.length;

        int[] POSITIVE_CANDIDATES = new int[length + 1];

        for (int i = 0; i < length; i++) {
            int currentNumber = A[i];
            if (currentNumber > 0 && currentNumber < length) {
                POSITIVE_CANDIDATES[currentNumber] = 1; // NOTE: 1 = occurred
            }
        }

        for (int j = 1; j < length; j++) {              // NOTE: Using j for clarity
            if (POSITIVE_CANDIDATES[j] == 0) {
                return j;
            }
        }

        return length + 1;
    }

}