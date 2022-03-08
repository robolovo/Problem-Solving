package problem.BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_16724 {

    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                calc(i, j);
            }
        }

    }

    public static void calc(int x, int y) {
        int startX = x;
        int startY = y;


        visited[x][y] = true;
        if (map[x][y] == 'U') {
            x -= 1;
        } else if (map[x][y] == 'D') {
            x += 1;
        } else if (map[x][y] == 'L') {
            y -= 1;
        } else {
            y += 1;
        }
    }

}
