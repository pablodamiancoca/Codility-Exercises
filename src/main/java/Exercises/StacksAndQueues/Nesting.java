package Exercises.StacksAndQueues;

/**
 * A string S consisting of N characters is called properly nested if:
 * <p>
 * S is empty;
 * S has the form "(U)" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * <p>
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
 * <p>
 * For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..1,000,000];
 * string S consists only of the characters "(" and/or ")".
 */
public class Nesting {

    public int solution(String s) {
        // write your code in Java SE 8

        int openedParentheses = 0, closedParentheses = 0;

        for (int i = 0; i <= (s.length() - 1); i++) {
            if (s.charAt(i) == '(') {
                openedParentheses++;
            } else {
                if (openedParentheses > closedParentheses) {     // NOTE: The only other char allowed is ")"
                    closedParentheses++;
                } else {
                    // NOTE: closedParentheses cannot be incremented if
                    // openedParentheses is not greater than closedParentheses
                    // for well-formed strings
                    return 0;
                }
            }
        }

        return (openedParentheses == closedParentheses) ? 1 : 0;    // NOTE: Leaving parenthesis for clarity
    }

}