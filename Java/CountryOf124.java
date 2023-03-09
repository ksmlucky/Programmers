// 프로그래머스 - 연습문제 - 124 나라의 숫자
// https://programmers.co.kr/learn/courses/30/lessons/12899

public class CountryOf124 {
    private static class Solution {
        // 3진법이랑 같은데 3대신 4를 쓴다고 생각하면 됨
        private String solution(int n) {
            StringBuilder sb = new StringBuilder();
            String answer = "";
            int a = 0;

            while (n > 0) {
                a = n % 3;

                n = n / 3;

                // 나머지가 0이면 n을 하나 빼서 자릿수를 맞춰주고
                // 3대신 4를 문자열에 추가
                if (a == 0) {
                    n--;
                    a = 4;
                }

                sb.insert(0, a);
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(1));
        System.out.println(sol.solution(2));
        System.out.println(sol.solution(3));
        System.out.println(sol.solution(4));
        System.out.println(sol.solution(86));
    }
}
