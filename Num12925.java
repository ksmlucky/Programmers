// 코딩테스트 연습 - 연습문제 - 문자열을 정수로 바꾸기
// https://programmers.co.kr/learn/courses/30/lessons/12925

package PROGRAMMERS.LEVEL1;

public class Num12925 {
    private static class Solution {
        private int solution(String s) {
//            return Integer.valueOf(s);
            return Integer.parseInt(s);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("1234"));
        System.out.println(sol.solution("-1234"));
    }
}

