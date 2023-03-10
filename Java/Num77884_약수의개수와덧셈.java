// 코딩테스트 연습 - 월간 코드 챌린지 시즌2 - 약수의 개수와 덧셈
// https://programmers.co.kr/learn/courses/30/lessons/77884

package PROGRAMMERS.level1;

public class Num77884_약수의개수와덧셈 {
    private static class Solution {
        private int solution(int left, int right) {
            int answer = 0;
            for (int i = left; i <= right; i++) {
                if (isAnswer(i) % 2 == 0) {
                    answer += i;
                } else {
                    answer -= i;
                }
            }

            return answer;
        }

        private int isAnswer(int num) {
            int count = 0;

            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    count++;
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(13, 17));
        System.out.println(sol.solution(24, 27));
    }
}
