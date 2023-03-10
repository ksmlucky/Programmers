// 코딩테스트 연습 - 2017 팁스타운 - 짝지어 제거하기
// https://school.programmers.co.kr/learn/courses/30/lessons/12973

package PROGRAMMERS.level2;

import java.util.Stack;

public class Num12973_짝지어제거하기 {
    public static class Solution {
        public int solution(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char temp = s.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(temp);
                } else {
                    if (stack.peek() == temp) {
                        stack.pop();
                    } else {
                        stack.push(temp);
                    }
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
