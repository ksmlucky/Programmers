// 코딩테스트 연습 - 동적계획법 - 정수 삼각형
// https://programmers.co.kr/learn/courses/30/lessons/43105?language=java

package PROGRAMMERS;

public class IntegerTriangle {
    private static class Solution {
        private int solution(int[][] triangle) {
            int[][] dp = new int[triangle.length][triangle.length];
            dp[0][0] = triangle[0][0];

            for (int i = 1; i < triangle.length; i++) {
                for (int j = 0; j < triangle[i].length; j++) {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + triangle[i][j];
                    } else if (j == triangle[i].length - 1) {
                        dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                    }
                }
            }

            int answer = 0;
            for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
                answer = Math.max(answer, dp[triangle.length - 1][i]);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}
