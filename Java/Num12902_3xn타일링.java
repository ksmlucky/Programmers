// 코딩테스트 연습 - 연습문제 - 3 x n 타일링
// https://school.programmers.co.kr/learn/courses/30/lessons/12902

package PROGRAMMERS.level2;

public class Num12902_3xn타일링 {
    private static class Solution {
        private static int[] arr = new int[50001];


        private int solution(int n) {
            arr[2] = 3;
            arr[4] = 11;

            int answer = dp(n);
            return answer;
        }

        private int dp(int n){
            if (n >= 6 && arr[n] == 0) {

                arr[n] = dp(n - 2) * 3 + dp(n - 4) * 2 + 2;
            }
            return arr[n];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(4));
        System.out.println(sol.solution(6));
        System.out.println(sol.solution(8));
    }
}
