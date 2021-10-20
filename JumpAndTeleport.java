// 코딩테스트 연습 - Summer/Winter Coding(~2018) - 점프와 순간 이동
// https://programmers.co.kr/learn/courses/30/lessons/12980

package PROGRAMMERS;

public class JumpAndTeleport {
    private static class Solution{
        private int solution(int n) {
            int ans = 0;

            while (n != 0) {
                if (n % 2 == 0) {
                    n /= 2;
                } else {
                    n -= 1;
                    ans++;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5));
        System.out.println(sol.solution(6));
        System.out.println(sol.solution(5000));
    }
}
