// 코딩테스트 연습 - 정렬 - K번째수
// https://programmers.co.kr/learn/courses/30/lessons/42748?language=java

package PROGRAMMERS.level1;

import java.util.Arrays;

public class Num42748_K번째수 {
    private static class Solution{
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            for(int i =0; i<commands.length; i++) {
                int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
                Arrays.sort(temp);
                answer[i] = temp[commands[i][2] - 1];
            }
            return answer;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}));
        }
    }
}
