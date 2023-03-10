// 코딩테스트 연습 - 월간 코드 챌린지 시즌3 - 빛의 경로 사이클
// https://school.programmers.co.kr/learn/courses/30/lessons/86052

package PROGRAMMERS.level1;

public class Num82612_부족한금액계산하기 {
    private static class Solution {
        public long solution(int price, int money, int count) {
            long answer = -1;

            long sum = 0;
            for (int i = 1; i <= count; i++) {
                sum += i;
            }
            long total = price * sum;
            answer = total - money;
            if (answer > 0) {
                return answer;
            } else {
                return 0;
            }
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(3, 20, 4));
        }
    }
}
