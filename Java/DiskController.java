import java.util.PriorityQueue;

public class DiskController {

    public static class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;
            int count = 0;
            int last = -1;
            int now = 0;

            PriorityQueue<Integer> q = new PriorityQueue<Integer>();
            while(count < jobs.length){  //count가 jobs의 개수가 될 때까지 반복
                for(int[] job : jobs){
                    if(last < job[0] && job[0] <= now){
                        answer += (now - job[0]);
                        q.add(job[1]);
                    }
                }

                if(q.size() > 0){
                    answer += (q.size() * q.peek());
                    last = now;
                    now += q.poll();    //큐에서 빼서 now에 더해줌
                    count++;
                }
                else{
                    now++;
                }
            }

            return (answer / jobs.length);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] jobs = {{0,3},{1,9},{2,6}};

        System.out.println(s.solution(jobs));

//        int[][] jobs2 = {{0,3},{1,9},{2,6},{3,4}};
//
//        System.out.println(s.solution(jobs2));
    }
}
