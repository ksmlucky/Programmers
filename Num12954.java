// 코딩테스트 연습 - 연습문제 - x만큼 간격이 있는 n개의 숫자
// https://programmers.co.kr/learn/courses/30/lessons/12954

package PROGRAMMERS.LEVEL1;

public class Num12954 {
    private static class Solution {
        private long[] solution(int x, int n) {
            long[] answer = new long[n];

            for (int i = 0; i < n; i++) {
                answer[i] = x * (i + 1);
            }

            return answer;

//            answer[0] = x;
//
//            for (int i = 1; i < n; i++) {
//                answer[i] = answer[i - 1] + x;
//            }
//
//            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(2, 5));
        System.out.println(sol.solution(4,3));
        System.out.println(sol.solution(-4, 2));
    }
}
