package PROGRAMMERS.level1;

public class Num86051_없는숫자더하기 {
    static class Solution {
        public int solution(int[] numbers) {
            boolean[] arr = new boolean[10];
            for (int temp : numbers) {
                arr[temp] = true;
            }

            int answer = 0;

            for (int i = 0; i < arr.length; i++) {
                if (!arr[i]) {
                    answer += i;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0}));
        System.out.println(sol.solution(new int[]{5, 8, 4, 0, 6, 7, 9}));
    }
}
