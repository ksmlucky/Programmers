// 코딩테스트 연습 - 2017 카카오코드 예선 - 카카오프렌즈 컬러링북
// https://programmers.co.kr/learn/courses/30/lessons/1829

package PROGRAMMERS.level2;

public class Num1829_카카오프렌즈컬러링북2 {
    private static class Solution {
        static int count;
        static int max;
        static int areaCount;
        static int[][] pictureCopied;
        static boolean[][] visited;
        static int[] dr;
        static int[] dc;
        static int N, M;

        private int[] solution(int m, int n, int[][] picture) {
            count = 0;
            max = Integer.MIN_VALUE;
            areaCount = 0;
            pictureCopied = picture;
            N = n;
            M = m;
            visited = new boolean[M][N];
            dr = new int[]{0, 1, 0, -1};
            dc = new int[]{1, 0, -1, 0};

//            for (int q = 0; q < picture.length; q++) {
//                System.out.println(Arrays.toString(pictureCopied[q]));
//            }
//            System.out.println();
            int[] answer = new int[2];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (picture[i][j] != 0 && !visited[i][j]) {
                        dfs(i, j, picture[i][j]);
                        max = Math.max(max, count);
                        count = 0;
                        areaCount++;
                    }
                }
            }

            answer[0] = areaCount;
            answer[1] = max;

            return answer;
        }

        private void dfs(int r, int c, int temp) {
            if (visited[r][c]) {
                return;
            }
            count++;
            visited[r][c] = true;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= M || nc < 0 || nc >= N) {
                    continue;
                }

                if (pictureCopied[nr][nc] == temp) {
                    dfs(nr, nc, pictureCopied[nr][nc]);
                }
            }
        }
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        int m = 6, n = 4;
        int[][] picture = {{1,1,1,0}, {1,2,2,0}, {1,0,0,1}, {0,0,0,1}, {0,0,0,3}, {0,0,0,3}};

        System.out.println(s.solution(m,n,picture)[0] + " " + s.solution(m,n,picture)[1]);
    }
}