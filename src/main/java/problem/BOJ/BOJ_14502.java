package problem.BOJ;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_14502 {

    static class Virus {
        int r, c;

        public Virus(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N;
    static int M;

    static int[][] map;
    static int maxSafeZone;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] inputs = sc.nextLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        dfs(0);

        System.out.println(maxSafeZone);
    }

    static void dfs(int depth) {
        if (depth == 3) {
            // 바이러스 퍼트린 후 확인
            // 최대 안전영역
            bfs();
            return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        int[][] virusMap = new int[N][M];
        Deque<Virus> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virusMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusMap[i][j] == 2) {
                    deque.add(new Virus(i, j));
                }
            }
        }

        while (!deque.isEmpty()) {
            Virus v = deque.poll();

            for (int i = 0; i < 4; i++) {
                int nr = v.r + dr[i];
                int nc = v.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (virusMap[nr][nc] == 0) {
                        virusMap[nr][nc] = 2;
                        deque.add(new Virus(nr, nc));
                    }
                }
            }
        }

        setMaxSafeZone(virusMap);
    }

    static void setMaxSafeZone(int[][] map) {
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        maxSafeZone = Math.max(maxSafeZone, count);
    }
}
