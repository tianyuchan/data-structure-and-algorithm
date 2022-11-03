package stackandqueue;

import java.util.Stack;

/**
 * @Classname : ValidParentheses
 * @Description : 20. 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/
 * @Author : chentianyu
 * @Date 2022/11/3 22:47
 */


public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (!stack.isEmpty()
                    && ((c == ')' && stack.peek() == '(')
                    || (c == '}' && stack.peek() == '{')
                    || (c == ']' && stack.peek() == '['))
            ) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
