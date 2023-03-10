// 코딩테스트 연습 - 해시 - 완주하지 못한 선수
// https://programmers.co.kr/learn/courses/30/lessons/42576

package PROGRAMMERS.level1;

import java.util.HashMap;

public class Num42576_완주하지못한선수 {
    private static class Solution {
        private String solution(String[] participant, String[] completion) {
            HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

            // hashMap에 사람 추가
            // 동명이인이 있을 수도 있으니 이미 있는 사람이면 원래 값에 +1
            for (String name : participant) {
                hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
            }

            // 이걸로도 가능
//            for (int i = 0; i < participant.length; i++) {
//                hashMap.put(participant[i], hashMap.getOrDefault(participant[i], 0) + 1);
//            }


            // 완주한 사람은 -1씩 해주기
            for (String name : completion) {
                hashMap.put(name, hashMap.get(name) - 1);
            }

            // 이걸로도 가능
//            for (int i = 0; i < completion.length; i++) {
//                hashMap.put(completion[i], hashMap.getOrDefault(completion[i], 0) - 1);
//            }

            String answer = "";

            for (String name : hashMap.keySet()) {
                System.out.println(hashMap.values());
                if (hashMap.get(name) != 0) { // name을 이름으로 가진 사람이 있으면 그 사람이 완주하지 못한거임!
                    answer = name;
                    break;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"kiki", "eden"}));
        System.out.println(sol.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(sol.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
}
