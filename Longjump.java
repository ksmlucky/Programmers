// 코딩 테스트 연습 - 연습문제 - 멀리 뛰기
// https://programmers.co.kr/learn/courses/30/lessons/12914

public class Longjump {
    private static class Solution {
        static long dp[] = new long[2000];
        private long solution(int n) {
            if (n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            } else if (dp[n] != 0) {
                return dp[n] % 1234567;
            } else {
                dp[1] = 1;
                dp[2] = 2;

                dp[n] = solution(n - 1) + solution(n - 2);

                return dp[n] % 1234567;
            }
        }
    }


    public static void main(String[] args) {
        Longjump.Solution sol = new Longjump.Solution();

        System.out.println(sol.solution(4));
        System.out.println(sol.solution(3));
    }
}
