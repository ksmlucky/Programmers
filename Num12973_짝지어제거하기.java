package PROGRAMMERS.level2;

import java.util.Stack;

public class Num12973_짝지어제거하기 {
    public static class Solution {
        public int solution(String s) {
            Stack<Character> stack = new Stack<Character>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            
            if (stack.isEmpty()) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("baabaa"));
        System.out.println(s.solution("cdcd"));
    }
}
