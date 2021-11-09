package problem;

/*
*   프로그래머스 - 행렬 테두리 회전하기
*   https://programmers.co.kr/learn/courses/30/lessons/77485
*/

public class RotatingMatrix {
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows + 1][columns + 1];

        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                matrix[i][j] = num++;
            }
        }

        int index = 0;
        for (int[] query : queries) {
            int x = query[0], y = query[1], xx = query[2], yy = query[3];
            int temp = matrix[x][yy];
            int minNum = temp;

            for (int i = yy; i > y; i--) {
                matrix[x][i] = matrix[x][i - 1];
                minNum = Math.min(minNum, matrix[x][i]);
            }
            for (int i = x; i < xx; i++) {
                matrix[i][y] = matrix[i + 1][y];
                minNum = Math.min(minNum, matrix[i][y]);
            }
            for (int i = y; i < yy; i++) {
                matrix[xx][i] = matrix[xx][i + 1];
                minNum = Math.min(minNum, matrix[xx][i]);
            }
            for (int i = xx; i > x; i--) {
                matrix[i][yy] = matrix[i - 1][yy];
                minNum = Math.min(minNum, matrix[i][yy]);
            }
            matrix[x + 1][yy] = temp;
            answer[index] = minNum;
            index++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] solution1 = solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
        for (int i : solution1) {
            System.out.print(i + " ");
        }
        int[] solution2 = solution(100, 97, new int[][]{{1, 1, 100, 97}});
        for (int i : solution2) {
            System.out.print(i + " ");
        }
        int[] solution3 = solution(5, 6, new int[][]{{1, 1, 5, 6}});
        for (int i : solution3) {
            System.out.print(i + " ");
        }
    }
}
