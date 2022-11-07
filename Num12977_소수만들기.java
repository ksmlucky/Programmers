// 코딩테스트 연습 - Summer/Winter Coding(~2018) - 소수 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/12977

package PROGRAMMERS.level1;

public class Num12977_소수만들기 {
    static class Solution {
        static int answer;

        public int solution(int[] nums) {
            answer = 0;

            dfs(nums, 0, 0, 0);

            return answer;
        }

        public static void dfs(int[] nums, int start, int depth, int sum) {
            if (depth == 3) {
                if (isPrime(sum)) {
                    answer++;
                }
                return;
            }

            for (int i = start; i < nums.length; i++) {
                dfs(nums, i + 1, depth + 1, sum + nums[i]);
            }
        }

        public static boolean isPrime(int num) {
            for (int i = 2; i < num / 2; i++) {
                if (num % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[]{1, 2, 3, 4}));
        System.out.println(sol.solution(new int[]{1, 2, 7, 6, 4}));
    }
}
