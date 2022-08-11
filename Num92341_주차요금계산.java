// 코딩테스트 연습 - 2022 KAKAO BLIND RECRUITMENT - 주차 요금 계산
// https://school.programmers.co.kr/learn/courses/30/lessons/92341

package PROGRAMMERS.level2;

import java.util.*;

public class Num92341_주차요금계산 {
    private static class Solution {
        private int[] solution(int[] fees, String[] records) {
            int lastTime = getTime("23:59");

            // 지금 주차장에 있는 차들
            Map<String, Integer> parking = new HashMap<>();
            // 요금 계산할 차들
            Map<String, Integer> times = new HashMap<>();
            // 차들(후에 오름차순 정렬할 때 사용)
            List<String> cars = new ArrayList<>();

            for (String record : records) {
                String[] rc = record.split(" ");
                int time = getTime(rc[0]);
                String car = rc[1];

                // 새로운차 등장
                if (!cars.contains(car)) {
                    cars.add(car);
                    times.put(car, 0);
                }

                if (parking.containsKey(car)) {
                    // 현재 파킹이 되어 있다면 출차
                    times.put(car, times.get(car) + (time - parking.get(car)));
                    parking.remove(car);
                } else {
                    // 파킹이 안되어 있다면 입차
                    parking.put(car, time);
                }

            }

            int[] ret = new int[cars.size()];
            // 차번 순으로 정렬
            Collections.sort(cars);

            for (int i = 0; i < cars.size(); i++) {
                // 기본요금
                ret[i] = fees[1];
                String car = cars.get(i);
                // 누적시간중 기본요금 시간 제외
                int time = times.get(car) - fees[0];
                // 아직 출차가 안되었다면 마지막시간으로 정산
                if (parking.containsKey(car)) time += (lastTime - parking.get(car));
                // 요금 정산
                if (time > 0) ret[i] += (Math.ceil(time / (fees[2] * 1.0)) * fees[3]);
            }

            return ret;
        }

        private static int getTime(String time) {
            String[] temp = time.split(":");
            return Integer.valueOf(temp[0]) * 60 + Integer.valueOf(temp[1]);
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
            System.out.println(sol.solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"}));
        }
    }
}
