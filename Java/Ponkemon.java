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

                // 중복되지 않는 애들만 리스트에 추가
                if (!arrayList.contains(nums[i])) {
                    arrayList.add(nums[i]);
                }
            }

            // 가능한 최대 종류 수가 nums.length/2 이므로 리스트의 크기가
            // nums.length/2를 넘어가면 nums.length/2가 최대 종류 수가 됨
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
