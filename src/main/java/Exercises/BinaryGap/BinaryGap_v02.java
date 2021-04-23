package Exercises.BinaryGap;

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
 * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps.
 * Write a function:
 * <p>
 * <p>
 * class Solution { public int solution(int N); }
 * <p>
 * that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
 * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.
 * Assume that:
 * <p>
 * N is an integer within the range [1..2,147,483,647].
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(log(N));
 * expected worst-case space complexity is O(1).
 */
public class BinaryGap_v02 {

    public int solution(int N) {
        // write your code in Java SE 8

        String binaryRepresentation = Integer.toBinaryString(N); // A custom method could be created

        // --------------------------------------------------------------------------------
        // GLOBAL SOLUTION'S VARIABLES
        // --------------------------------------------------------------------------------
        int legnth = binaryRepresentation.length();    // 1-based
        boolean countingGap = false;
        int gapCounter = 0;                            // Counter starts with 0
        int maxGap = 0;                                // If maxGap reach to the final of the algorithm with 0 value, then directly return it

        // --------------------------------------------------------------------------------
        // INPUT EXAMPLES:
        // --------------------------------------------------------------------------------
        // CASE A: 000100100010
        // --------------------------------------------------------------------------------
        for (int i = 0; i < legnth; i++) {
            char currentDigit = binaryRepresentation.charAt(i);

            if ((currentDigit == '0')) {
                if (countingGap == false) {
                    break;
                } else { // countingGap == true
                    gapCounter++;
                }
            } else { // currentDigit = '1'
                if (countingGap == false) {
                    countingGap = true;
                    gapCounter = 0;
                } else { // countingGap = True
                    if (gapCounter > maxGap) {
                        maxGap = gapCounter;
                        gapCounter = 0;                     // Reset Counter
                    }
                }
            }
        }

        return maxGap;
    }

}