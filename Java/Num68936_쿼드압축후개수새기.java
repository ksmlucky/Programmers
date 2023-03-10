// 코딩테스트 연습 - 월간 코드 챌린지 시즌1 - 쿼드압축 후 개수
// https://school.programmers.co.kr/learn/courses/30/lessons/68936

package PROGRAMMERS.level2;

import java.util.Arrays;

public class Num68936_쿼드압축후개수새기 {
    private static class Solution{
        static int count0;
        static int count1;

        private int[] solution(int[][] arr) {
            count0 = 0;
            count1 = 0;

            function(arr, 0, 0, arr.length);

            int[] answer = {count0, count1};
            return answer;
        }

        // 범위 안에 있는 애들이 다 같은 숫자인지(압축할 수 있는지)
        private static boolean check(int[][] arr, int r, int c, int length) {
            for (int i = r; i < r + length; i++) {
                for (int j = c; j < c + length; j++) {
                    if (arr[i][j] != arr[r][c]) {
                        return false;
                    }
                }
            }
            return true;
        }

        private static void function(int[][] arr, int r, int c, int length) {
            if (check(arr, r, c, length)) { // true면 return -> 다음 단계로 넘어가지 않음
                if (arr[r][c] == 0) {
                    count0++;
                } else {
                    count1++;
                }
                return;
            }

            // 4분할해서 다음 단계 실행하기
            function(arr, r, c, length / 2);
            function(arr, r, c + length / 2, length / 2);
            function(arr, r + length / 2, c, length / 2);
            function(arr, r + length / 2, c + length / 2, length / 2);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
        System.out.println(Arrays.toString(sol.solution(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}})));
    }

}
