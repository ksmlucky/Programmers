import java.util.ArrayList;
import java.util.Collections;

public class NewsClustering {
    private static class Solution {
        private int solution(String str1, String str2) {
            double answer = 0;

            ArrayList<String> STR1 = new ArrayList<>();
            ArrayList<String> STR2 = new ArrayList<>();

            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();

            for (int i = 0; i < str1.length() - 1; i++) {
                char char1 = str1.charAt(i);
                char char2 = str1.charAt(i + 1);

                if (char1 >= 'a' && char1 <= 'z' && char2 >= 'a' && char2 <= 'z') {
                    STR1.add(char1 + "" + char2);
                }
            }
            for (int i = 0; i < str2.length() - 1; i++) {
                char char1 = str2.charAt(i);
                char char2 = str2.charAt(i + 1);

                if (char1 >= 'a' && char1 <= 'z' && char2 >= 'a' && char2 <= 'z') {
                    STR2.add(char1 + "" + char2);
                }
            }

            ArrayList<String> BIG = new ArrayList<>();
            ArrayList<String> SMALL = new ArrayList<>();

            // 합집합 BIG, 교집합 SMALL 구하기
            for (int i = 0; i < STR1.size(); i++) {
                String str = STR1.get(i);
                if (STR2.remove(str)) {
                    SMALL.add(str);
                }
                BIG.add(str);
            }

            // 교집합에 포함되지 않았던 애들 합집합에 넣어주기
            for(int i=0; i<STR2.size(); i++) {
                BIG.add(STR2.get(i));
            }

            answer = 65536 * ((double) SMALL.size() / (double) BIG.size());

            if (BIG.size() == 0) {
                return 65536;
            } else {
                return (int) answer;
            }
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("FRANCE", "french"));
        System.out.println(sol.solution("handshake", "shake hands"));
        System.out.println(sol.solution("aa1+aa2", "AAAA12"));
        System.out.println(sol.solution("E=M*C^2", "e=m*c^2"));
    }
}
