package PROGRAMMERS;

import java.io.*;
import java.util.StringTokenizer;

public class Ssafy2DimensionArr {
    public static void main(String[] args) throws FileNotFoundException,IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int dr[] = {-1, 0, 1, 1, 1, 0, -1, -1};
            int dc[] = {-1, -1, -1, 0, 1, 1, 1, 0};
            char[][] grid = new char[N][N];
            int[][] answerGrid = new int[N][N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    grid[j][k] = st.nextToken().charAt(0);
                }
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (grid[r][c] == 'G') {
                        answerGrid[r][c] = 0;
                        continue;
                    } else {
                        for (int d = 0; d < dr.length; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N && grid[nr][nc] == 'G') {
                                answerGrid[r][c] = 2;
                                break;
                            }
                        }

                        if (answerGrid[r][c] == 0) {
                            int count = 0;
                                for (int j = 0; j < N; j++) {
                                    if (grid[j][c] == 'B') {
                                        count++;
                                    }
                                    if (grid[r][j] == 'B') {
                                        count++;
                                    }
                                }
                                count--;
                                answerGrid[r][c] = count;
                        }
                    }
                }
            }

            int max = Integer.MIN_VALUE;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    max = Math.max(max, answerGrid[j][k]);
                }
            }

            System.out.println("#" + i + " " + max);
        }
    }
}