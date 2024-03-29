// 코딩 테스트 연습 - 탐욕법 - 체육복
// https://programmers.co.kr/learn/courses/30/lessons/42862

package PROGRAMMERS.level1;

import java.util.Arrays;

public class Num42862_체육복 {
    private static class Solution {
        private int solution(int n, int[] lost, int[] reserve) {
            int answer = n - lost.length;

            Arrays.sort(lost);
            Arrays.sort(reserve);

            // 여벌 체육복을 가져온 학생이 도난당한 경우
            for(int i=0; i<lost.length; i++){
                for(int j=0; j<reserve.length; j++){
                    if(lost[i] == reserve[j]){
                        answer++;
                        lost[i] = -1;
                        reserve[j] = -1;
                        break;
                    }
                }
            }

            // 도난당한 학생에게 체육복 빌려주는 경우
            for(int i=0; i<lost.length; i++){
                for(int j=0; j<reserve.length; j++){
                    if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){
                        answer++;
                        reserve[j] = -1;
                        break;
                    }
                }
            }

            return answer;
        }
    }


    public static void main(String[] args) {
        Num42862_체육복.Solution sol = new Num42862_체육복.Solution();

        System.out.println(sol.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        System.out.println(sol.solution(5, new int[]{2, 4}, new int[]{3}));
        System.out.println(sol.solution(3, new int[]{3}, new int[]{1}));
    }
}
