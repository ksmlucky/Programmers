// 코딩테스트 연습 - 연습문제 - 햄버거 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/133502

package PROGRAMMERS.level1;

public class Num133502_햄버거만들기 {
    static class Solution {
        public int solution(int[] ingredient) {
            int answer = 0;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ingredient.length; i++) {
                sb.append(ingredient[i]);
                // 길이가 3보다 크고 마지막 4자리가 "1231"이면
                if (sb.length() > 3 && sb.substring(sb.length() - 4, sb.length()).equals("1231")) {
                    answer++;
                    sb.delete(sb.length() - 4, sb.length()); // sb에서 마지막 4개가 햄버거란 뜻이니까 햄버거 없애기
                }
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println(sol.solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }
}
