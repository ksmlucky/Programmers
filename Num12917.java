// 코딩테스트 연습 - 연습문제 - 문자열 내림차순으로 배치하기
// https://programmers.co.kr/learn/courses/30/lessons/12917

package PROGRAMMERS.level1;

import java.util.Arrays;

public class Num12917 {
    private static class Solution {
        private String solution(String s) {
            char[] charArr = s.toCharArray();

            Arrays.sort(charArr);

            char[] newCharArr = new char[charArr.length];

            for (int i = charArr.length - 1; i >= 0; i--) {
                newCharArr[i] = charArr[(charArr.length - 1) - i];
            }

            String str = new String(newCharArr);

            return str;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("Zbcdefg"));
    }
}
