// 코딩테스트 연습 - 정렬 - H-Index
// https://school.programmers.co.kr/learn/courses/30/lessons/42747

package PROGRAMMERS.level2;

import java.util.Arrays;

public class Num42747_Hindex {
    public static class Solution {
        public int solution(int[] citations) {
            int max = 0;
            Arrays.sort(citations);

            for (int i = 0; i < citations.length; i++) {
                int h = citations.length - i;

                if (citations[i] >= h) {
                    max = h;
                    break;
                }
            }

            return max;
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(s.solution(new int[]{5, 1, 5, 5, 5, 5}));
    }
}
