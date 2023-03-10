// 코딩테스트 연습 - 정렬 - 가장 큰 수
// https://programmers.co.kr/learn/courses/30/lessons/42746

package PROGRAMMERS.level2;

import java.util.Arrays;
import java.util.Comparator;

public class Num42746_가장큰수 {
    private static class Solution {
        private String solution(int[] numbers) {
            String[] strArr = new String[numbers.length];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = Integer.toString(numbers[i]);
            }

            // 문자열 o1, o2를 연결해서 더 큰게 앞으로 오게 정렬
            Arrays.sort(strArr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o2 + o1).compareTo(o1 + o2);
                }
            });



            // 얘는 안됨!
            // if (strArr[0] == "0") {
            // 정렬했는데 0이 맨 첨에 있는거면 0이 제일 크다는 거 -> 그니까 걍 0 반환
            if (strArr[0].equals("0")) {
                return "0";
            } else {
                return String.join("", strArr);
            }


//            String answer = "";
//            // int -> String 배열로
//            ArrayList<String> strNumbers = new ArrayList();
//            for(Integer num : numbers){
//                strNumbers.add(String.valueOf(num));
//            }
//            // 내림차순 정렬
//            Collections.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));
//            // numbers가 [0,0,0] 등으로 주어지는 경우는 "000"이 아닌 "0" 리턴
//            if(strNumbers.get(0).startsWith("0")) return "0";
//            // answer에 정렬된 것을 담기
//            for(String s : strNumbers){
//                answer += s;
//            }
//            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[]{6, 10, 2}));
        System.out.println(sol.solution(new int[]{3, 30, 34, 5, 9}));
    }
}
