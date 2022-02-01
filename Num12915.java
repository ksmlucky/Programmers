// 코딩테스트 연습  - 연습문제 - 문자열 내 마음대로 정렬하기
// https://programmers.co.kr/learn/courses/30/lessons/12915

package PROGRAMMERS.level1;

import java.util.Arrays;

public class Num12915 {
    private static class Solution {
        private String[] solution(String[] strings, int n) {
//            char[] charArr = new char[strings.length];
//            String[] newStrings = new String[strings.length];
//
//            for (int i = 0; i < strings.length; i++) {
//                charArr[i] = strings[i].charAt(n);
//            }
//            Arrays.sort(charArr);
//            System.out.println(charArr);
//
//            for (int i = 0; i < strings.length; i++) {
//                for (int j = 0; j < strings.length; j++) {
//                    if (charArr[i] == strings[j].charAt(n)) {
//                        newStrings[i] = strings[j];
//                    }
//                }
//            }
//
//            return newStrings;

            for (int i = 0; i < strings.length; i++) {
                strings[i] = strings[i].charAt(n) + strings[i];
            }

            Arrays.sort(strings);

            for (int i = 0; i < strings.length; i++) {
                strings[i] = strings[i].substring(1, strings[i].length());
            }

            return strings;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution(new String[]{"sun", "bed", "car"}, 1)));
        System.out.println(Arrays.toString(sol.solution(new String[]{"abce", "abcd", "cdx"}, 2)));
    }
}
