// 코딩테스트 연습 - 2018 KAKAO BLIND RECRUITMENT - [1차] 뉴스 클러스터링
// https://programmers.co.kr/learn/courses/30/lessons/17677

package PROGRAMMERS.level2;

import java.util.ArrayList;

public class Num17677_뉴스클러스터링2 {
    private static class Solution {
        private int solution(String str1, String str2) {
            ArrayList<String> strArr1 = new ArrayList<>();
            ArrayList<String> strArr2 = new ArrayList<>();

            for (int i = 0; i < str1.length() - 1; i++) {
                String temp = str1.substring(i, i + 2).toLowerCase();

                if (temp.charAt(0) >= 'a' && temp.charAt(0) <= 'z' && temp.charAt(1) >= 'a' && temp.charAt(1) <= 'z') {
                    strArr1.add(temp);
                }
            }
            for (int i = 0; i < str2.length() - 1; i++) {
                String temp = str2.substring(i, i + 2).toLowerCase();

                if (temp.charAt(0) >= 'a' && temp.charAt(0) <= 'z' && temp.charAt(1) >= 'a' && temp.charAt(1) <= 'z') {
                    strArr2.add(temp);
                }
            }

            ArrayList<String> bigArrayList = new ArrayList<>(); // 합집합
            ArrayList<String> smallArrayList = new ArrayList<>(); // 교집합

            // 교집합 만들기
            for (String temp : strArr1) {
                if (strArr2.remove(temp)) { // temp가 strArr1에 있고 strArr2에도 있으면 strArr2에서 삭제하고
                    smallArrayList.add(temp); // 교집합에 추가
                }
                bigArrayList.add(temp); // 합집합에는 일단 strArr1에 있는거 다 추가
            }

            // 합집합에 나머지 추가해주기
            for (String temp : strArr2) { // 이제 strArr2에는 공통되지 않은 애들만 남았음
                bigArrayList.add(temp); // 합집합에 추가
            }

            int bigSetSize = bigArrayList.size();
            int smallSetSize = smallArrayList.size();

            double answer = 0;

            if (bigSetSize == 0) {
                answer = 65536;
            } else {
                answer = (double) smallSetSize / bigSetSize * 65536;
            }

            return (int)answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("FRANCE", "french"));
        System.out.println(sol.solution("handshake", "shake hands"));
        System.out.println(sol.solution("aa1+aa2", "AAAA12"));
        System.out.println(sol.solution("E=M*C^2", "e=m*c^2"));
    }
}
