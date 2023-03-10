// 월간 코드 챌린지 시즌2 - 괄호 회전하기
// https://programmers.co.kr/learn/courses/30/lessons/76502

import java.util.Stack;

public class RotatingParentheses {
    private static class Solution {
        private int solution(String s){
            int answer = 0;

            for (int i = 0; i < s.length(); i++) {
                if (isCorrect(s)) {
                    answer++;
                }
                //문자열 한칸 이동
                s = s.substring(1, s.length()) + s.charAt(0);
            }

            return answer;
        }

        private boolean isCorrect(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else if(!stack.isEmpty()) {
                    if(c == ')' && stack.peek() == '(') {
                        stack.pop();
                    }
                    else if(c == '}' && stack.peek() == '{') {
                        stack.pop();
                    }
                    else if(c == ']' && stack.peek() == '[') {
                        stack.pop();
                    }
                } else {
                    return false;
                }
            }

            if(stack.isEmpty()) {
                return true;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "[](){}";
        String s1 = "}]()[{";
        String s2 = "[)(]";

        System.out.println(sol.solution(s));
        System.out.println(sol.solution(s1));
        System.out.println(sol.solution(s2));
    }
}
