// 코딩테스트 연습 - 스택/큐 - 프린터
// https://programmers.co.kr/learn/courses/30/lessons/42587

import java.util.Collections;
import java.util.PriorityQueue;

public class Printer {
    private static class Solution {
        private int solution(int[] priorities, int location) {
            int answer = 0;

            PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < priorities.length; i++) {
                pQueue.add(priorities[i]);
            }

            while (!pQueue.isEmpty()) {
                for (int i = 0; i < priorities.length; i++) {
                    if (priorities[i] == pQueue.peek()) {
                        if (i == location) {
                            answer++;
                            return answer;
                        }
                        pQueue.poll();
                        answer++;
                    }
                }
            }

            return -1;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();

            System.out.println(solution.solution(new int[]{2, 1, 3, 2}, 2));
            System.out.println(solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
        }
    }
}
