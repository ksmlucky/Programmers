package PROGRAMMERS;

import java.util.HashMap;

public class Camouflage {
    private static class Solution{
        private int solution(String[][] clothes) {
            int answer = 1;

            HashMap<String, Integer> hashMap = new HashMap<>();

            // hashMap.getOrDefault() 사용법
            for (int i = 0; i < clothes.length; i++) {
                hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1], 0) + 1);
            }

            // 해쉬맵 반복문 사용법
            for (String key : hashMap.keySet()) {
                answer *= (hashMap.get(key) + 1);
            }

            return answer - 1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(sol.solution(new String[][] {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
}
