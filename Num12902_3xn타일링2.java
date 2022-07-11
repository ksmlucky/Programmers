// 코딩테스트 연습 - 연습문제 - 3 x n 타일링
// https://school.programmers.co.kr/learn/courses/30/lessons/12902

package PROGRAMMERS.level2;

public class Num12902_3xn타일링2 {
    private static class Solution {
        private static int[] arr = new int[50001];


        private int solution(int n) {
            int answer = 0;
            int mod = 1000000007;
            long[] dp = new long[5001];

            dp[0] = 1;
            dp[2] = 3;
            for(int i=4; i<=n; i+=2){
                dp[i] = dp[i-2] * 3;
                for(int j=i-4; j>=0; j-=2){
                    dp[i] += dp[j] * 2;
                }
                dp[i] = dp[i] % mod;
            }

            answer = (int) dp[n];
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(4));
        System.out.println(sol.solution(6));
        System.out.println(sol.solution(8));
    }
}
