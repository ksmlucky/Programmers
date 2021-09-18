// 코딩테스트 연습 - 탐욕법 - 구명보트
// https://programmers.co.kr/learn/courses/30/lessons/42885

import java.util.Arrays;

public class Lifeboat {
    private static class Solution {
        private int solution(int[] people, int limit) {
            Arrays.sort(people);

            int index = 0;
            int answer = 0;

            for (int i = people.length-1; i >= index; i--) {
                if (people[index] + people[i] > limit) {
                    answer++;
                } else {
                    answer++;
                    index++;
                }
            }

            return answer;
        }

        public static void main(String[] args) {
            Lifeboat.Solution sol = new Lifeboat.Solution();

            System.out.println(sol.solution(new int[]{70, 50, 80, 50}, 100));
            System.out.println(sol.solution(new int[]{70, 80, 50}, 100));
        }
    }
}
