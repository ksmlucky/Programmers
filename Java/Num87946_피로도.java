// 코딩테스트 연습 - 위클리 챌린지 - 피로도
// https://programmers.co.kr/learn/courses/30/lessons/87946

package PROGRAMMERS.level2;

public class Num87946_피로도 {
    private static class Solution{
        static int answer;
        static boolean[] visited;

        private int solution(int k, int[][] dungeons) {
            answer = 0;
            visited = new boolean[dungeons.length];

            dfs(k, dungeons, 0);

            return answer;
        }

        private void dfs(int k, int[][] dungeons, int depth) {
            for (int i = 0; i < dungeons.length; i++) {
                // 탐험하지 않은 던전이고, 최소 피로도보다 많은 피로도가 남아 있으면
                if (!visited[i] && k >= dungeons[i][0]) {
                    visited[i] = true; // 탐험했다고 방문 표시
                    dfs(k - dungeons[i][1], dungeons, depth + 1); // 현재 피로도 감소시킴
                    visited[i] = false; // 탐험 후엔 방문 표시 해제
                }
            }

            answer = Math.max(answer, depth); // 최대값이면 갱신
        }

    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}
