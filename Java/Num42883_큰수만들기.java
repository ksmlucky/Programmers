// 코딩 테스트 연습 - 탐욕법 - 큰 수 만들기
// https://programmers.co.kr/learn/courses/30/lessons/42883

package PROGRAMMERS.level2;

public class Num42883_큰수만들기 {
    private static class Solution {
        private String solution(String number, int K) {
            StringBuilder sb = new StringBuilder();
            int max = 0, index = 0;

            // 0번부터 number.length() - K번 인덱스까지의 수 중 가장 큰 수 찾기
            for (int i = 0; i < number.length() - K; i++) {
                max = 0;

                // 지금 index부터 오른쪽에서 number.length() - K 번째 인덱스 까지 가장 큰 수 max에 넣기
                for (int j = index; j <= i + K; j++) {
                    if (max < number.charAt(j) - '0') {
                        max = number.charAt(j) - '0';
                        // max 최신화 했으면 인덱스 1 증가
                        index = j + 1;
                    }
                }
                sb.append(max);
            }
            return sb.toString();
        }
    }


    // 조합으로 풀다가 실패
    // 그리디 알고리즘 으로 할 수 있나 잘 생각해보기
    public static void main(String[] args) {
        Num42883_큰수만들기.Solution sol = new Num42883_큰수만들기.Solution();

        System.out.println(sol.solution("1924", 2));
        System.out.println(sol.solution("1231234", 3));
        System.out.println(sol.solution("4177252841", 4));

    }
}
