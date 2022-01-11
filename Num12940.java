// 코딩테스트 연습 - 연습문제 - 최대공약수와 최소공배수
// https://programmers.co.kr/learn/courses/30/lessons/12940

package PROGRAMMERS.LEVEL1;

import java.util.Arrays;

public class Num12940 {
    private static class Solution {
        private int[] solution(int n, int m) {
            int[] answer = new int[2];
            int a = n, b = m;

            // 최대공약수
            while (m != 0) {
                int temp = n % m;
                n = m;
                m = temp;
            }
            answer[0] = n;

            // 최소공배수
            answer[1] = a * b / answer[0];

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution(3, 12)));
        System.out.println(Arrays.toString(sol.solution(2, 5)));
    }
}
