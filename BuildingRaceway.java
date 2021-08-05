// 2020 카카오 인턴십 - 경주로 건설
// https://programmers.co.kr/learn/courses/30/lessons/67259

import java.util.LinkedList;
import java.util.Queue;

public class BuildingRaceway {
    static class Point {
        int x;
        int y;
        int dir;
        int cost;

        Point(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

    private static class Solution {
        public static int[] dx = {-1, 0, 1, 0};
        public static int[] dy = {0, -1, 0, 1};
        public static int N;
        public static int[][] visited;
        public static int min = Integer.MAX_VALUE;

        private int solution(int[][] board) {
            N = board.length;
            visited = new int[N][N];

            bfs(board);

            return min;
        }

        public static void bfs(int[][] board) {
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(0, 0, -1, 0));
            visited[0][0] = 1;

            while(!queue.isEmpty()) {
                int cx = queue.peek().x;
                int cy = queue.peek().y;
                int cd = queue.peek().dir;
                int cost = queue.poll().cost;

                // 도착점에 도달한 경우
                if(cx ==  N-1 && cy == N-1) {
                    min = Math.min(min, cost);
                    continue;
                }

                // 상 하 좌 우 새로운 포인트 검사
                for(int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    int nd = i;

                    // 범위 넘어가거나, 벽인 경우 pass
                    if(nx < 0 || ny < 0|| nx >= N || ny >= N || board[nx][ny] == 1)
                         continue;

                    // 새로운 비용 구하기
                    int newCost = cost;
                    if(cd == -1 || cd == nd) // 처음 시작이거나 방향 같은 경우 -> 직선
                        newCost += 100;
                    else
                        newCost += 600; // 직선 + 코너


                    if(visited[nx][ny] == 0) { // 방문하지 않은 경우
                        visited[nx][ny] = newCost;
                        queue.add(new Point(nx, ny, nd, newCost));
                    } else if(visited[nx][ny] >= newCost) {
                        // 이미 방문한 경우, 비용이 더 작은 값으로 갱신
                        visited[nx][ny] = newCost;
                        queue.add(new Point(nx, ny, nd, newCost));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] board = { { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0 } };
//        int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
//        int[][] board = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        System.out.println(s.solution(board));
    }
}
