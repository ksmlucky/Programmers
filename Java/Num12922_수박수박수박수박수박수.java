// 코딩테스트 연습 - 연습문제 - 수박수박수박수박수박수?
// https://programmers.co.kr/learn/courses/30/lessons/12922

package PROGRAMMERS.level1;

public class Num12922_수박수박수박수박수박수 {
    private static class Solution {
        private String solution(int n) {
            String answer = "";

            for (int i = 1; i <= n; i++) {
                if (i % 2 != 0) {
                    answer += "수";
                } else {
                    answer += "박";
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(3));
        System.out.println(sol.solution(4));
    }
}
