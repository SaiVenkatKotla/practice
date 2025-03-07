package geeksforgeeks;

import java.util.Stack;

public class ParenthesisChecker {

    /**
     * Checks if the parentheses in the given string are balanced.
     *
     * @param s the input string containing parentheses
     * @return true if the parentheses are balanced, false otherwise
     */
    public static boolean isParenthesisBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (!stack.isEmpty()) {
                if(s.charAt(i) == '}' && stack.peek() == '{')
                    stack.pop();
                else if (s.charAt(i) == ')' && stack.peek() == '(')
                    stack.pop();
                else if(s.charAt(i) == ']' && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            }else
                return false;
        }
        return stack.isEmpty(); // Placeholder return
    }

    public static void main(String[] args) {
        // Test cases
        String test1 = "{([])}";
        String test2 = "()";
        String test3 = ")[]";

        System.out.println("Test 1: " + isParenthesisBalanced(test1)); // Expected: true
        System.out.println("Test 2: " + isParenthesisBalanced(test2)); // Expected: true
        System.out.println("Test 3: " + isParenthesisBalanced(test3)); // Expected: false
    }
}

