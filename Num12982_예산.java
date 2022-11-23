// 코딩테스트 연습 - Summer/Winter Coding(~2018) - 예산
// https://school.programmers.co.kr/learn/courses/30/lessons/12982

package PROGRAMMERS.level1;

import java.util.Arrays;

public class Num12982_예산 {
    private static class Solution {
        public int solution(int[] d, int budget) {
            Arrays.sort(d);

            int count = 0;
            for (int i = 0; i < d.length; i++) {
                if (budget - d[i] < 0) {
                    break;
                }
                budget -= d[i];
                count++;
            }

            return count;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(new int[]{1, 3, 2, 5, 4}, 9));
            System.out.println(sol.solution(new int[]{2, 2, 3, 3}, 10));
        }
    }
}
