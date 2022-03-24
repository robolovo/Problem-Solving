package problem.BOJ;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13460 {

    static class Marble {
        int rx, ry, bx, by, cnt;

        Marble(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }

    static int N, M;
    static char[][] map;
    static Marble red, blue;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        visited = new boolean[N][M][N][M];
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String ss = sc.nextLine();
            for (int j = 0; j < M; j++) {
                if (ss.charAt(j) == 'R') {
                    red = new Marble(i, j, 0, 0, 0);
                }

                if (ss.charAt(j) == 'B') {
                    blue = new Marble(0, 0, i, j, 0);
                }

                map[i][j] = ss.charAt(j);
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Marble> queue = new ArrayDeque<>();
        queue.add(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
        visited[red.rx][red.ry][blue.bx][blue.by] = true;

        while (!queue.isEmpty()) {
            Marble m = queue.poll();

            for (int i = 0; i < 4; i++) {
                boolean redHole = false;
                boolean blueHole = false;

                int currRx = m.rx;
                int currRy = m.ry;
                int currBx = m.bx;
                int currBy = m.by;
                int currCnt = m.cnt;

                while (map[currRx + dx[i]][currRy + dy[i]] != '#') {
                    currRx += dx[i];
                    currRy += dy[i];
                    if (map[currRx][currRy] == 'O') {
                        redHole = true;
                        break;
                    }
                }

                while (map[currBx + dx[i]][currBy + dy[i]] != '#') {
                    currBx += dx[i];
                    currBy += dy[i];
                    if (map[currBx][currBy] == 'O') {
                        blueHole = true;
                        break;
                    }
                }

                if (blueHole) continue;
                if (redHole && !blueHole) return currCnt;

                if (currRx == currBx && currRy == currBy) {
                    if (i == 0) {
                        if (m.rx < m.bx) currBx += 1;
                        else currRx += 1;
                    } else if (i == 1) {
                        if (m.ry < m.by) currRy -= 1;
                        else currBy -= 1;
                    } else if (i == 2) {
                        if (m.rx < m.bx) currRx -= 1;
                        else currBx -= 1;
                    } else {
                        if (m.ry < m.by) currBy += 1;
                        else currRy += 1;
                    }
                }

                if (!visited[currRx][currRy][currBx][currBy]) {
                    visited[currRx][currRy][currBx][currBy] = true;
                    queue.add(new Marble(currRx, currRy, currBx, currBy, currCnt + 1));
                }
            }
        }

        return -1;
    }

}
