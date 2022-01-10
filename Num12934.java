// 코딩테스트 연습 - 연습문제 - 정수 제곱근 판별
// https://programmers.co.kr/learn/courses/30/lessons/12934

package PROGRAMMERS.LEVEL1;

public class Num12934 {
    private static class Solution {
        private long solution(long n) {
            long answer = 0;

            for (long i = 1; i <= n; i++) {
                if (i * i == n) {
                    answer = (i + 1) * (i + 1);
                    break;
                } else {
                    answer = -1;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(121));
        System.out.println(sol.solution(3));
        System.out.println(sol.solution(4));
    }
}
