// 2020 KAKAO BLIND RECRUITMENT - 외벽 점검
// https://programmers.co.kr/learn/courses/30/lessons/60062

public class CheckTheWall {
    private static class Solution {

        int[] weak, dist;
        int[][] weak_cases;
        int n, answer;

        private int solution(int n, int[] weak, int[] dist) {

            weak_cases = new int[weak.length][weak.length];
            this.weak = weak;
            this.dist = dist;
            this.answer = dist.length+1;
            this.n = n;

            makeWeakCases();
            makeDistCases(new boolean[dist.length], new int[dist.length], 0);
            if(answer == dist.length+1)
                return -1;
            else
                return answer;
        }

        private void makeWeakCases(){
            int[] weak_case = this.weak.clone();
            weak_cases[0] = weak_case.clone();
            for(int i = 1; i < weak.length; i++){
                int temp = weak_case[0];
                for(int j = 1; j < weak.length; j++){
                    weak_case[j-1] = weak_case[j];
                }
                weak_case[weak.length-1] = temp+n;
                weak_cases[i] = weak_case.clone();
            }
        }

        private void makeDistCases(boolean[] dist_visit, int[] dist_case, int idx){
            if(idx == dist.length){
                for(int[] weak_case: weak_cases)
                    check(dist_case, weak_case);
            }
            for(int i = 0; i < dist.length; i++){
                if(!dist_visit[i]){
                    dist_visit[i] = true;
                    dist_case[idx] = dist[i];
                    makeDistCases(dist_visit, dist_case, idx+1);
                    dist_case[idx] = 0;
                    dist_visit[i] = false;
                }
            }
        }

        private void check(int[] dist_case, int[] weak_case){
            int cur = 0, next;
            int dist_idx = 0;
            while(cur < weak_case.length && dist_idx < dist_case.length){
                next = cur+1;
                while(next < weak_case.length &&
                        weak_case[cur] + dist_case[dist_idx] >= weak_case[next]){
                    next++;
                }
                cur = next;
                dist_idx++;
            }

            if(cur == weak_case.length && dist_idx < answer)
                answer = dist_idx;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4}));
        System.out.println(s.solution(12, new int[]{1, 3, 4, 9, 10}, new int[]{3, 5, 7}));
    }
}
