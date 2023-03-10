// 코딩테스트 연습 - 연습문제 - 정수 내림차순으로 배치하기
// https://programmers.co.kr/learn/courses/30/lessons/12933

package PROGRAMMERS.level1;

import java.util.Arrays;
// import java.util.Collections;

public class Num12933_정수내림차순으로배치하기 {
    private static class Solution {
        private long solution(long n) {
            String nStr = String.valueOf(n);
            int nLength = nStr.length();

            int[] arr = new int[nLength];

            for (int i = 0; i < nLength; i++) {
                arr[i] = nStr.charAt(i) - '0';
            }

            // Arrays.sort(arr, Collections.reverseOrder());
            Arrays.sort(arr);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < nLength; i++) {
                sb.append(arr[(nLength - 1) - i]);
            }

            return Long.parseLong(sb.toString());


//            String s = Long.toString(n);
//            String[] arr = s.split("");
//            long answer;
//            Arrays.sort(arr, Collections.reverseOrder());
//            String tmp = String.join("",arr);
//            answer = Long.parseLong(tmp);
//            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(118372));
    }
}
