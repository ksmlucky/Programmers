// 코딩테스트 연습 - 2022 KAKAO BLIND RECRUITMENT - 주차 요금 계산
// https://school.programmers.co.kr/learn/courses/30/lessons/92341

package PROGRAMMERS.level2;

import java.util.Arrays;
import java.util.HashMap;

public class Num92341_주차요금계산_런타임에러 {
    private static class Solution {
        private int[] solution(int[] fees, String[] records) {
            int standardTime = fees[0];
            int standardFee = fees[1];
            int unitTime = fees[2];
            int unitFee = fees[3];

//            HashMap<String, String[]> hashMap = new HashMap<>();
            HashMap<String, String> hashMap = new HashMap<>();
            HashMap<String, Integer> feeMap = new HashMap<>();

            for (String str : records) {
                String[] strArr = str.split(" ");
                String time = strArr[0];
                String carNumber = strArr[1];

                int tempTime = 0;

                if (hashMap.isEmpty() || !hashMap.containsKey(carNumber)) {
                    hashMap.put(carNumber, time);
                } else {
                    tempTime = calculateTime(hashMap.remove(carNumber), time);
                    if (feeMap.containsKey(carNumber)) {
                        feeMap.put(carNumber, feeMap.remove(carNumber) + tempTime);
                    } else {
                        feeMap.put(carNumber, tempTime);
                    }
                }
            }

            for (String carNumber : hashMap.keySet()) {
                int tempTime = 0;
                tempTime = calculateTime(hashMap.remove(carNumber), "23:59");
                if (feeMap.containsKey(carNumber)) {
                    feeMap.put(carNumber, feeMap.remove(carNumber) + tempTime);
                } else {
                    feeMap.put(carNumber, tempTime);
                }
            }

            String[] sortStrArr = feeMap.keySet().toArray(new String[0]);
            Arrays.sort(sortStrArr);

            // 얘도 정렬 가능
//            Object[] sortObjectArr = feeMap.keySet().toArray();
//            Arrays.sort(sortObjectArr);

            int[] answer = new int[feeMap.size()];

            int count = 0;
            for (String carNumber : sortStrArr) {
                answer[count++] = caculateFee(feeMap.get(carNumber), standardTime, standardFee, unitTime, unitFee);
            }

            return answer;
        }

        private static int calculateTime(String startTime, String endTime) {
            String[] tempStartTime = startTime.split(":");
            String[] tempEndTime = endTime.split(":");
            int startHour = Integer.parseInt(tempStartTime[0]);
            int startMin = Integer.parseInt(tempStartTime[1]);
            int endHour = Integer.parseInt(tempEndTime[0]);
            int endMin = Integer.parseInt(tempEndTime[1]);

            int totalTime = (endHour - startHour) * 60 + (endMin - startMin);

            return totalTime;
        }

        private static int caculateFee(int totalTime, int standardTime, int standardFee, int unitTime, int unitFee) {
            int totalFee = 0;

            if (totalTime > standardTime) {
                totalFee = standardFee + ((int)Math.ceil((double)(totalTime - standardTime) / unitTime)) * unitFee;
            } else {
                totalFee = standardFee;
            }

            return totalFee;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(Arrays.toString(sol.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
            System.out.println(Arrays.toString(sol.solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"})));
            System.out.println(Arrays.toString(sol.solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"})));
        }
    }
}
