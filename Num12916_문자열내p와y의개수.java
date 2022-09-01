// 코딩테스트 연습 - 연습문제 - 문자열 내 p와 y의 개수
// https://programmers.co.kr/learn/courses/30/lessons/12916

package PROGRAMMERS.level1;

public class Num12916_문자열내p와y의개수 {
    private static class Solution {
        private boolean solution(String s) {
            int count = 0;
            char[] charArr = s.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                if (charArr[i] == 'p'||charArr[i] == 'P') {
                    count++;
                } else if (charArr[i] == 'y'||charArr[i] == 'Y') {
                    count--;
                }
            }
            if (count == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("pPoooyY"));
        System.out.println(sol.solution("Pyy"));
    }
}
