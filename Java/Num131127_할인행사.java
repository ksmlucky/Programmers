// 코딩테스트 연습 - 연습문제 - 할인 행사
// https://school.programmers.co.kr/learn/courses/30/lessons/131127

package PROGRAMMERS.level2;

import java.util.HashMap;

public class Num131127_할인행사 {
    private static class Solution {
        private int solution(String[] want, int[] number, String[] discount) {
            HashMap<String, Integer> hashMap = new HashMap<>(); // 원하는 제품과 수량을 저장할 map
            HashMap<String, Integer> copiedMap; // 로직을 한번 실행한 후 다시 hashMap으로 초기화해서 사용할 map

            // hashMap에 값 초기화
            for (int i = 0 ; i< want.length ; i++) {
                String key = want[i];
                int value = number[i];
                hashMap.put(key, value);
            }

            // copiedMap에 hashMap을 복사해주기
            copiedMap = (HashMap)hashMap.clone();

            int sum = 0; // 원하는 제품들의 수량의 합
            for (int temp : number) {
                sum += temp;
            }

            int answer = 0; // 가능한 날의 수(정답)

            for (int i = 0; i <= discount.length - sum; i++) { // 필요한 만큼만 반복하기 위함
                for (int j = i; j < i + sum; j++) { // 현재 위치에서 +sum까지만 비교
                    String temp = discount[j];
                    if (!copiedMap.containsKey(temp)) { // 해당하는 키가 없으면
                        copiedMap = (HashMap) hashMap.clone();
                        break;
                    } else if (copiedMap.containsKey(temp) && copiedMap.get(temp) == 0) { // 해당 키가 있지만 값이 0이면
                        copiedMap = (HashMap) hashMap.clone();
                        break;
                    } else { // 해당 키가 있고 값이 0이 아니면
                        copiedMap.put(temp, copiedMap.get(temp) - 1); // 하나를 빼줌
                    }
                    if (j == i + sum - 1) { // 현재 반복문의 마지막 인덱스면
                        answer++;
                        copiedMap = (HashMap) hashMap.clone();
                    }
                }
            }

            return answer;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
            System.out.println(sol.solution(new String[]{"apple"}, new int[]{10}, new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));
        }
    }
}
