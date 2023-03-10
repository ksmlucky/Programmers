// 코딩테스트 연습 - 연습문제 - 시저 암호
// https://programmers.co.kr/learn/courses/30/lessons/12926

package PROGRAMMERS.level1;

public class Num12926_시저암호 {
    private static class Solution {
        private String solution(String s, int n) {
            String answer = "";

            char[] charStr = s.toCharArray();

            for (int i = 0; i < s.length(); i++) {
                if (charStr[i] == ' ') {
                    answer += ' ';
                }
                if (charStr[i] >= 'a' && charStr[i] <= 'z') {
                    if (charStr[i] + n > 'z') {
                        answer += (char) (charStr[i] - 26 + n);
                    } else {
                        answer += (char) (charStr[i] + n);
                    }
                } else if (charStr[i] >= 'A' && charStr[i] <= 'Z') {
                    if (charStr[i] + n > 'Z') {
                        answer += (char) (charStr[i] - 26 + n);
                    } else {
                        answer += (char) (charStr[i] + n);
                    }
                }
            }


//            // 다른  풀이
//            for (int i = 0; i < s.length(); i++) {
//                char ch = s.charAt(i);
//                if (Character.isLowerCase(ch)) {
//                    ch = (char) ((ch - 'a' + n) % 26 + 'a');
//                } else if (Character.isUpperCase(ch)) {
//                    ch = (char) ((ch - 'A' + n) % 26 + 'A');
//                }
//                answer += ch;
//            }



            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("AB", 1));
        System.out.println(sol.solution("z", 1));
        System.out.println(sol.solution("a B z", 4));
    }
}
