// 코딩테스트 연습 - 연습문제 - N개의 최소공배수
// https://school.programmers.co.kr/learn/courses/30/lessons/12953

package PROGRAMMERS.level2;

import java.util.Arrays;

public class Num12953_N개의최소공배수 {
    private static class Solution {
        private int solution(int[] arr) {
            Arrays.sort(arr); // 정렬

            // 제일 마지막 원소가 제일 크기 때문에 걔를 기준으로 비교할 예정
            int standard = arr[arr.length - 1];

            while (true) {
                // 아까 뽑은거 14면 처음엔 14로  다 비교하고 그담엔 28, 42
                standard += arr[arr.length - 1];

                // 제일 처음 맞는애가 최소니까 바로 check()가 true를 반환하면
                // 바로 standard를 리턴
                if (check(standard, arr)) {
                    return standard;
                }
            }
        }

        // 배열의 원소를 돌면서 공배수가 맞는지 확인
        private static boolean check(int standard, int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (standard % arr[i] != 0) {
                    return false; // 아니면 중간에 false 반환
                }
            }
            return true; // 맞으면(for문을 끝까지 돌면) true
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[]{2, 6, 8, 14}));
        System.out.println(sol.solution(new int[]{1, 2, 3}));
    }
}
