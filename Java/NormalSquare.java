// 멀쩡한 사각형

package PROGRAMMERS;

public class NormalSquare {
    private static class Solution{
        public long solution(int w, int h) {
            long answer = 0;
            long small = h;
            long big = w;
            if (w < h) {
                small = w;
                big = h;
            }

            long value = 1;
            while (value > 0) {
                value = big % small;
                big = small;
                small = value;
            }

            answer = (long)w * (long)h - ((long)w + (long)h - big);
            return answer;
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.solution(8, 12));
        System.out.println(sol.solution(8, 8));
    }
}
