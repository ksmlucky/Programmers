// 코딩테스트 연습 - 해시 - 전화번호 목록
// https://programmers.co.kr/learn/courses/30/lessons/42577

package PROGRAMMERS;

//import java.util.Arrays;
import java.util.HashMap;

public class PhoneNumberList {
    private static class Solution {
        private boolean solution(String[] phone_book) {
//            Arrays.sort(phone_book);
//
//            for (int i = 0; i < phone_book.length - 1; i++) {
//                if (phone_book[i + 1].startsWith(phone_book[i])) {
//                    return false;
//                }
//            }

            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < phone_book.length; i++) {
                hashMap.put(phone_book[i], 1);
            }

            for (int i = 0; i < phone_book.length; i++) {
                for (int j = 0; j < phone_book[i].length(); j++) {
                    if (hashMap.containsKey(phone_book[i].substring(0, j))) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(sol.solution(new String[]{"123","456","789"}));
        System.out.println(sol.solution(new String[]{"12","123","1235","567","88"}));
    }
}
