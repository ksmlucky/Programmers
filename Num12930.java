// 코딩테스트 연습 - 연습문제 - 이상한 문자 만들기
// https://programmers.co.kr/learn/courses/30/lessons/12930

package PROGRAMMERS.level1;

public class Num12930 {
    private static class Solution {
        private String solution(String s) {
            String answer = "";
            s = s.toLowerCase();
            String[] str = s.split(" ");

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < str.length; i++) {
                String newStr = str[i];
                for (int j = 0; j < str[i].length(); j++) {
                    if (j % 2 == 0) {
                        answer += newStr.toUpperCase().charAt(j);
                    } else {
                        answer += newStr.toLowerCase().charAt(j);
                    }
                }

                // 마지막에 " " 하나 추가되는거 방지
                if (i < str.length - 1) {
                    answer += " ";
                }
            }

            // 원래 문자열인 s에서 answer의 길이보다 더 긴 공백이 있는 경우
            if (s.length() > answer.length()) {
//                // 이것도 가능
//                answer += s.substring(answer.length(), s.length());
                answer += s.substring(answer.length());

            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("try hello world"));
        System.out.println(sol.solution("sss         sss   "));
    }
}
