// 코딩테스트 연습 - 2018 KAKAO BLIND RECRUITMENT - 방금그곡
// https://programmers.co.kr/learn/courses/30/lessons/17683

package PROGRAMMERS.level2;

public class Num17683_방금그곡 {
    private static class Solution{
        private String solution(String m, String[] musicinfos) {
            String answer = "";
            int maxTime = 0;

            // C#과 C가 구분되게 바꿔줌
            m = m.replace("C#", "c");
            m = m.replace("D#", "d");
            m = m.replace("F#", "f");
            m = m.replace("G#", "g");
            m = m.replace("A#", "a");

            for (int i = 0; i < musicinfos.length; i++) {
                // temp[0]: 시작 시간
                // temp[1]: 종료 시간
                // temp[2]: 음악 제목
                // temp[3]: 악보 정보
                String[] temp = musicinfos[i].split(",");

                temp[3] = temp[3].replace("C#", "c");
                temp[3] = temp[3].replace("D#", "d");
                temp[3] = temp[3].replace("F#", "f");
                temp[3] = temp[3].replace("G#", "g");
                temp[3] = temp[3].replace("A#", "a");

                String start[] = temp[0].split(":");
                String end[] = temp[1].split(":");
                int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
                int min = Integer.parseInt(end[1]) - Integer.parseInt(start[1]) + (hour * 60);

                String tempStr = "";
                for (int j = 0; j < min; j++) {
                    // 악보 정보가 시간(분)만큼 반복되게 tempStr에 저장해줌
                    tempStr += temp[3].charAt(j % temp[3].length());
                }

                // 네오가 기억한 멜로디가 음악이 재생된 시간 동안의 악보 정보와 같은 부분이 있다면
                if (tempStr.contains(m)) {
                    // 같은 애들이 여럿일 경우 길이가 가장 긴 애가 정답
                    if (maxTime < tempStr.length()) {
                        maxTime = tempStr.length();
                        answer = temp[2];
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(sol.solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(sol.solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }

}
