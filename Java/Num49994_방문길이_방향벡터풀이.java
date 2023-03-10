// 코딩테스트 연습 - Summer/Winter Coding(~2018) - 방문 길이
// https://school.programmers.co.kr/learn/courses/30/lessons/49994

package PROGRAMMERS.level2;


public class Num49994_방문길이_방향벡터풀이 {
    private static class Solution {
        // 반시계 방향
        static int dr[] = {-1, 0, 1, 0};
        static int dc[] = {0, -1, 0, 1};

        private int solution(String dirs) {
            int answer = 0;

            boolean[][][] visited = new boolean[11][11][4]; // [11][11][4방향]

            int r = 5, c = 5; // 중앙에서 시작

            for (int i = 0; i < dirs.length(); i++) {
                char temp = dirs.charAt(i);
                int d = 0; // 방향

                if (temp == 'U') {
                    d = 0;
                } else if (temp == 'L') {
                    d = 1;
                } else if (temp == 'D') {
                    d = 2;
                } else if (temp == 'R') {
                    d = 3;
                }

                int nr = r + dr[d];
                int nc = c + dc[d];

                // 범위 밖으로 나가면 continue
                if (nr < 0 || nr >= 11 || nc < 0 || nc >= 11) {
                    continue;
                }

                // 가려고 하는 길이 가보지 않은 길이라면
                if (!visited[nr][nc][d]) {
                    visited[nr][nc][d] = true; // 방문 체크
                    d = (d + 2) % 4; // 방향을 정반대로 바꿔줌
//                    d = (d % 2 == 0) ? 2 - d : 4 - d;
                    visited[r][c][d] = true; // 방문 체크
                    answer++;
                }

                // 현재 위치 이동
                r = nr;
                c = nc;
            }

            return answer;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution("ULURRDLLU"));
            System.out.println(sol.solution("LULLLLLLU"));
            System.out.println(sol.solution("UDU"));
        }
    }
}
