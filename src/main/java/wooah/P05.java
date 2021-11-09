package wooah;

public class P05 {
    public static int[][] solution(int rows, int columns) {
        int[][] table = new int[rows][columns];
        boolean[][] visited = new boolean[rows][columns];

        int limit = rows * columns;
        int count = 0;
        int sequence = 1, r = 0, c = 0;

        while (true) {
            table[r][c] = sequence;

            if (!visited[r][c]) {
                visited[r][c] = true;
                count += 1;
            }

            if (count == limit) {
                break;
            }

            boolean loopFlag = false;
            if (sequence % 2 == 0) {
                int pre = r;
                r += 1;
                if (r == rows) {
                    r = 0;
                    if (isInLoop(table[r][c], table[pre][c])) {
                        loopFlag = true;
                    }
                }
            } else {
                int pre = c;
                c += 1;
                if (c == columns) {
                    c = 0;
                    if (isInLoop(table[r][c], table[r][pre])) {
                        loopFlag = true;
                    }
                }
            }

            if (loopFlag) {
                break;
            }

            sequence++;
        }

        return table;
    }

    private static boolean isInLoop(int n1, int n2) {
        if (n1 == 0) {
            return false;
        }
        boolean b1 = n1 % 2 == 0;
        boolean b2 = n2 % 2 == 0;

        return b1 != b2;
    }

    public static void main(String[] args) {
        int[][] solution = solution(2, 2);
        for (int[] ints : solution) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
