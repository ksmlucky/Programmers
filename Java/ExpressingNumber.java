// 코딩테스트 연습 - 연습문제 - 숫자의 표현
// https://programmers.co.kr/learn/courses/30/lessons/12924

package PROGRAMMERS;

public class ExpressingNumber {
    private static class Solution {
        private int solution(int n) {
            int count = 1;  // 숫자 본인도 포함해서
            int idx = 1;

            while (idx <= n / 2) {
                if (function(idx, n)) {
                    count++;
                }
                idx++;
            }

            return count;
        }

        private boolean function(int idx, int n) {
            int sum = 0;

            for (int i = idx; i <= (n / 2) + 1; i++) {
                sum += i;

                if (sum == n) {
                    return true;
                } else if (sum > n) {
                    return false;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(15));

    }
}
