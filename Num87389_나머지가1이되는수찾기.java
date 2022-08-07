// 코딩테스트 연습 - 월간 코드 챌린지 시즌3 - 나머지가 1이 되는 수 찾기
// https://programmers.co.kr/learn/courses/30/lessons/87389

package PROGRAMMERS.level1;

public class Num87389_나머지가1이되는수찾기 {
    private static class Solution {
        private int solution(int n) {
            int answer = 0;

            for (int i = 1; i <= n; i++) {
                if (n % i == 1) {
                    answer = i;
                    break;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(10));
        System.out.println(sol.solution(12));
    }
}
