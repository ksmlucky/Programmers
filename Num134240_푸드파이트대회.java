// 코딩테스트 연습 - 연습문제 - 푸드 파이트 대회
// https://school.programmers.co.kr/learn/courses/30/lessons/134240

package PROGRAMMERS.level1;

public class Num134240_푸드파이트대회 {
    private static class Solution {
        public String solution(int[] food) {
            for (int i = 1; i < food.length; i++) {
                food[i] = food[i] / 2;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < food.length; i++) {
                for (int j = 0; j < food[i]; j++) {
                    sb.append(i);
                }
            }

            StringBuilder answer = new StringBuilder();
            answer.append(sb);
            answer.append(0);
            answer.append(sb.reverse());

            return answer.toString();
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(new int[]{1, 3, 4, 6}));
//            System.out.println(sol.solution(new int[]{1, 7, 1, 2}));
        }
    }
}
