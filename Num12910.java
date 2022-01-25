// 코딩테스트 연습 - 연습문제 - 나누어 떻어지는 숫자 배열
// https://programmers.co.kr/learn/courses/30/lessons/12910

package PROGRAMMERS.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num12910 {
    private static class Solution {
        private int[] solution(int[] arr, int divisor) {
            int count = 0;
            List<Integer> al = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % divisor == 0) {
                    al.add(arr[i]);
                }
            }
            int[] newArr = new int[al.size()];
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = al.get(i);
            }
            Arrays.sort(newArr);

            if (newArr.length == 0) {
                return new int[]{-1};
            } else {
                return newArr;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{5, 9, 7, 10}, 5));
        System.out.println(sol.solution(new int[]{2, 36, 1, 3}, 1));
        System.out.println(sol.solution(new int[]{3, 2, 6}, 10));
    }
}
