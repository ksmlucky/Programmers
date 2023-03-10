// 코딩테스트 연습 - 완전탐색 - 소수 찾기
// https://school.programmers.co.kr/learn/courses/30/lessons/42839

package PROGRAMMERS.level2;

import java.util.HashSet;

public class Num42839_소수찾기 {
    private static class Solution {
        static boolean[] visited; // 방문 체크 배열
        static HashSet<Integer> hashSet; // 011과 11은 같은 수이므로 중복 제거를 위해 Set 사용
        private int solution(String numbers) {
            int answer = 0;
            int[] arr = new int[numbers.length()];
            visited = new boolean[numbers.length()];
            hashSet = new HashSet<>();

            // 배열에 숫자 넣어주기
            for (int i = 0; i < numbers.length(); i++) {
                arr[i] = numbers.charAt(i) - '0';
            }

            dfs("", 0, arr);

            // Set에서 숫자 하나씩 뽑아서 소수인지 판별
            for (int temp : hashSet) {
                if (isPrime(temp)) {
                    answer++;
                }
            }

            return answer;
        }

        private static void dfs(String str, int depth, int[] arr) {
            // 숫자가 하나라도 있으면 Set에 추가
            if (depth != 0) {
                hashSet.add(Integer.parseInt(str));
            }

            // dfs의 깊이가 배열의 크기만큼 들어갔으면 return(탈출 조건)
            if (depth == arr.length) {
                return;
            }

            for (int i = 0; i < arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    str += arr[i];
                    dfs(str, depth + 1, arr);
                    str = str.substring(0, str.length() - 1);
                    visited[i] = false;
                }
            }
        }

        private static boolean isPrime(int num) {
            // 소수는 2보다 큰 수부터 시작작
           if (num < 2) {
                return false;
            }
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution("17"));
            System.out.println(sol.solution("011"));
        }
    }
}
