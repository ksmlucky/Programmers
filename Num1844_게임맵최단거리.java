// 코딩테스트 연습 - 깊이/너비 우선 탐색(DFS/BFS) - 게임 맵 최단거리
// https://school.programmers.co.kr/learn/courses/30/lessons/1844

package PROGRAMMERS.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Num1844_게임맵최단거리 {
    private static class Solution {
        static class Node {
            int r;
            int c;
            int count; // 지금까지 몇개의 칸을 지났는지 count

            public Node(int r, int c, int count) {
                this.r = r;
                this.c = c;
                this.count = count;
            }
        }

        static Queue<Node> queue;
        static int[] dr;
        static int[] dc;
        static boolean[][] visited; // 방문 체크

        private int solution(int[][] maps) {
            dr = new int[]{0, 1, 0, -1};
            dc = new int[]{1, 0, -1, 0};
            visited = new boolean[maps.length][maps[0].length];
            queue = new LinkedList<>();
            queue.offer(new Node(0, 0, 1)); // 시작하는 칸 큐에 넣어줌
            visited[0][0] = true; // 시작하는 칸 방문 체크

            return bfs(0, 0, maps);
        }

        private static int bfs(int r, int c, int[][] maps) {
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int curR = node.r;
                int curC = node.c;
                int curCount = node.count;

                // 큐에서 뺀 위치가 도착지면
                if (curR == maps.length - 1 && curC == maps[0].length - 1) {
                    return curCount; // count 반환(BFS니까 가장 빨리 나오는게 가장 빨리 도착한 거임 !)
                }

                for (int d = 0; d < 4; d++) {
                    int nr = curR + dr[d];
                    int nc = curC + dc[d];

                    // 범위 밖이면 건너 뛰기
                    if (nr < 0 || nr >= maps.length || nc < 0 || nc >= maps[0].length) {
                        continue;
                    }

                    // 다음 칸이 이동 가능한 칸이고, 아직 방문하지 않은 칸이면
                    if (maps[nr][nc] == 1 && !visited[nr][nc]) {
                        visited[nr][nc] = true; // 방문 체크 먼저 하고
                        queue.offer(new Node(nr, nc, curCount + 1)); // 큐에 삽입
                    }
                }
            }

            return -1; // 도달할 수 없으면 -1 반환
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
            System.out.println(sol.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
        }
    }
}
