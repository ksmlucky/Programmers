// 코딩테스트 연습 - 정렬 - 가장 큰 수
// https://programmers.co.kr/learn/courses/30/lessons/42746

package PROGRAMMERS;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {
    private static class Solution {
        private String solution(int[] numbers) {
            String[] strArr = new String[numbers.length];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = Integer.toString(numbers[i]);
            }

            Arrays.sort(strArr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o2 + o1).compareTo(o1 + o2);
                }
            });

            // 얘는 안됨!
            // if (strArr[0] == "0") {

            if (strArr[0].equals("0")) {
                return "0";
            } else {
                return String.join("", strArr);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[]{6, 10, 2}));
        System.out.println(sol.solution(new int[]{3, 30, 34, 5, 9}));
    }
}
