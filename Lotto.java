// 코딩테스트 연습 - 2021 Dev-Matching: 웹 백엔드 개발자(상반기) - 로또의 최고 순위와 최저 순위
// https://programmers.co.kr/learn/courses/30/lessons/77484

package PROGRAMMERS;

import java.util.Arrays;

public class Lotto {
    private static class Solution {
        private int[] solution(int[] lottos, int[] win_nums) {
            int zeroCount = 0;
            int win = 0;
            int rank = 7;

            for (int i = 0; i < lottos.length; i++) {
                if (lottos[i] == 0) {
                    zeroCount++;
                }
            }

            for (int i = 0; i < lottos.length; i++) {
                for (int j = 0; j < lottos.length; j++) {
                    if (lottos[i] == win_nums[j]) {
                        win++;
                        break;
                    }
                }
            }

//            int[] answer = new int[2];
//            answer[0] = rank - win - zeroCount;
//            answer[1] = rank - win;

//            if (answer[0] == 7) {
//                answer[0] = 6;
//            }
//            if (answer[1] == 7) {
//                answer[1] = 6;
//            }

            int[] answer = {Math.min(rank - win - zeroCount, 6), Math.min(rank - win, 6)};

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();


        System.out.println(Arrays.toString(sol.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
        System.out.println(Arrays.toString(sol.solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25})));
        System.out.println(Arrays.toString(sol.solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35})));
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 2, 3, 4, 5, 6}, new int[]{7, 8, 9, 10, 11, 12})));
    }
}
