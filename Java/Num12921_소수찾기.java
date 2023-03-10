// 코딩테스트 연습 - 연습문제 - 소수 찾기
// https://programmers.co.kr/learn/courses/30/lessons/12921

package PROGRAMMERS.level1;

public class Num12921_소수찾기 {
    private static class Solution {
        private int solution(int n) {
            int answer = 0;
            for (int i = 2; i <= n; i++) {
                if (isAnswer(i)) {
                    answer++;
                }
            }

            return answer;
        }

        public boolean isAnswer(int n) {
            int count = 0;
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    count++;
                    if (count > 1) {
                        return false;
                    }
                }
            }

            if (count == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(1));    // 0
        System.out.println(sol.solution(2));    // 1
        System.out.println(sol.solution(3));    // 2
        System.out.println(sol.solution(4));    // 2
        System.out.println(sol.solution(5));    // 3
        System.out.println(sol.solution(6));    // 3
        System.out.println(sol.solution(7));    // 4
        System.out.println(sol.solution(8));    // 4
        System.out.println(sol.solution(9));    // 4
        System.out.println(sol.solution(10));   // 4
    }
}
