package PROGRAMMERS.level2;// 코딩테스트 연습 - 월간 코드 챌린지 시즌1 - 이진 변환 반복하기
// https://programmers.co.kr/learn/courses/30/lessons/70129

import java.util.Arrays;

public class Num70129_이진변환반복하기2 {
    private static class Solution {
        private int[] solution(String s) {
            int transCount = 0;
            int totalZeroCount = 0;

            while (!s.equals("1")) {
                transCount++;
                int zeroCount = countZero(s);
                if (zeroCount == 0) {
                    s = Integer.toBinaryString(s.length());

                } else {
                    totalZeroCount += zeroCount;
                    s = Integer.toBinaryString(s.length() - zeroCount);
                }
            }

            return new int[]{transCount, totalZeroCount};
        }

        private static int countZero(String s) {
            int zeroCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroCount++;
                }
            }
            return zeroCount;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(Arrays.toString(sol.solution("110010101001")));
            System.out.println(Arrays.toString(sol.solution("01110")));
            System.out.println(Arrays.toString(sol.solution("1111111")));
        }
    }

}
