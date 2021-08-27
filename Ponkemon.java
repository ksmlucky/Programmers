// 찾아라 프로그래밍 마에스터 - 폰켓몬
// https://programmers.co.kr/learn/courses/30/lessons/1845


import java.util.ArrayList;

public class Ponkemon {
    private static class Solution {
        private int solution(int[] nums) {
            int answer = 0;
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            arrayList.add(nums[0]);

            for (int i = 1; i < nums.length; i++) {
                if (!arrayList.contains(nums[i])) {
                    arrayList.add(nums[i]);
                }
            }

            if (nums.length / 2 > arrayList.size()) {
                answer = arrayList.size();
            } else {
                answer = nums.length / 2;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[]{3, 1, 2, 3}));
        System.out.println(sol.solution(new int[]{3, 3, 3, 2, 2, 4}));
        System.out.println(sol.solution(new int[]{3, 3, 3, 2, 2, 2}));
    }
}
