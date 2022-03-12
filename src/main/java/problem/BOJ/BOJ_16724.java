package problem.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16724 {

    static int N, M;
    static char[][] map;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        parents = new int[N * M];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                int curIdx = i * M + j;
//                int nextIdx = findIdx(i, j);
//                if (find(curIdx) != find(nextIdx)) {
//                    union(curIdx, nextIdx);
//                }
//            }
//        }
//
//        int answer = findSaveZone();
//        System.out.println(answer);
    }



//    static int rows;
//    static int cols;
//    static char[][] map;
//    static boolean[][] visit;
//    static int answer = 0;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        rows = Integer.parseInt(st.nextToken());
//        cols = Integer.parseInt(st.nextToken());
//        map = new char[rows][cols];
//        visit = new boolean[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            String line = br.readLine();
//            for (int j = 0; j < cols; j++) {
//                map[i][j] = line.charAt(j);
//            }
//        }
//
//
//
//    }

}
