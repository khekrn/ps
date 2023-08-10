package stack;

import java.util.Stack;

/**
 * Valid Parentheses
 * 
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']',
 * determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * 
 * Example 1:
 * Input: s = "()"
 * Output: true
 * 
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Example 3:
 * Input: s = "(]"
 * Output: false
 * 
 * 
 */

public class ValidParentheses {

    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        
        if (s.length() % 2 != 0) return false;

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() && (s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')')) {
                return false;
            } else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(' && s.charAt(i) == ')') {
                        stack.pop();
                    } else if (stack.peek() == '{' && s.charAt(i) == '}') {
                        stack.pop();
                    } else if (stack.peek() == '[' && s.charAt(i) == ']') {
                        stack.pop();
                    }else{
                        stack.add(s.charAt(i));
                    }

                } else {
                    stack.add(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        var validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()"));
    }

}
