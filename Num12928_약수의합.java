// 코딩테스트 연습 - 연습문제 - 약수의 합
// https://programmers.co.kr/learn/courses/30/lessons/12928

package PROGRAMMERS.level1;

public class Num12928_약수의합 {
    private static class Solution {
        private int solution(int n) {
            int answer = 0;

            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    answer += i;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(12));
        System.out.println(sol.solution(5));
        System.out.println(sol.solution(0));
    }
}
