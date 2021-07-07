public class KakaofriendsColoringbook {
    public static class Solution {
        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;

            int[][] check = new int[picture.length][picture[0].length];

            for (int i = 0; i < picture.length; i++) {
                for (int j = 0; j < picture[i].length; j++) {
                    int area = area(picture, check, i, j);
                    if (area > 0) {
                        numberOfArea++;
                        maxSizeOfOneArea = maxSizeOfOneArea < area ? area : maxSizeOfOneArea;
                    }
                }
            }

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }

        public int area(int[][] picture, int[][] check, int i, int j) {
            if (picture[i][j] == 0) {
                return 0;
            }
            if ((check[i][j]+1) > 0) {
                return 0;
            }
            int result = 1;
            if (i + 1 != picture.length) {
                if (picture[i + 1][j] == picture[i][j]) {
                    result += area(picture, check, i + 1, j);
                }
            }
            if (j + 1 != picture[0].length) {
                if (picture[i][j + 1] == picture[i][j]) {
                    result += area(picture, check, i, j + 1);
                }
            }
            if (i - 1 >= 0) {
                if (picture[i - 1][j] == picture[i][j]) {
                    result += area(picture, check, i - 1, j);
                }
            }
            if (j - 1 >= 0) {
                if (picture[i][j - 1] == picture[i][j]) {
                    result += area(picture, check, i, j - 1);
                }
            }

            return result;
        }

    }



    public static void main(String[] args) {
        Solution s = new Solution();
        int m = 6, n = 4;
        int[][] picture = {{1,1,1,0}, {1,2,2,0}, {1,0,0,1}, {0,0,0,1}, {0,0,0,3}, {0,0,0,3}};

        System.out.println(s.solution(m,n,picture)[0] + " " + s.solution(m,n,picture)[1]);
    }
}

/*
1. 사진과 같은 사이즈의 배열을 하나 복사한다.
이 배열은 이미 탐색이 끝난 곳인지 표시하는 역할을 합니다.

2. 반복문을 호출하여 원소의 처음부터 끝까지 재귀함수를 호출한다.
탐색 알고리즘이기 때문에 재귀적으로 풀이하는 것이 가장 쉽습니다.

3. 해당 영역의 값이 0이라면 0을 반환한다
0인 영역은 탐색할 필요가 없습니다.

4. 이 영역이 탐색이 된 곳인지 검사한다.
1번에서 만들어 놓은 배열의 값이 1 이상이라면 이미 탐색한 곳이므로 0을 반환합니다.

5. 상, 하, 좌, 우로 재귀적으로 탐색을 시도한다. 같은 색깔의 영역이라면 1을 더한 값을 반환한다.

6. 모든 탐색이 끝나면 해당 값을 반환하여 문제풀이를 종료한다.
 */