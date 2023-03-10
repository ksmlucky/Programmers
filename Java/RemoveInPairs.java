// 짝지어 제거하기

import java.util.Stack;

public class RemoveInPairs {
    private static class Solution {
        private int solution(String s) {
//            while (true) {
//                boolean flag = true;
//                for (int i = 0; i < s.length() - 1; i++) {
//                    char c1 = s.charAt(i);
//                    char c2 = s.charAt(i + 1);
//                    if (c1 == c2) {
//                        s = s.substring(0, i) + s.substring(i + 2);
//
//                        flag = false;
//                        break;
//                    }
//                }
//                if (s.length() == 0 || flag) {
//                    break;
//                }
//            }
//            if (s.length() == 0) {
//                return 1;
//            } else {
//                return 0;
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
        Solution sol = new Solution();
        System.out.println(sol.solution("baabaa"));
        System.out.println(sol.solution("cdcd"));

    }
}
