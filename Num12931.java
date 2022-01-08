// 코딩테스트 연습 - 연습문제 - 자릿수 더하기
// https://programmers.co.kr/learn/courses/30/lessons/12931

package PROGRAMMERS;

public class Num12931 {
    private static class Solution {
        private int solution(int n) {
            int sum = 0;

            while (n != 0) {
                sum += n % 10;
                n /= 10;
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(123));
        System.out.println(sol.solution(987));
    }
}
