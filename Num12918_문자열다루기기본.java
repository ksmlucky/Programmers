// 코딩테스트 연습 - 연습문제 - 문자열 다루기 기본
// https://programmers.co.kr/learn/courses/30/lessons/12918

package PROGRAMMERS.level1;

public class Num12918_문자열다루기기본 {
    private static class Solution {
        private boolean solution(String s) {
            if (s.length() != 4 && s.length() != 6) {
                return false;
            }
            char[] charArr = s.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                if (!(charArr[i] >= '0' && charArr[i] <= '9')) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("a234"));
        System.out.println(sol.solution("1234"));
    }
}
