// 코딩테스트 연습 - 동적계획법 - 정수 삼각형
// https://programmers.co.kr/learn/courses/30/lessons/43105?language=java

package PROGRAMMERS;

import java.util.Arrays;

public class IntegerTriangle {
    private static class Solution {
        private int solution(int[][] triangle) {
            int[][] arr = new int[triangle.length][triangle.length];

            // 맨 밑줄 채워주기
            for (int i = 0; i < triangle.length; i++) {
                arr[arr.length - 1][i] = triangle[triangle.length - 1][i];
            }

            for (int i = triangle.length - 2; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    arr[i][j] = Math.max(triangle[i][j] + arr[i + 1][j], triangle[i][j] + arr[i + 1][j + 1]);
                }
            }

            return arr[0][0];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}
