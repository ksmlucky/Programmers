// 코딩테스트 연습 - 연습문제 - 문자열 내림차순으로 배치하기
// https://programmers.co.kr/learn/courses/30/lessons/12917

package PROGRAMMERS.level1;

import java.util.Arrays;

public class Num12917_문자열내림차순으로배치하기 {
    private static class Solution {
        private String solution(String s) {
            char[] charArr = s.toCharArray();

            Arrays.sort(charArr);

//            // 이런 방법도 있음 sb의 메서드를 잘 이용하자!
//            StringBuilder sb = new StringBuilder(new String(charArr, 0, charArr.length));
//            return sb.reverse().toString();

            // 아니면 정수배열에 넣어서 Collections.reverseOrder()하던가?


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
