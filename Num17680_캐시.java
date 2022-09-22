// 코딩테스트 연습 - 2018 KAKAO BLIND RECRUITMENT - [1차] 캐시
// https://school.programmers.co.kr/learn/courses/30/lessons/17680

package PROGRAMMERS.level2;

import java.util.ArrayList;

public class Num17680_캐시 {
    private static class Solution {
        private int solution(int cacheSize, String[] cities) {
            ArrayList<String> arrayList = new ArrayList<>();
            int time = 0;
            final int cacheHit = 1;
            final int cacheMiss = 5;

            for (String str : cities) {
                str = str.toLowerCase();
                if (arrayList.size() < cacheSize) { // 캐시에 공간 있으면서
                    if (arrayList.contains(str)) { // 캐시에 해당 단어가 있으면
                        arrayList.remove(arrayList.indexOf(str)); // 원래 위치에 있던거 없애고
                        arrayList.add(arrayList.size(), str); // 제일 최근 자리로 다시 넣어줌
                        time += cacheHit;
                    } else { // 캐시에 해당 단어가 없으면
                        arrayList.add(arrayList.size(), str); // 캐시(가장 뒤에)에 단어 추가
                        time += cacheMiss;
                    }
                } else { // 캐시에 공간 없으면서
                    if (arrayList.contains(str)) { // 캐시에 해당 단어가 있으면
                        arrayList.remove(arrayList.indexOf(str)); // 원래 위치에 있던거 없애고
                        arrayList.add(arrayList.size(), str); // 제일 최근 자리로 다시 넣어줌
                        time += cacheHit;
                    } else { // 캐시에 해당 단어가 없으면
                        if (arrayList.size() > 0) { // 캐시 크기가 0보다 크면(0이 아니면)
                            arrayList.remove(0); // 가장 먼저 캐시에 들어간 단어 빼주고
                            arrayList.add(arrayList.size(), str); // 캐시에 단어 추가
                        }
                        time += cacheMiss;
                    }
                }
            }

            return time;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
            System.out.println(sol.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
            System.out.println(sol.solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
            System.out.println(sol.solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
            System.out.println(sol.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
            System.out.println(sol.solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        }
    }
}
