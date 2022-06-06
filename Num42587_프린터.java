// 코딩테스트 연습 - 스택/큐 - 프린터
// https://programmers.co.kr/learn/courses/30/lessons/42587

package PROGRAMMERS.level2;

import java.util.Collections;
import java.util.PriorityQueue;

// PriorityQueue 이용 풀이
public class Num42587_프린터 {
    private static class Solution {
        private int solution(int[] priorities, int location) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int answer = 0;

            for (int i = 0; i < priorities.length; i++) {
                pq.add(priorities[i]);
            }

            while (!pq.isEmpty()) {
                for (int i = 0; i < priorities.length; i++) {
                    if (priorities[i] == pq.peek()) {
                        if (i == location) {
                            answer++;
                            return answer;
                        }
                        pq.poll();
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
