// 코딩테스트 연습 - 힙 - 더 맵게
// https://programmers.co.kr/learn/courses/30/lessons/42626

import java.util.Arrays;
import java.util.PriorityQueue;

public class Spicier {
    private static class Solution{
        private int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> queue = new PriorityQueue();

            for (int i = 0; i < scoville.length; i++) {
                queue.offer(scoville[i]);
            }

            // 가장 작은 스코빌값이 K보다 크면 끝
            while (queue.peek() < K) {

                // 큐의 사이즈가 1이면 음식을 다 섞었는데도 스코빌 값이 K를 만들지 못한 것임
                if (queue.size() == 1) {
                    return -1;
                }

                int min1 = queue.poll(), min2 = queue.poll();

                queue.offer(min1 + (2 * min2));

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
