// 2020 카카오 인턴십 - 보석 쇼핑
// https://programmers.co.kr/learn/courses/30/lessons/67258

import java.util.*;

public class JewelryShopping {
    private static class Solution {
        private int[] solution(String[] gems) {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            Queue<String> queue = new LinkedList<String>();
            HashSet<String> set = new HashSet<String>();

            int length = Integer.MAX_VALUE;
            int start = 0;
            int idx = 0;

            set.addAll(Arrays.asList(gems));

            for (int i = 0; i < gems.length; i++) {
                map.put(gems[i], map.getOrDefault(gems[i], 0) + 1); // map에 보석 종류별 개수 추가
                queue.add(gems[i]); // queue에 보석 추가

                while(true){
                    String temp = queue.peek();

                    if(map.get(temp) > 1){  // 큐의 첫번째 보석이 2개 이상이면

                        map.put(temp, map.get(temp)-1); // 중복된 큐의 첫번째 보석을 큐의 앞쪽에서 삭제
                        queue.poll();

                        idx++;  // 제일 앞쪽에서 빼줬으므로 진열대의 시작을 +1
                    } else {
                        break;
                    }
                }

                // 진열대의 보석 종류 수와 전체 보석 종류 수가 같고,
                // 조건을 충족한 구간의 길이가 최소일 때
                if (map.size() == set.size() && length > queue.size()) {
                    length = queue.size();
                    start = idx;
                }

            }


            return new int[]{start + 1, start + length};
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String [] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//        String [] gems = {"AA", "AB", "AC", "AA", "AC"};
//        String [] gems = {"XYZ", "XYZ", "XYZ"};
//        String [] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        System.out.println(s.solution(gems)[0]+","+s.solution(gems)[1]);
    }
}
