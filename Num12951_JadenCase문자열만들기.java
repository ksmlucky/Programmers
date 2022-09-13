// JadenCase 문자열 만들기
// https://programmers.co.kr/learn/courses/30/lessons/12951

package PROGRAMMERS.level2;

public class Num12951_JadenCase문자열만들기 {
    private static class Solution {
        private String solution(String s) {
            StringBuilder sb = new StringBuilder();

            sb.append((s.charAt(0) + "").toUpperCase());

            for (int i = 1; i < s.length(); i++) {
                String str = s.charAt(i) + "";

                if (str == " ") {
                    sb.append(str);
                } else if (s.charAt(i - 1) == ' ') {
                    sb.append(str.toUpperCase());
                } else {
                    sb.append(str.toLowerCase());
                }
            }

            return sb.toString();

            // String[] str = s.split(" ");
            // return String.join(" ", str);
            // 얘네 때문인지는 모르겠는데 계속 런타임 에러나네요 ㅠ
            // 그래서 다른 방법으로 풀었습니다
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("3people unFollowed me"));
        System.out.println(sol.solution("for the last week"));
    }
}
