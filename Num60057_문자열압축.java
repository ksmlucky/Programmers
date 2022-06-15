package PROGRAMMERS.level2;

public class Num60057_문자열압축 {
    private static class Solution {
        private int solution(String s) {
            int length = s.length() / 2;
            int answer = length;
            int min = Integer.MAX_VALUE;

            int count = 0;
            for (int i = 1; i <= length; i++) {
                int zipLevel = 1;                           // 현재 압축정도
                String zipStr = s.substring(0, i);          // 압축할 문자
                StringBuilder result = new StringBuilder(); // 압축완료한 문자를 저장할 StringBuilder

                for(int j = i; j <= s.length(); j += i){
                    // 다음 문자 추출
                    String next = s.substring(j, j + i > s.length() ? s.length() : i + j);
                    // 다음 문자와 현재 문자가 같으면 zipLevel증가
                    if(zipStr.equals(next)) zipLevel++;
                        // 다음 문자와 현재 문자가 다를 경우
                    else{
                        // (압축이 안됬을 경우는 공백, 압축이 됬을경우 zipLevel을 붙여줌) + 압축할 문자를 넣어줌,
                        result.append((zipLevel != 1 ? zipLevel : "") + zipStr);
                        zipStr = next;      // 다음 문자를 압축할 문자로 지정
                        zipLevel = 1;       // 압축 정도 1로 초기화
                    }
                }
                result.append(zipStr);      // 마지막에 추가안된 zipStr추가
                answer = Math.min(answer, result.length()); // 가장 작은 문자열 길이 저장
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("aabbaccc"));
        System.out.println(sol.solution("ababcdcdababcdcd"));
        System.out.println(sol.solution("abcabcdede"));
        System.out.println(sol.solution("abcabcabcabcdededededede"));
        System.out.println(sol.solution("xababcdcdababcdcd"));
    }
}
