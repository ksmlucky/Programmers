// 코딩테스트 연습 - 월간 코드 챌린지 시즌1 - 두 개 뽑아서 더하기
// https://school.programmers.co.kr/learn/courses/30/lessons/68644

package PROGRAMMERS.level1;

import java.util.*;

public class Num68644_두개뽑아서더하기 {
    private static class Solution {
        public int[] solution(int[] numbers) {
            Set<Integer> answerSet = new HashSet<>();

            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    answerSet.add(numbers[i] + numbers[j]);
                }
            }

            int[] answer = new int[answerSet.size()];

            List<Integer> answerList = new ArrayList<>();

            for (int temp : answerSet) {
                answerList.add(temp);
            }

            Collections.sort(answerList);

            for (int i = 0; i < answer.length; i++) {
                answer[i] = answerList.get(i);
            }

            return answer;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(new int[]{2, 1, 3, 4, 1}));
            System.out.println(sol.solution(new int[]{5, 0, 2, 7}));
        }
    }
}
