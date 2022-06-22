// 코딩테스트 연습 - 2019 카카오 개발자 겨울 인턴십 - 튜플
// https://programmers.co.kr/learn/courses/30/lessons/64065

package PROGRAMMERS.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Num64065_튜플 {
    private static class Solution {
        private int[] solution(String s) {
            s = s.substring(2, s.length() - 2).replace("},{", "-");

            String[] strArray = s.split("-");
            Arrays.sort(strArray, Comparator.comparing(String::length));

            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int i = 0; i < strArray.length; i++) {
                String str = strArray[i];
                String[] temp = str.split(",");
                for (int j = 0; j < temp.length; j++) {
                    int tempInt = Integer.parseInt(temp[j]);
                    if (!arrayList.contains(tempInt)) {
                        arrayList.add(tempInt);
                    }
                }
            }

            int[] answer = new int[arrayList.size()];

            for (int i = 0; i < arrayList.size(); i++) {
                answer[i] = arrayList.get(i);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
//        System.out.println(Arrays.toString(sol.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
//        System.out.println(Arrays.toString(sol.solution("{{20,111},{111}}")));
//        System.out.println(Arrays.toString(sol.solution("{{123}}")));
//        System.out.println(Arrays.toString(sol.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }
}
