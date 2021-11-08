package PROGRAMMERS;

public class NormalSquare {
    private static class Solution{
        public long solution(int w, int h) {
            long answer = 0;

            for(int i=0; i<w; i++) {
                answer += h*i/w ;
            }

            return answer * 2;
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.solution(8, 12));
        System.out.println(sol.solution(8, 8));
    }
}
