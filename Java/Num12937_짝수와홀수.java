// 코딩테스트 연습 - 연습문제 - 짝수와 홀수
// https://programmers.co.kr/learn/courses/30/lessons/12937

package PROGRAMMERS.level1;

public class Num12937_짝수와홀수 {
    private static class Solution {
        private String solution(int num) {
            String answer = "";

            if (num % 2 == 0) {
                answer = "Even";
            } else {
                answer = "Odd";
            }

            return answer;
        }
    }
}
