// 코딩테스트 연습 - 연습문제 - 삼총사
// https://school.programmers.co.kr/learn/courses/30/lessons/131705

package PROGRAMMERS.level1;

public class Num131705_삼총사 {
    private static class Solution {
        public int solution(int[] number) {
            int answer = 0;
            int sum = 0;

            for (int i = 0; i < number.length; i++) {
                sum += number[i];
                for (int j = i + 1; j < number.length; j++) {
                    sum += number[j];
                    for (int k = j + 1; k < number.length; k++) {
                        sum += number[k];
                        if (sum == 0) {
                            answer++;
                        }
                        sum -= number[k];
                    }
                    sum -= number[j];
                }
                sum -= number[i];
            }

            return answer;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(new int[]{-2, 3, 0, 2, -5}));
            System.out.println(sol.solution(new int[]{-3, -2, -1, 0, 1, 2, 3}));
            System.out.println(sol.solution(new int[]{-1, 1, -1, 1}));
        }
    }
}
