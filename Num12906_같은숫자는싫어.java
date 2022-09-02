// 코딩테스트 연습 - 스택/큐 - 같은 숫자는 싫어
// https://programmers.co.kr/learn/courses/30/lessons/12906

package PROGRAMMERS.level1;

import java.util.Arrays;
import java.util.Stack;

public class Num12906_같은숫자는싫어 {
    private static class Solution {
        private int[] solution(int []arr) {
            Stack<Integer> stack = new Stack<>();
            for (int temp : arr) {
                if (stack.isEmpty()) {
                    stack.push(temp);
                } else {
                    if (stack.peek() == temp) {
                        stack.pop();
                        stack.push(temp);
                    } else {
                        stack.push(temp);
                    }
                }
            }

            int[] answer = new int[stack.size()];
            for (int i = answer.length - 1; i >= 0; i--) {
                answer[i] = stack.pop();
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
        System.out.println(Arrays.toString(sol.solution(new int[]{4, 4, 4, 3, 3})));
    }
}
