// 코딩테스트 연습 - 깊이/너비 우선 탐색(DFS/BFS) - 타겟 넘버
// https://programmers.co.kr/learn/courses/30/lessons/43165

package PROGRAMMERS.level2;

public class Num43165_타겟넘버 {
    private static class Solution {
        static int answerCount;
        private int solution(int[] numbers, int target) {
            int sum = 0;
            answerCount = 0;
            solution(numbers, 0, target, sum);

            int answer = answerCount;
            return answer;
        }

        private void solution(int[] numbers, int index, int target, int sum) {
            if (numbers.length == index) {
                if (sum == target) {
                    answerCount++;
                }
                return;
            }

            sum += numbers[index];
            solution(numbers, index + 1, target, sum);
            sum -= numbers[index];

            sum -= numbers[index];
            solution(numbers, index + 1, target, sum);
            sum += numbers[index];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(sol.solution(new int[]{4, 1, 2, 1}, 4));
    }
}
