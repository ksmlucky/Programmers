// 코딩테스트 연습 - 연습문제 - 평균 구하기
// https://programmers.co.kr/learn/courses/30/lessons/12944

package PROGRAMMERS.level1;

public class Num12944_평균구하기 {
    private static class Solution {
        private double solution(int[] arr) {
            double sum = 0;

            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }

            return sum / arr.length;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[]{1, 2, 3, 4}));
        System.out.println(sol.solution(new int[]{5, 5}));
    }
}
