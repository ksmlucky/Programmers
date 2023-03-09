// 코딩테스트 연습 - 찾아라 프로그래밍 마에스터 - 게임 맵 최단거리
// https://programmers.co.kr/learn/courses/30/lessons/1844

package PROGRAMMERS;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDistance {
    private static class Solution {
        static int[] dx = {1, 0, -1, 0};
        static int[] dy = {0, 1, 0, -1};

        private int solution(int[][] maps) {
            int answer = 0;

            int[][] visited = new int[maps.length][maps[0].length];

            bfs(maps, visited);
            answer = visited[maps.length-1][maps[0].length-1];

            if(answer == 0){
                answer = -1;
            }

            return answer;
        }

        public void bfs(int[][] maps, int[][] visited){
            int x = 0;
            int y = 0;
            visited[x][y] = 1;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{x, y});

            while(!queue.isEmpty()){
                int[] arr = queue.poll();
                int X = arr[0];
                int Y = arr[1];

                for(int i = 0; i < 4; i++){
                    int nX = X + dx[i];
                    int nY = Y + dy[i];

                    if (nX < 0 || nX > maps.length - 1 || nY < 0 || nY > maps[0].length - 1) {
                        continue;
                    }

                    if(visited[nX][nY] == 0 && maps[nX][nY] == 1){
                        visited[nX][nY] = visited[X][Y] + 1;
                        queue.add(new int[]{nX, nY});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(sol.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }
}
