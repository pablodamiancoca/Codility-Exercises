package Exercises.StacksAndQueues;

/**
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 * <p>
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * <p>
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 * <p>
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 */

public class Brackets_v01 {

    public int solution(String s) {
        // write your code in Java SE 8

        int openedParentheses = 0, closedParentheses = 0;
        int openedBrackets = 0, closedBrackets = 0;
        int openedCurly = 0, closedCurly = 0;

        for (int i = 0; i <= (s.length() - 1); i++) {
            switch (s.charAt(i)) {
                case '(':
                    openedParentheses++;
                    break;
                case '[':
                    openedBrackets++;
                    break;
                case '{':
                    openedCurly++;
                    break;
                case ')':
                    if (openedParentheses > closedParentheses &&
                            openedBrackets >= closedBrackets &&
                            openedCurly >= closedCurly) {
                        closedParentheses++;
                    } else {
                        return 0;   // Not a well-formed input string
                    }
                    break;
                case ']':
                    if (openedBrackets > closedBrackets &&
                            openedBrackets >= closedBrackets &&
                            openedCurly >= closedCurly) {
                        closedBrackets++;
                    } else {
                        return 0;   // Not a well-formed input string
                    }
                    break;
                case '}':
                    if (openedCurly > closedCurly &&
                            openedBrackets >= closedBrackets &&
                            openedCurly >= closedCurly) {
                        closedCurly++;
                    } else {
                        return 0;   // Not a well-formed input string
                    }
                    break;
                default:
                    return 0;        // Not expected char
            }
        }

        return openedParentheses == closedParentheses &&
                openedBrackets == closedBrackets &&
                openedCurly == closedCurly
                ? 1 : 0;
    }

}