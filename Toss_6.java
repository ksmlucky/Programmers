public class Toss_6 {
    private static class Solution {
        static long[] dp = new long[71];
        private long solution(int numOfStairs) {

            if (numOfStairs == 1) {
                return 1;
            } else if (numOfStairs == 2) {
                return 2;
            } else if (numOfStairs == 3) {
                return 4;
            } else if (dp[numOfStairs] != 0) {
                return dp[numOfStairs];
            } else {
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;

                dp[numOfStairs] = solution(numOfStairs - 1) + solution(numOfStairs - 2) + solution(numOfStairs - 3);
                return dp[numOfStairs];
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(1));
        System.out.println(sol.solution(2));
        System.out.println(sol.solution(3));
        System.out.println(sol.solution(4));
        System.out.println(sol.solution(5));
        System.out.println(sol.solution(6));
    }
}
