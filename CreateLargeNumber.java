// 코딩 테스트 연습 - 탐욕법 - 큰 수 만들기
// https://programmers.co.kr/learn/courses/30/lessons/42883

public class CreateLargeNumber {
    private static class Solution {
        private String solution(String number, int K) {
            StringBuilder sb = new StringBuilder();
            int max = 0, index = 0;

            for (int i = 0; i < number.length() - K; i++) {
                max = 0;
                for (int j = index; j <= i + K; j++) {
                    if (max < number.charAt(j) - '0') {
                        max = number.charAt(j) - '0';
                        index = j + 1;
                    }
                }
                sb.append(max);
            }
            return sb.toString();
        }
    }


    public static void main(String[] args) {
        CreateLargeNumber.Solution sol = new CreateLargeNumber.Solution();

        System.out.println(sol.solution("1924", 2));
        System.out.println(sol.solution("1231234", 3));
        System.out.println(sol.solution("4177252841", 4));

    }
}
