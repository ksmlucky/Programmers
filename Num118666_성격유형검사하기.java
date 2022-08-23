// 코딩테스트 연습 - 2022 KAKAO TECH INTERNSHIP - 성격 유형 검사하기
// https://school.programmers.co.kr/learn/courses/30/lessons/118666

package PROGRAMMERS.level1;

import java.util.ArrayList;

public class Num118666_성격유형검사하기 {
    // 1. R, T
    // 2. C, F
    // 3. J, M
    // 4. A, N

    private static class Solution {
        private String solution(String[] survey, int[] choices) {
            ArrayList<Character> charArrayList = new ArrayList<Character>();
            charArrayList.add('R');
            charArrayList.add('T');
            charArrayList.add('C');
            charArrayList.add('F');
            charArrayList.add('J');
            charArrayList.add('M');
            charArrayList.add('A');
            charArrayList.add('N');
            int[] score = new int[8]; // 성격 유형 당 점수를 저장할 배열

            for (int i = 0; i < survey.length; i++) {
                String temp = survey[i];
                int option = choices[i];

                // 해당 성격 유형에 점수 + 해주기
                // 1이면 [0] += 3, 2이면 [0] += 2, 3이면 [0] += 1,
                // 4이면 넘어가고,
                // 5이면 [1] += 1, 6이면 [1] += 2, 7이면 [1] += 3
                switch (option) {
                    case 1:
                        score[charArrayList.indexOf(temp.charAt(0))] += 3;
                        break;
                    case 2:
                        score[charArrayList.indexOf(temp.charAt(0))] += 2;
                        break;
                    case 3:
                        score[charArrayList.indexOf(temp.charAt(0))] += 1;
                    case 4:
                        break;
                    case 5:
                        score[charArrayList.indexOf(temp.charAt(1))] += 1;
                        break;
                    case 6:
                        score[charArrayList.indexOf(temp.charAt(1))] += 2;
                        break;
                    case 7:
                        score[charArrayList.indexOf(temp.charAt(1))] += 3;
                        break;
                }
            }

            String answer = "";

            if (score[0] >= score[1]) {
                answer += "R";
            } else {
                answer += "T";
            }

            if (score[2] >= score[3]) {
                answer += "C";
            } else {
                answer += "F";
            }

            if (score[4] >= score[5]) {
                answer += "J";
            } else {
                answer += "M";
            }

            if (score[6] >= score[7]) {
                answer += "A";
            } else {
                answer += "N";
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"},
                new int[]{5, 3, 2, 7, 5}));
        System.out.println(sol.solution(new String[]{"TR", "RT", "TR"},
                new int[]{7, 1, 3}));
    }
}
