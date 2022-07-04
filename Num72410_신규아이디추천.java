// 코딩 테스트 연습 - 2021 KAKAO BLIND RECRUITMENT - 신규 아이디 추천
// https://programmers.co.kr/learn/courses/30/lessons/72410

package PROGRAMMERS.level1;

public class Num72410_신규아이디추천 {
    private static class Solution{
        private String solution(String new_id) {
            String answer = new_id;

            answer = answer.toLowerCase();



            return answer;
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(sol.solution("z-+.^."));
        System.out.println(sol.solution("=.="));
        System.out.println(sol.solution("123_.def"));
        System.out.println(sol.solution("abcdefghijklmn.p"));
    }
}
