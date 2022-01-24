// 코딩테스트 연습 - 연습문제 - 가운데 글자 가져오기
// https://programmers.co.kr/learn/courses/30/lessons/12903

package PROGRAMMERS.level1;

public class Num12903 {
    private static class Solution {
        private String solution(String s) {
            int num = 0;
            String str = "";

            if (s.length() % 2 == 0) {
                num = s.length() / 2;
                str = s.charAt(num - 1) + "" + s.charAt(num);
            } else {
                num = s.length() / 2;
                str = s.charAt(num) + "";
            }

            return str;
            // s.substring()을 사용해도 될 듯??
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("abcde"));
        System.out.println(sol.solution("qwer"));
    }
}
