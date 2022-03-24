package problem.BOJ;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ_20166 {

    static int N, M, K;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static char[][] map;
    static HashMap<String, Integer> freq = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String ss = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = ss.charAt(j);
            }
        }

        String[] words = new String[K];
        for (int i = 0; i < K; i++) {
            words[i] = sc.nextLine();
        }

        for (int i = 1; i <= 5; i++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    dfs(i, new StringBuilder().append(map[x][y]), x, y);
                }
            }
        }

        for (String word : words) {
            if (!freq.containsKey(word)) {
                System.out.println(0);
            } else {
                System.out.println(freq.get(word));
            }
        }

    }

    private static void dfs(int limit, StringBuilder curr, int x, int y ) {
        if (curr.length() == limit) {
            if (freq.containsKey(curr.toString())) {
                freq.put(curr.toString(), freq.get(curr.toString()) + 1);
            } else {
                freq.put(curr.toString(), 1);
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0) {
                nx = N - 1;
            } else if (nx >= N) {
                nx = 0;
            }

            if (ny < 0) {
                ny = M - 1;
            } else if (ny >= M) {
                ny = 0;
            }

            dfs(limit, curr.append(map[nx][ny]), nx, ny);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
