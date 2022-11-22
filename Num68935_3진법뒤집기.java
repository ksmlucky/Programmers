// 코딩테스트 연습 - 월간 코드 챌린지 시즌1 - 3진법 뒤집기
// https://school.programmers.co.kr/learn/courses/30/lessons/68935

package PROGRAMMERS.level1;

public class Num68935_3진법뒤집기 {
    private static class Solution {
        public int solution(int n) {
            String answerStr = "";
            while (n != 0) {
                answerStr += n % 3;
                n /= 3;
            }

            return Integer.parseInt(answerStr, 3);
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(45));
            System.out.println(sol.solution(125));
        }
    }
}
