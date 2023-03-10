// 코딩테스트 연습 - 스택/큐 - 다리를 지나는 트럭
// https://programmers.co.kr/learn/courses/30/lessons/42583

package PROGRAMMERS.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Num42583_다리를지나는트럭 {
    private static class Solution {
        private int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> bridge = new LinkedList<>();
            int weightSum = 0; // 현재 다리 위 트럭의 무게의 합
            int time = 0; // 전체 시간

            for (int truckWeight : truck_weights) {
                while (true) {
                    if (bridge.isEmpty()) { // 다리 위에 트럭이 한 대도 없는 경우
                        bridge.offer(truckWeight); // 다리에 트럭 진입
                        weightSum += truckWeight; // 방금 올라간 트럭만큼의 무게 추가
                        time++; // 시간++

                        break;
                    } else if (bridge.size() >= bridge_length) { // 다리의 길이보다 더 많은 트럭이 올라갈 수 없음.
                        weightSum -= bridge.poll(); // 다리가 꽉 차면 다리에서 트럭 한 대 빼고, 무게도 빼줌
                    } else { // 다리에 트럭이 올라갈 공간은 있는 경우(꽉 차진 않은 경우)
                        // 현재 다리 위 트럭들의 무게와 다음에 올라갈 트럭의 무게의 합이
                        // 최대 하중을 넘지 않는 경우
                        if (weightSum + truckWeight <= weight) {
                            bridge.offer(truckWeight); // 다리에 올림
                            weightSum += truckWeight; // 무게도 증가
                            time++; // 시간++

                            break;
                        } else { // 총 무게 때문에 다리 올리가지 못할 경우
                            bridge.offer(0); // 0을 다리 위에 올려줌으로써 한 칸을 차지하게 만듦
                            time++; // 시간++
                        }
                    }
                }
            }

            // 마지막 트럭이 다리에 올라가면 for문이 끝나므로, 마지막 트럭이 다리를 빠져나가는 시간을 + 해줌
            int answer = time + bridge_length;
            return answer;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(2, 10, new int[]{7, 4, 5, 6}));
            System.out.println(sol.solution(100, 100, new int[]{10}));
            System.out.println(sol.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
        }
    }
}
