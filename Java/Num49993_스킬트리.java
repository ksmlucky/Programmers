// 코딩테스트 연습 - Summer/Winter Coding(~2018) - 스킬트리
// https://programmers.co.kr/learn/courses/30/lessons/49993

package PROGRAMMERS.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Num49993_스킬트리 {
    private static class Solution {
        private int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for (int i = 0; i < skill_trees.length; i++) {
                if (check(skill, skill_trees[i])) {
                    answer++;
                }
            }

            return answer;
        }

        private boolean check(String skill, String skillTree) {
            Queue<Character> queue = new LinkedList<>(); // 스킬트리 순서 저장 큐
            for (int i = 0; i < skill.length(); i++) {
                queue.offer(skill.charAt(i));
            }

            for (int i = 0; i < skillTree.length(); i++) {
                char temp = skillTree.charAt(i);

                // 큐에 비교하려고 하는 스킬(temp)이 있으면
                if (queue.contains(temp)) {
                    // 큐의 맨처음이 temp가 아닌데 큐에 temp가 포함되어 있으면
                    if (queue.peek() != temp && queue.contains(temp)) {
                        return false; // 순서가 맞지 않으므로 false 반환
                    }

                    // 큐의 맨처음과 temp가 같으면 poll
                    if (queue.peek() == temp) {
                        queue.poll();
                    }
                }
            }

            // for문을 통과했으면 true 반환
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
