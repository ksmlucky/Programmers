// 코딩테스트 연습 - 완전탐색 - 전력망을 둘로 나누기
// https://school.programmers.co.kr/learn/courses/30/lessons/86971

package PROGRAMMERS.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Num86971_전력망을둘로나누기 {
    private static class Solution {
        static ArrayList<Integer>[] arrayLists; // 전력망을 나타낼 어레이리스트 배열
        static int min; // 두 전력망이 가지고 있는 송전탑 개수의 차이 최소값(정답)

        private int solution(int n, int[][] wires) {
            min = Integer.MAX_VALUE;
            arrayLists = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                arrayLists[i] = new ArrayList<>(); // 어레이리스트 선언
            }

            for (int[] arr : wires) {
                int start = arr[0] - 1; // 인덱스-1 이 실제 위치
                int end = arr[1] - 1;

                arrayLists[start].add(end); // 연결 관계 표시
                arrayLists[end].add(start);
            }

            for (int[] arr : wires) {
                int start = arr[0] - 1; // 하나씩 빼서
                int end = arr[1] - 1;

                // bfs로 연결되어 있는 송전탑 개수의 차이 구하고 min 갱신하기
                min = Math.min(min, Math.abs(bfs(start, end) - bfs(end, start)));
            }

            return min;
        }

        private static int bfs(int start, int end) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[arrayLists.length];

            int linkedNodeCount = 0; // 연결된 송전탑의 개수

            queue.offer(start); // 처음꺼 하나 넣고 시작
            visited[start] = true; // 방문체크

            // bfs 알고리즘
            while (!queue.isEmpty()) {
                int current = queue.poll();
                linkedNodeCount++;

                for (int node : arrayLists[current]) {
                    // start가 포함된 전력망과 end가 포함된 전력망은 연결되어 있지 않으므로 다음 node가 end면 안됨
                    // 다음 노드가 방문했던 노드면 안됨
                    if (node != end && !visited[node]) {
                        queue.add(node);
                        visited[node] = true;
                    }
                }
            }

            return linkedNodeCount;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
            System.out.println(sol.solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
            System.out.println(sol.solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
        }
    }
}
