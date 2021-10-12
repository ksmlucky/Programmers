// 프로그래머스 - SummerWinter Coding(~2018) - 영어 끝말잇기
// https://programmers.co.kr/learn/courses/30/lessons/12981

package PROGRAMMERS;

import java.util.ArrayList;
import java.util.Arrays;

public class WordChainGameInEnglish {
    private static class Solution{
        private int[] solution(int n, String[] words) {
            int[] answer = new int[2];
            ArrayList<String> list = new ArrayList<>();

            for (int i = 0; i < words.length - 1; i++) {
                // 둘 다 맞음
//                if (list.contains(words[i + 1]) || !words[i].substring(words[i].length() - 1).equals(words[i + 1].substring(0, 1))) {
                if (list.contains(words[i + 1]) || words[i].charAt(words[i].length() - 1) != (words[i + 1].charAt(0))) {
                    answer[0] = ((i + 1) % n) + 1;
                    answer[1] = (i + 1) / n + 1;
                    return answer;
                }

                list.add(words[i]);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(sol.solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(sol.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }
}
