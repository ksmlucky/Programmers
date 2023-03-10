// 코딩테스트 연습 - Summer/Winter Coding(~2018) - 방문 길이
// https://school.programmers.co.kr/learn/courses/30/lessons/49994

package PROGRAMMERS.level2;

import java.util.HashSet;

public class Num49994_방문길이_set풀이 {
    private static class Solution {
        private int solution(String dirs) {
            int answer = 0;
            HashSet<String> hashSet = new HashSet<>(); // 지나간 길을 저장하기 위한 Set

            int r = 5, c = 5; // 중앙에서 시작

            for (int i = 0; i < dirs.length(); i++) {
                char temp = dirs.charAt(i);
                switch (temp) {
                    case 'U':
                        if (isPossible(r + 1, c)) { // 갈 수 있는 위치면
                            // 지나간 길에 넣어주고
                            hashSet.add(r + "+" + c + "+" + (r + 1) + "+" + c);
                            hashSet.add((r + 1) + "+" + c + "+" + r + "+" + c);
                            r++; // 현재 위치 이동
                        }
                        break;
                    case 'D':
                        if (isPossible(r - 1, c)) {
                            hashSet.add(r + "+" + c + "+" + (r - 1) + "+" + c);
                            hashSet.add((r - 1) + "+" + c + "+" + r + "+" + c);
                            r--;
                        }
                        break;
                    case 'R':
                        if (isPossible(r, c - 1)) {
                            hashSet.add(r + "+" + c + "+" + r + "+" + (c - 1));
                            hashSet.add(r + "+" + (c - 1) + "+" + r + "+" + c);
                            c--;
                        }
                        break;
                    case 'L':
                        if (isPossible(r, c + 1)) {
                            hashSet.add(r + "+" + c + "+" + r + "+" + (c + 1));
                            hashSet.add(r + "+" + (c + 1) + "+" + r + "+" + c);
                            c++;
                        }
                        break;
                }

                // 왕복하는 길을 넣어줬으므로 2배로 들어감. 그래서 마지막에 2로 나눠줌
                answer = hashSet.size() / 2;
            }


            return answer;

        }

        private static boolean isPossible(int r, int c) {
            if (r < 0 || r >= 11 || c < 0 || c >= 11) { // 범위 밖으로 벗어나면 false
                return false;
            }
            return true;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution("ULURRDLLU"));
            System.out.println(sol.solution("LULLLLLLU"));
            System.out.println(sol.solution("UDU"));
        }
    }
}
