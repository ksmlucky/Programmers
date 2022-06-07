// 코딩테스트 연습 - 힙 - 더 맵게
// https://programmers.co.kr/learn/courses/30/lessons/42626

package PROGRAMMERS.level2;

import java.util.PriorityQueue;

public class Num42626_더맵게 {
    private static class Solution{
        private int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < scoville.length; i++) {
                pq.add(scoville[i]);
            }
            while (pq.peek() < K) {
                if (pq.size() == 1) {
                    return -1;
                }
                int newScoville1 = pq.poll();
                int newScoville2 = pq.poll();

                pq.add(newScoville1 + (newScoville2) * 2);
                answer++;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
        System.out.println(sol.solution(new int[]{2}, 7));
    }
}
