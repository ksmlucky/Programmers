// 코딩테스트 연습 - 해시 - 위장
// https://programmers.co.kr/learn/courses/30/lessons/42578

package PROGRAMMERS.level2;

import java.util.HashMap;

public class Num42578_위장 {
    private static class Solution{
        private int solution(String[][] clothes) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < clothes.length; i++) {
                hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1], 0) + 1);
            }

            int answer = 1;
            for (int num : hashMap.values()) {
                answer *= ++num;
            }
            answer--;

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(sol.solution(new String[][] {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
}
