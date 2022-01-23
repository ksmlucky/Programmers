// 코딩테스트 연습 - 연습문제 - 두 정수 사이의 합
// https://programmers.co.kr/learn/courses/30/lessons/12912

package PROGRAMMERS.level1;

public class Num12912 {
    private static class Solution {
        private long solution(int a, int b) {
            long answer = 0;
            int temp = 0;
            if (a > b) {
                temp = b;
                b = a;
                a = temp;
            }
            for (int i = a; i <= b; i++) {
                answer += i;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(3, 5));
        System.out.println(sol.solution(3, 3));
        System.out.println(sol.solution(5, 3));
    }
}
