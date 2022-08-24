// 2021 카카오 채용연계형 인턴십 - 거리두기 확인하기
// https://school.programmers.co.kr/learn/courses/30/lessons/81302

package PROGRAMMERS.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Num81302_거리두기확인하기 {
    private static class Solution {
        static int[] dr = {0, 1, 0, -1};
        static int[] dc = {-1, 0, 1, 0};

        private static class Point {
            int r;
            int c;

            public Point(int r, int c) {
                this.r = r;
                this.c = c;
            }
        }

        private int[] solution(String[][] places) {
            int[] result = new int[places.length];

            for (int i = 0; i < places.length; i++) {
                result[i] = isCorrext(places[i]);
            }

            return result;
        }

        private static boolean bfs(String[] board, int r, int c) {
            Queue<Point> queue = new LinkedList<>();
            boolean[][] visited = new boolean[board.length][board.length];
            queue.offer(new Point(r, c));
            visited[r][c] = true;

            while (!queue.isEmpty()) {
                Point cur = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];

                    // r, c는 while문 밖에서 선언한 처음 P의 위치임
                    int distance = Math.abs(r - nr) + Math.abs(c - nc);

                    if (nr < 0 || nc < 0 || nr >= board.length || nc >= board.length) {
                        continue;
                    }
                    if (visited[nr][nc] || distance > 2) {
                        continue;
                    }

                    visited[nr][nc] = true;

                    if (board[nr].charAt(nc) == 'X') { // 칸막이라면
                        continue;
                    } else if (board[nr].charAt(nc) == 'P') { // 사람이라면 거리두기 x 이므로 false 반환
                        return false;
                    } else { // 빈 칸이라면 이동 가능
                        queue.offer(new Point(nr, nc));
                    }
                }
            }

            return true;
        }

        private static int isCorrext(String[] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length(); j++) {
                    if (board[i].charAt(j) == 'P') { // P를 찾아서 bfs 실행
                        if (!bfs(board, i, j)) {
                            return 0;
                        }
                    }
                }
            }

            return 1;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(Arrays.toString(sol.solution(new String[][]{
                    {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                    {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                    {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                    {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                    {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
        }
    }
}
