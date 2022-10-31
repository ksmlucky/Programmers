// 코딩테스트 연습 - 연습문제 - 숫자 짝꿍
// https://school.programmers.co.kr/learn/courses/30/lessons/131128

package PROGRAMMERS.level1;

public class Num131128_숫자짝꿍 {
    static class Solution {
        public String solution(String X, String Y) {
            int[] arrX = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] arrY = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int i = 0; i < X.length(); i++) {
                arrX[X.charAt(i) - '0']++;
            }
            for (int i = 0; i < Y.length(); i++) {
                arrY[Y.charAt(i) - '0']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 9; i >= 0; i--) {
                for(int j=0; j<Math.min(arrX[i],arrY[i]); j++){
                    sb.append(i);
                }
            }

            if("".equals(sb.toString())){
                return "-1";
            }else if(sb.toString().charAt(0)=='0'){
                return "0";
            }else {
                return sb.toString();
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("100", "2345"));
        System.out.println(sol.solution("100", "203045"));
        System.out.println(sol.solution("100", "123450"));
        System.out.println(sol.solution("12321", "42531"));
        System.out.println(sol.solution("5525", "1255"));
    }
}
