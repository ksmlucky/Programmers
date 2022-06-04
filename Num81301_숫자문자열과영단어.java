// 2021 카카오 채용연계형 인턴십 - 숫자 문자열과 영단어
// https://programmers.co.kr/learn/courses/30/lessons/81301

package PROGRAMMERS.level1;

public class Num81301_숫자문자열과영단어 {

    public static class Solution {
        public int solution(String s) {
            int answer = 0;
            s = s.replace("one", "1");
            s = s.replace("two", "2");
            s = s.replace("three", "3");
            s = s.replace("four", "4");
            s = s.replace("five", "5");
            s = s.replace("six", "6");
            s = s.replace("seven", "7");
            s = s.replace("eight", "8");
            s = s.replace("nine", "9");
            s = s.replace("zero", "0");

            int i = Integer.parseInt(s);    //문자열을 정수형으로 변환
            return i;
        }

    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "one4seveneight";

        System.out.println(sol.solution(s));
    }
}
