// 코딩테스트 연습 - 위클리 챌린지 - 모음사전
// https://programmers.co.kr/learn/courses/30/lessons/84512

package PROGRAMMERS;

public class VowelDictionary {
    private static class Solution {
        private int solution(String word) {
            int answer = word.length();

            String vowels = "AEIOU";
            int[] numbers = {781, 156, 31, 6, 1};

            int count = 0;

            for (int i = 0; i < word.length(); i++) {
                count = vowels.indexOf(word.charAt(i));
                answer = answer + (numbers[i] * count);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("AAAAE"));
        System.out.println(sol.solution("AAAE"));
        System.out.println(sol.solution("I"));
        System.out.println(sol.solution("EIO"));
    }
}
