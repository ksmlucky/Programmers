// 코딩테스트 연습 - 2020 카카오 인턴십 - 키패드 누르기
// https://programmers.co.kr/learn/courses/30/lessons/67256

package PROGRAMMERS.level1;

public class Num67256_키패드누르기 {
    static class Position{
        int r;
        int c;

        Position(int r, int c){
            this.r = r;
            this.c = c;
        }

        public String getFinger(String hand){
            String finger = hand.equals("right")? "R" : "L";

            if(this.c ==0) {
                finger = "L";
            } else if(this.c == 2){
                finger = "R";
            } else {
                int leftDist = left.getDistance(this);
                int rightDist = right.getDistance(this);

                if(leftDist < rightDist) {
                    finger = "L";
                } else if(rightDist < leftDist) {
                    finger = "R";
                }
            }

            return finger;
        }

        public int getDistance(Position p) {
            return Math.abs(this.r - p.r) + Math.abs(this.c - p.c);
        }
    }

    static Position left;
    static Position right;
    static Position numPos;

    private static class Solution{
        private String solution(int[] numbers, String hand) {
            String answer = "";

            left = new Position(3,0);
            right = new Position(3,2);

            for(int num : numbers){
                numPos = new Position((num-1)/3,(num-1)%3);
                if(num == 0){
                    numPos = new Position(3,1);
                }

                String finger = numPos.getFinger(hand);

                answer += finger;
                if(finger.equals("L")){
                    left = numPos;
                } else {
                    right = numPos;
                }
            }


            return answer;
        }
        public static void main(String[] args) {
            Solution sol = new Solution();

            System.out.println(sol.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
            System.out.println(sol.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
            System.out.println(sol.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
        }
    }
}
