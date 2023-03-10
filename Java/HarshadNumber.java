// 코딩테스트 연습 - 연습문제 - 하샤드 수
// https://programmers.co.kr/learn/courses/30/lessons/12947

package PROGRAMMERS;

public class HarshadNumber {
    private static class Solution {
        private boolean solution(int x) {
            boolean answer = true;

            int temp = x;
            int sum = 0;

            while (temp != 0) {
                sum += temp % 10;
                temp = temp / 10;
            }

            if (x % sum == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(10));
        System.out.println(sol.solution(12));
        System.out.println(sol.solution(11));
        System.out.println(sol.solution(13));
    }
}
