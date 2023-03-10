// 코딩테스트 연습 - 연습문제 - 자연수 뒤집어 배열로 만들기
// https://programmers.co.kr/learn/courses/30/lessons/12932

package PROGRAMMERS.level1;

import java.util.Arrays;

public class Num12932_자연수뒤집어배열로만들기 {
    private static class Solution {
        private int[] solution(long n) {
            String str = String.valueOf(n);
            int[] answer = new int[str.length()];

            String[] strArr = str.split("");

            for (int i = (answer.length - 1); i >= 0; i--) {
                answer[(answer.length - 1) - i] = Integer.parseInt(strArr[i]);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution(12345)));
    }
}
