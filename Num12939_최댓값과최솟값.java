// 코딩테스트 연습 - 연습문제 - 최댓값과 최솟값
// https://school.programmers.co.kr/learn/courses/30/lessons/12939

package PROGRAMMERS.level2;

import java.util.Arrays;

public class Num12939_최댓값과최솟값 {
    private static class Solution {
        private String solution(String s) {
            String[] strArr = s.split(" ");
            int[] intArr = new int[strArr.length];

            for (int i = 0; i < strArr.length; i++) {
                intArr[i] = Integer.parseInt(strArr[i]);
            }

            Arrays.sort(intArr);

            String answer = intArr[0] + " " + intArr[intArr.length - 1];
            return answer;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution("1 2 3 4"));
            System.out.println(sol.solution("-1 -2 -3 -4"));
            System.out.println(sol.solution("-1 -1"));
        }
    }
}
