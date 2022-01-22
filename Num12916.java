// 코딩테스트 연습 - 연습문제 - 문자열 내 p와 y의 개수
// https://programmers.co.kr/learn/courses/30/lessons/12916

package PROGRAMMERS.level1;

public class Num12916 {
    private static class Solution {
        private boolean solution(String s) {
            int pNum = 0, yNum = 0;
            char[] charArr = s.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                if (charArr[i] == 'p'||charArr[i] == 'P') {
                    pNum++;
                } else if (charArr[i] == 'y'||charArr[i] == 'Y') {
                    yNum++;
                }
            }
            if (pNum == yNum) {
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
