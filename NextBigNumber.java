// 코딩테스트 연습 - 연습문제 - 다음 큰 숫자
// https://programmers.co.kr/learn/courses/30/lessons/12911?language=java

package PROGRAMMERS;

public class NextBigNumber {
    private static class Solution{
        private int solution(int n) {
            int answer = 0;

            int count1 = countOne(n);
            int count2 = 0;

            for (int i = n + 1; i < 1000000; i++) {
                count2 = countOne(i);

                if (count1 == count2) {
                    answer = i;
                    break;
                }
            }

            return answer;
        }

        int countOne(int number) {
            String str = Integer.toBinaryString(number);

            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    count++;
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.solution(78));
        System.out.println(sol.solution(15));
    }
}
