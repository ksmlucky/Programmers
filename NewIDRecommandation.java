package PROGRAMMERS;

public class NewIDRecommandation {
    private static class Solution{
        private String solution(String new_id) {
            String answer = new_id;

            // 1
            answer = new_id.toLowerCase();

            // 2
            String id = "";
            for(int i = 0; i < answer.length(); i++) {
                char c = answer.charAt(i);

                if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                    id+=String.valueOf(c);
                }
            }
            answer = id;

            // 3
            answer = answer.replace("..", ".");
            while (answer.contains("..")) {
                answer = answer.replace("..", ".");
            }

            // 4
            if (answer.length() > 0) {
                if (answer.charAt(0) == '.') {
                    answer = answer.substring(1, answer.length());
                }
            }
            if (answer.length() > 0) {
                if (answer.charAt(answer.length() - 1) == '.') {
                    answer = answer.substring(0, answer.length() - 1);
                }
            }

            // 5
            if (answer.equals("")) {
                answer = "a";
            }

            // 6
            if (answer.length() >= 16) {
                answer = answer.substring(0, 15);

                if (answer.charAt(answer.length() - 1) == '.') {
                    answer = answer.substring(0, answer.length() - 1);
                }
            }

            // 7
            String c = answer.charAt(answer.length() - 1) + "";
            if(answer.length() == 2) {
                answer = answer + c;
            } else if(answer.length() == 1) {
                answer = answer + c + c;
            }

            return answer;
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(sol.solution("z-+.^."));
        System.out.println(sol.solution("=.="));
        System.out.println(sol.solution("123_.def"));
        System.out.println(sol.solution("abcdefghijklmn.p"));
    }
}
