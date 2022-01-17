// 코딩테스트 연습 - 연습문제 - 서울에서 김서방 찾기
// https://programmers.co.kr/learn/courses/30/lessons/12919

package PROGRAMMERS.level1;

public class Num12919 {
    private static class Solution {
        private String solution(String[] seoul) {
            String answer = "";
            for (int i = 0; i < seoul.length; i++) {
                if (seoul[i].equals("Kim")) {
                    answer = "김서방은 " + i + "에 있다";
                    break;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new String[]{"Jane", "Kim"}));
    }
}
