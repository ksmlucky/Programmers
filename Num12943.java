// 코딩테스트 연습 - 연습문제 - 콜라츠 추측
// https://programmers.co.kr/learn/courses/30/lessons/12943

package PROGRAMMERS.LEVEL1;

// int로 하면 테케하나가 자꾸 메모리초과가 되는지 이상한 값이 나옴 -> long 형으로
public class Num12943 {
    private static class Solution {
        private long solution(long num) {
            int count = 0;

            while (count <= 500) {
                if (num == 1) {
                    return count;
                } else if (num % 2 == 0) {
                    num /= 2;
                } else {
                    num = (num * 3) + 1;
                }
                count++;
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(1));
        System.out.println(sol.solution(6));
        System.out.println(sol.solution(16));
        System.out.println(sol.solution(626331));
    }
}
