// 코딩테스트 연습 - 스택/큐 - 프린터
// https://programmers.co.kr/learn/courses/30/lessons/42587

package PROGRAMMERS.level2;

import java.util.ArrayList;
import java.util.List;

// 클래스 정의하지 않는 풀이
public class Num42587_프린터3 {
    private static class Solution {
        private int solution(int[] priorities, int location) {
            int answer = 0;

            List<Integer> printer = new ArrayList<>();
            for (int priority :
                    priorities) {
                printer.add(priority);
            }

            while (!printer.isEmpty()) {
                Integer priority = printer.remove(0);

                if (printer.stream().anyMatch(otherPriority -> priority < otherPriority)) {
                    printer.add(priority);
                } else {
                    answer++;
                    if (location == 0) {
                        break;
                    }
                }

                location--;
                if (location < 0) {
                    location = printer.size() - 1;
                }
            }

            return answer;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();

            System.out.println(solution.solution(new int[]{2, 1, 3, 2}, 2));
            System.out.println(solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
        }
    }
}
