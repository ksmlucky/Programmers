// 코딩테스느 연습 - 연습문제 - 최솟값 만들기
// https://programmers.co.kr/learn/courses/30/lessons/12941

package PROGRAMMERS;

import java.util.Arrays;

public class MakingMin {
    private static class Solution{
        private int solution(int []A, int []B)
        {
            int answer = 0;

            Arrays.sort(A);
            Arrays.sort(B);

            for (int i = 0; i < A.length; i++) {
                answer += A[i] * B[(B.length - 1) - i];
            }

            return answer;
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
        System.out.println(sol.solution(new int[]{1, 2}, new int[]{3, 4}));
    }
}
