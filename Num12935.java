// 코딩테스트 연습 - 연습문제 - 제일 작은 수 제거하기
// https://programmers.co.kr/learn/courses/30/lessons/12935

package PROGRAMMERS.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class Num12935 {
    private static class Solution {
        private int[] solution(int[] arr) {
            if (arr.length == 1) {
                return new int[]{-1};
            } else {
//                int[] arr2 = new int[arr.length];
//                for (int i = 0; i < arr.length; i++) {
//                    arr2[i] = arr[i];
//                }
                int[] arr2 = arr.clone();

                Arrays.sort(arr2);
                int min = arr2[0];

                ArrayList<Integer> arrayList = new ArrayList<>();

                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != min) {
                        arrayList.add(arr[i]);
                    }
                }

                int answer[] = new int[arrayList.size()];
                for (int i = 0; i < answer.length; i++) {
                    answer[i] = arrayList.get(i);
                }

                return answer;
            }
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(new int[]{4, 3, 2, 1}));
            System.out.println(sol.solution(new int[]{10}));
        }
    }
}
