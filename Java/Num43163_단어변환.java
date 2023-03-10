// 코딩테스트 연습 - 깊이/너비 우선 탐색(DFS/BFS) - 단어 변환
// https://school.programmers.co.kr/learn/courses/30/lessons/43163

package PROGRAMMERS.level3;

public class Num43163_단어변환 {
    private static class Solution {
        static int min;
        static boolean[] visited;
        private int solution(String begin, String target, String[] words) {
            int answer = 0;
            min = Integer.MAX_VALUE;
            visited = new boolean[words.length];

            if (isPossible(words, target)) {
                dfs(0, begin, target, words);
                answer = min;
            }

            return answer;
        }

        private void dfs(int depth, String current, String target, String[] words) {
            if (current.equals(target)) {
                min = Math.min(min, depth);
            }

            if (depth > words.length) {
                return;
            }

            for (int i = 0; i < words.length; i++) {
                int count = 0;

                for (int j = 0; j < current.length(); j++) {
                    if (current.charAt(j) != words[i].charAt(j)) {
                        count++;
                    }
                }

                if (count == 1 && !visited[i]) {
                    visited[i] = true;
                    dfs(depth + 1, words[i], target, words);
                    visited[i] = false;
                }
            }
        }

        private boolean isPossible(String[] words, String target) {
            boolean flag = false;
            for (String str : words) {
                if (target.equals(str)) {
                    flag = true;
                    break;
                }
            }

            return flag;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(sol.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }
}
