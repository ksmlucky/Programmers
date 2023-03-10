// 자물쇠와 열쇠

public class LockAndKey {
    public static class Solution {

        public boolean solution(int[][] key, int[][] lock) {
            boolean answer = false;

            for (int i = 0; i < 4; i++) {
                if (isMatch(key, lock)) return true;
                key = rotateKey(key);
            }

            return answer;
        }


        private int[][] rotateKey(int[][] key) {
            //key를 시계방향으로 90도 회전
            int[][] result = new int[key.length][key[0].length];

            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key[i].length; j++) {
                    result[i][j] = key[key[i].length - j - 1][i];
                }
            }

            return result;
        }

        public int[][] move(int[][] key, int length, int row, int col) {
            //이동할 행, 열의 크기만큼 이동
            int[][] result = new int[length][length];

            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key.length; j++) {
                    if (i + row >= 0 && i + row < length && j + col >= 0 && j + col < length) {
                        //인덱스 값이 0 미만, lock의 길이 초과범위를 넘어가지 않게 경곗값을 설정

                        result[i + row][j + col] = key[i][j];
                    }
                }
            }

            return result;
        }

        public boolean isUnlock(int[][] key, int[][] lock) {
            //rotateKey()와 move()를 사용해 키값이 변화가 됐다면 그 키값으로 자물쇠를 열기 위함
            for (int i = 0; i < lock.length; i++) {
                for (int j = 0; j < lock.length; j++) {
                    if ((key[i][j] + lock[i][j]) != 1) {
                        return false;
                    }
                }
            }

            return true;
        }

        public boolean isMatch(int[][] key, int[][] lock) {
            //key와 lock을 받아서 처음부터 끝까지 확인하는 작업
            for (int i = (1 - key.length); i < lock.length; i++) {
                for (int j = (1 - key.length); j < lock.length; j++) {
                    int[][] temp = move(key, lock.length, i, j);
                    if (isUnlock(temp, lock)) {
                        return true;
                    }
                }
            }

            return false;
        }

    }



    public static void main(String[] args) {
        Solution s = new Solution();

        int key[][] = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int lock[][] = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(s.solution(key, lock));


    }
}
