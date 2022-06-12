// 코딩테스트 연습 - 2021 KAKAO BLIND RECRUITMENT - 메뉴 리뉴얼
// https://programmers.co.kr/learn/courses/30/lessons/72411

package PROGRAMMERS.level2;

import java.util.*;

public class Num72411_메뉴리뉴얼 {
    private static class Solution {
        List<String> answerList = new ArrayList<>();
        Map<String, Integer> hashMap = new HashMap<>();

        private String[] solution(String[] orders, int[] course) {
            // 1. 각 order 정렬
            for (int i = 0; i < orders.length; i++) {
                char[] arr = orders[i].toCharArray();
                Arrays.sort(arr);
                orders[i] = String.valueOf(arr);
            }

            // 2. 각 order를 기준으로 courseLength만큼의 조합 만들기
            for (int courseLength : course) {
                for (String order : orders) {
                    combination("", order, courseLength);
                }

                // 3. 가장 많은 조합을 answer에 저장
                if (!hashMap.isEmpty()) {
                    List<Integer> countList = new ArrayList<>(hashMap.values());
                    int max = Collections.max(countList);

                    if (max > 1) {
                        for (String key : hashMap.keySet()) {
                            if (hashMap.get(key) == max) {
                                answerList.add(key);
                            }
                        }
                    }
                    hashMap.clear();
                }
            }

            Collections.sort(answerList);

            String[] answer = new String[answerList.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = answerList.get(i);
            }

            return answer;
        }
        public void combination(String order, String others, int count) {
            // 탈출 조건: count == 0
            if (count == 0) {
                hashMap.put(order, hashMap.getOrDefault(order, 0) + 1);
                return;
            }

            // 수행 동작: 0부터 length까지 조합
            for (int i = 0; i < others.length(); i++) {
                combination(order + others.charAt(i), others.substring(i + 1), count - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4}));
//        System.out.println(sol.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5}));
//        System.out.println(sol.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4}));
    }
}
