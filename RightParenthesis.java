// 코딩테스트 연습 - 연습문제 - 올바른 괄호
// https://programmers.co.kr/learn/courses/30/lessons/12909

package PROGRAMMERS;

import java.util.Stack;

public class RightParenthesis {
    private static class Solution {
        private boolean solution(String s) {

            Stack<Character> stack = new Stack<>();

            if (s.charAt(0) == ')') {
                return false;
            }

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.add(s.charAt(i));
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    } else if (stack.peek() == '(') {
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("()()"));
        System.out.println(sol.solution("(())()"));
        System.out.println(sol.solution(")()("));
        System.out.println(sol.solution("(()("));
    }
}
