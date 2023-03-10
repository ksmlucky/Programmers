// 코딩테스트 연습 - 완전탐색 - 최소직사각형
// https://school.programmers.co.kr/learn/courses/30/lessons/86491

package PROGRAMMERS.level1;

public class Num86491_최소직사각형 {
    private static class Solution {
        private int solution(int[][] sizes) {
            int maxW = 0, maxH = 0;
            for (int[] intArr : sizes) {
                int w = Math.max(intArr[0],intArr[1]), h = Math.min(intArr[0],intArr[1]);

                maxW = Math.max(maxW, w);
                maxH = Math.max(maxH, h);
            }

            int answer = maxW*maxH;
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
        System.out.println(sol.solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
        System.out.println(sol.solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));
    }
}
