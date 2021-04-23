package Exercises.StacksAndQueues;

import java.util.Stack;

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

public class Brackets_v02 {

    public int solution(String s) {
        // write your code in Java SE 8

        Stack<Character> parser = new Stack<Character>();

        for (int i = 0; i <= (s.length() - 1); i++) {
            switch (s.charAt(i)) {
                case '(':
                    parser.push('('); break;
                case '[':
                    parser.push('['); break;
                case '{':
                    parser.push('{'); break;
                case ')':
                    if (!parser.empty() && parser.lastElement() == '(')
                        parser.pop();
                    else
                        return NotWellFormedString(s);
                    break;
                case ']':
                    if (!parser.empty() && parser.lastElement() == '[')
                        parser.pop();
                    else
                        return NotWellFormedString(s);
                    break;
                case '}':
                    if (!parser.empty() && parser.lastElement() == '{')
                        parser.pop();
                    else
                        return NotWellFormedString(s);
                    break;
                default:
                    return NotExpectedChar(s);
            }
        }

        return parser.empty() ? 1 : 0;
    }

    private int NotWellFormedString(String s) {
        System.out.println("ERROR: Not a well-formed input string: " + s);
        return 0;
    }

    private int NotExpectedChar(String s) {
        System.out.println("ERROR: Not expected char: " + s);
        return 0;
    }

}