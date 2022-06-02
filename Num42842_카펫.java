// 코딩테스트 연습 - 완전탐색 - 카펫
// https://programmers.co.kr/learn/courses/30/lessons/42842

package PROGRAMMERS.level2;

public class Num42842_카펫 {
    private static class Solution{
        private int[] solution(int brown, int yellow) {
            int sum = brown + yellow;

            for (int i = 3; i < sum; i++) {
                int num = sum / i;

                if (sum % i == 0 && num >= 3) {
                    int c = Math.max(i, num);
                    int r = Math.min(i, num);
                    int center = (c - 2) * (r - 2);

                    if (center == yellow) {
                        return new int[]{c, r};
                    }
                }
            }

            return new int[]{};
        }
        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(10, 2));
            System.out.println(sol.solution(8, 1));
            System.out.println(sol.solution(24, 24));
        }
    }
}
