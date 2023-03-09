package PROGRAMMERS;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {
    private static class Solution {
        private int[] solution(String[] operations) {
            PriorityQueue<Integer> minPq = new PriorityQueue<>();
            PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < operations.length; i++) {
                String[] strArr = operations[i].split(" ");

                if (strArr[0].equals("I")) {
                    // 주어진 숫자 삽입
                    minPq.add(Integer.parseInt(strArr[1]));
                    maxPq.add(Integer.parseInt(strArr[1]));
                } else {
                    if (strArr[1].equals("1")) {
                        // 큐가 비어있으면 무시
                        if (minPq.isEmpty() && maxPq.isEmpty()) {
                            continue;
                        } else {
                            // 최댓값 삭제
                            int max = maxPq.poll();
                            minPq.remove(max);
                        }
                    } else if (strArr[1].equals("-1")) {
                        // 큐가 비어있으면 무시
                        if (minPq.isEmpty() && maxPq.isEmpty()) {
                            continue;
                        } else {
                            // 최솟값 삭제
                            int min = minPq.poll();
                            maxPq.remove(min);
                        }
                    }
                }
            }

            if (minPq.isEmpty() && maxPq.isEmpty()) {
                return new int[]{0, 0};
            } else {
                return new int[]{maxPq.peek(), minPq.peek()};

            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution(new String[]{"I 16","D 1"})));
        System.out.println(Arrays.toString(sol.solution(new String[]{"I 7","I 5","I -5","D -1"})));
    }
}
