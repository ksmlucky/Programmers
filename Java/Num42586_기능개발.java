// 코딩테스트 연습 - 스택/큐 - 기능개발
// https://programmers.co.kr/learn/courses/30/lessons/42586

package PROGRAMMERS.level2;

import java.util.ArrayList;

public class Num42586_기능개발 {
    private static class Solution{
        private int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};
            int[] check = new int[progresses.length];

            for (int i = 0; i < progresses.length; i++) {
                int count = 0;
                while (progresses[i] < 100) {
                    progresses[i] += speeds[i];
                    count++;
                }
                check[i] = count;
            }

            int temp = check[0];
            int count = 1;
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 1; i < check.length; i++) {
                if (temp >= check[i]) {
                    count++;
                    if (i == check.length - 1) {
                        arrayList.add(count);
                        break;
                    }
                    continue;
                } else {
                    temp = check[i];
                    arrayList.add(count);
                    count = 1;
                }
                if (i == check.length - 1) {
                    arrayList.add(count);
                    break;
                }
            }

            answer = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                answer[i] = arrayList.get(i);
            }

            return answer;
        }
        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
            System.out.println(sol.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
        }
    }
}
