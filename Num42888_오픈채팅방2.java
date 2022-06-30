// 코딩테스트 연습 - 2019 KAKAO BLIND RECRUITMENT - 오픈채팅방
// https://programmers.co.kr/learn/courses/30/lessons/42888

package PROGRAMMERS.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Num42888_오픈채팅방2 {
    private static class Solution {
        private String[] solution(String[] record) {
            HashMap<String, String> hashMap = new HashMap<>();
            ArrayList<String[]> arrayList = new ArrayList<>();

            for (String temp : record) {
                String[] words = temp.split(" ");

                if (words[0].equals("Enter")) { // 채팅방에 들어온 사람이면
                    hashMap.put(words[1], words[2]); // map에 추가
                    arrayList.add(words); // 출력할 때 사용하기 위해 arrayList에 추가
                } else if (words[0].equals("Change")) { // 닉네임을 바꾼 사람이면
                    hashMap.put(words[1], words[2]); // map의 key에 해당하는 value를 바꿔줌
                } else if (words[0].equals("Leave")) {
                    arrayList.add(words); // 출력할 때 사용하기 위해 arrayList에 추가
                }
            }

            String[] answer = new String[arrayList.size()];

            for (int i = 0; i < arrayList.size(); i++) {
                String[] temp = arrayList.get(i);

                String name = hashMap.get(temp[1]); // 아이디(temp[1])에 해당하는 닉네임을 name에 저장

                if (temp[0].equals("Enter")) {
                    answer[i] = name + "님이 들어왔습니다.";
                } else {
                    answer[i] = name + "님이 나갔습니다.";
                }
            }

            return answer;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(Arrays.toString(sol.solution(new String[]{
                    "Enter uid1234 Muzi", "Enter uid4567 Prodo",
                    "Leave uid1234", "Enter uid1234 Prodo",
                    "Change uid4567 Ryan"})));
        }
    }
}
