// 코딩테스트 연습 - 2017 팁스타운 - 예상 대진표
// https://programmers.co.kr/learn/courses/30/lessons/12985?language=java

package PROGRAMMERS;

public class AnticipatedMatch {
    private static class Solution{
        private int solution(int n, int a, int b) {
            int answer = 0;

            while(a != b){
                answer ++;

                a = a / 2 + a % 2;
                b = b / 2 + b % 2;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(8, 4, 7));
    }
}
