// 코딩테스트 연습 - 스택/큐 - 주식가격
// https://programmers.co.kr/learn/courses/30/lessons/42584

package PROGRAMMERS.level1;

import java.util.Arrays;

public class Num42584_주식가격 {
    private static class Solution {
        private int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            // 이중 포문
            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    answer[i]++;
                    if (prices[i] > prices[j]) {
                        break;
                    }
                }
            }


            // 스택


            return answer;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(Arrays.toString(sol.solution(new int[]{1, 2, 3, 2, 3})));
            System.out.println(Arrays.toString(sol.solution(new int[]{3, 3, 3, 2, 1})));
        }
    }
}
