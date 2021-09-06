// 코딩테스트 연습 - 2019 KAKAO BLIND RECRUITMENT - 오픈채팅방
// https://programmers.co.kr/learn/courses/30/lessons/42888

import java.util.*;

public class OpenChatRoom {
    private static class Solution {
        private String[] solution(String[] record) {
            Map<String, String> idMap = new HashMap<>();
            List<String[]> result = new LinkedList<>();

            for (String records : record) {
                String[] keyWord = records.split(" ");

                if (keyWord[0].equals("Enter")) { // 들어오면 id 맵에 저장후, result에 추가
                    idMap.put(keyWord[1], keyWord[2]);
                    result.add(keyWord);
                } else if (keyWord[0].equals("Change")) { // 닉네임 업데이트만
                    idMap.put(keyWord[1], keyWord[2]);
                } else { // 나가면 result에만 추가
                    result.add(keyWord);
                }
            }

            String[] answer = new String[result.size()];
            int idx = 0;
            for (String[] keyWords : result){
                String nickName = idMap.get(keyWords[1]);

                if (keyWords[0].equals("Enter")) {
                    answer[idx++] = nickName + "님이 들어왔습니다.";
                } else {
                    answer[idx++] = nickName + "님이 나갔습니다.";
                }
            }
            return answer;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(new String[]{
                    "Enter uid1234 Muzi", "Enter uid4567 Prodo",
                    "Leave uid1234", "Enter uid1234 Prodo",
                    "Change uid4567 Ryan"}));
        }
    }
}
