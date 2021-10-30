// 코딩테스트 연습 - 2018 KAKAO BLIND RECRUITMENT - 방금그곡
// https://programmers.co.kr/learn/courses/30/lessons/17683?language=java

package PROGRAMMERS;

public class Num17683 {
    private static class Solution{
        private String solution(String m, String[] musicinfos) {
            String answer = "";
            int maxtime = 0;

            // #이 붙은 애들을 구분하기 위해서 소문자로 바꿔줌
            for (int i = 0; i < m.length(); i++) {
                m = m.replace("A#", "a");
                m = m.replace("C#", "c");
                m = m.replace("D#", "d");
                m = m.replace("F#", "f");
                m = m.replace("G#", "g");
                m = m.replace("E#", "e");
            }

            for (int i = 0; i < musicinfos.length; i++) {
                String[] tmp = musicinfos[i].split(",");

                // #이 붙은 애들을 구분하기 위해서 소문자로 바꿔줌
                tmp[3] = tmp[3].replace("A#", "a");
                tmp[3] = tmp[3].replace("C#", "c");
                tmp[3] = tmp[3].replace("D#", "d");
                tmp[3] = tmp[3].replace("F#", "f");
                tmp[3] = tmp[3].replace("G#", "g");
                tmp[3] = tmp[3].replace("E#", "e");

                String[] start = tmp[0].split(":");
                String[] end = tmp[1].split(":");

                int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
                int min = Integer.parseInt(end[1]) - Integer.parseInt(start[1]) + (hour * 60);

                String str = "";    // 노래가 진행되는 동안의 음
                for (int j = 0; j < min; j++) {
                    str += tmp[3].charAt(j % tmp[3].length());
                }

                if (str.contains(m)) {
                    if (maxtime < str.length()) {
                        maxtime = str.length();
                        answer = tmp[2];
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
