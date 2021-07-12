public class NBinaryGame {
    public static class Solution {
        public String solution(int n, int t, int m, int p) {
            String answer = "";
            StringBuilder sb = new StringBuilder();

            int i = 1;
            sb.append(0);
            while (sb.length() < m * t) {
                sb.append(nBinary(i++, n));
            }

            for (int j = p - 1; j < m * (t - 1) + p; j += m) {
                answer += sb.charAt(j);
            }


            return answer;
        }

        public String nBinary(int num, int n) {
            String str = "";
            while (num != 0) {

                if (num % n < 10) { //10진수 이하인 경우
                    str = num % n + str;
                } else {    //10진수 이상인 경우
                   str = String.valueOf((char) (num % n + 'A' - 10)) + str;
                }
                num = num / n;
            }

            return str;
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(2, 4, 2, 1));

        System.out.println();

        System.out.println(s.solution(16, 16, 2, 1));
    }
}
