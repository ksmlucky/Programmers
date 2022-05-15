package PROGRAMMERS.level1;

import java.util.Arrays;
import java.util.Stack;

public class Num64061_크레인인형뽑기게임 {
    private static class Solution{
        public int solution(int[][] board, int[] moves) {
            int answer = 0;

            int N = board.length;
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < moves.length; i++) {
                int move = moves[i] - 1;
                int temp = -1;
                for (int j = 0; j < N; j++) {
                    if (board[j][move] != 0) {
                        temp = board[j][move];
                        board[j][move] = 0;
                        break;
                    }
                }

                if (temp > 0) {
                    if (stack.isEmpty()) {
                        stack.push(temp);
                    } else {
                        if (stack.peek() == temp) {
                            stack.pop();
                            answer = answer + 2;
                        } else {
                            stack.push(temp);
                        }
                    }
                }
                temp = -1;
            }

            return answer;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
        }
    }
}
