// 코딩테스트 연습 - 월간 코드 챌린지 시즌2 - 음양 더하기
// https://programmers.co.kr/learn/courses/30/lessons/76501?language=java

package PROGRAMMERS.level1;

public class Num76501_음양더하기 {
    private static class Solution{
        private int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;

            for(int i = 0; i < absolutes.length; i++) {
                if(signs[i]) {
                    answer += absolutes[i];
                } else {
                    answer -= absolutes[i];
                }
            }

            return answer;
        }
        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(new int[]{4, 7, 12}, new boolean[]{true, false, true}));
            System.out.println(sol.solution(new int[]{1, 2, 3}, new boolean[]{false, false, true}));
        }
    }
}
