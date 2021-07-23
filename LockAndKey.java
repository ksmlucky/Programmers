public class LockAndKey {
    public static class Solution {
        public boolean solution(int[][] key, int[][] lock) {
            boolean answer = true;
            return answer;
        }


    }

    public int[][] rotateKey(int[][] key) {
        int[][] result = new int[key.length][key[0].length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                result[i][j] = key[key[i].length - j - 1][i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int key[][] = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int lock[][] = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(s.solution(key, lock));


    }
}
