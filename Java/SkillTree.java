// 코딩테스트 연습 - Summer/Winter Coding(~2018) - 스킬트리
// https://programmers.co.kr/learn/courses/30/lessons/49993

package PROGRAMMERS;

import java.util.LinkedList;
import java.util.Queue;

public class SkillTree {
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

        boolean check(String skill, String skilltree) {
            Queue<Character> queue = new LinkedList<Character>();
            for (int i = 0; i < skill.length(); i++) {
                queue.add(skill.charAt(i));
            }

            for (int i = 0; i < skilltree.length(); i++) {
                if (!queue.contains(skilltree.charAt(i))) {
                    continue;
                } else if ((skilltree.charAt(i)) != queue.peek()) {
                    return false;
                } else if ((skilltree.charAt(i)) == queue.peek()){
                    queue.poll();
                    if (queue.isEmpty()) {
                        return true;
                    }
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
