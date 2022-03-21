package problem.BOJ;

import java.util.Scanner;

public class BOJ_20165 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int R = Integer.parseInt(s[2]);
        int[][] map = new int[N][M];
        int[][] tempMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] ss = sc.nextLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(ss[j]);
                tempMap[i][j] = Integer.parseInt(ss[j]);
            }
        }

        int standCount = 0;
        for (int i = 0; i < R * 2; i++) {
            if (i % 2 == 0) {
                String[] ss = sc.nextLine().split(" ");
                int x = Integer.parseInt(ss[0]);
                int y = Integer.parseInt(ss[1]);
                char d = ss[2].charAt(0);
                int currX = x - 1;
                int currY = y - 1;

                int dx = 0, dy = 0;
                if (d == 'N') dx -= 1;
                if (d == 'E') dy += 1;
                if (d == 'S') dx += 1;
                if (d == 'W') dy -= 1;

                int cnt = map[currX][currY] - 1;
                map[currX][currY] = -1;
                while (cnt > 0) {
                    currX += dx;
                    currY += dy;
                    if (!(currX >= 0 && currY >= 0 && currX < N && currY < M)) {
                        break;
                    }
                    cnt = Math.max(cnt, map[currX][currY]);
                    map[currX][currY] = -1;
                    cnt--;
                }
            } else {
                String[] ss = sc.nextLine().split(" ");
                int x = Integer.parseInt(ss[0]) - 1;
                int y = Integer.parseInt(ss[1]) - 1;

                if (map[x][y] < 0) {
                    standCount++;
                }
                map[x][y] = tempMap[x][y];
            }
        }

        int fallDownCount = 0;
        char[][] answer = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    answer[i][j] = 'S';
                } else {
                    fallDownCount++;
                    answer[i][j] = 'F';
                }
            }
        }

        System.out.println(fallDownCount + standCount);
        for (char[] chars : answer) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}
