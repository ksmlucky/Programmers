// 코딩테스트 연습 - 월간 코드 챌린지 시즌1 - 이진 변환 반복하기
// https://programmers.co.kr/learn/courses/30/lessons/70129

public class RepeatBinaryTransformation {
    private static class Solution {

        private int[] solution(String s) {
            int transformCount = 0;
            int zeroCount = 0;
            int length = 0;

            // s!="1"
            // !s.equals("1")
            while (!s.equals("1")) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '0') {
                        zeroCount++;
                    }
                }
                s = s.replace("0", "");
                length = s.length();
                s = Integer.toBinaryString(length);

                transformCount++;
            }

            return new int[]{transformCount, zeroCount};
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution("110010101001"));
            System.out.println(sol.solution("01110"));
            System.out.println(sol.solution("1111111"));
        }
    }

}
