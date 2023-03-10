// 코딩테스트 연습 - 스택/큐 - 프린터
// https://programmers.co.kr/learn/courses/30/lessons/42587

package PROGRAMMERS.level2;

import java.util.ArrayList;
import java.util.List;

// 클래스 이용 풀이
public class Num42587_프린터2 {
    private static class Solution {
        class PrintJob{
            int priority;
            int location;

            public PrintJob(int priority, int location) {
                this.priority = priority;
                this.location = location;
            }
        }

        private int solution(int[] priorities, int location) {
            int answer = 0;

            // Queue 만들기
            List<PrintJob> printer = new ArrayList<PrintJob>();
            for (int i = 0; i < priorities.length; i++) {
                printer.add(new PrintJob(priorities[i], i));
            }
            while(!printer.isEmpty()) {
                // 프린터에서 0번을 꺼내서 max priority가 아니면 다시 끝에 넣는다
                PrintJob job = printer.remove(0);
                if (printer.stream().anyMatch(otherJob -> job.priority < otherJob.priority)) {
                    printer.add(job);
                } else {
                    // max priority면 내가 찾는 job이 맞는지 확인
                    answer++;
                    if (location == job.location) {
                        break;
                    }
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
