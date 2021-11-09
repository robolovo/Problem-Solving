package wooah;

public class P07 {
    public static String[] solution(String[] grid, boolean clockwise) {
        String[] answer = new String[grid.length];

        if (clockwise) {
            int start = 0;
            int index = 0;

            int N = grid.length;
            while (N > 0) {
                String layer = "";

                int last = grid.length - 1;
                for (int i = start; i >= 0; i--) {
                    if (i != start && i % 2 == 0) {
                        last -= 1;
                    }
                    layer += grid[last].charAt(i);
                }

                answer[index] = layer;
                start += 2;
                index += 1;
                N--;
            }
        }

        if (!clockwise) {
            int length = grid[grid.length - 1].length() - 1;
            int start = 0;
            int index = 0;

            int N = grid.length;
            while (N > 0) {
                String layer = "";

                int last = grid.length - 1;
                for (int i = start; i >= 0; i--) {
                    if (i % 2 != 0) {
                        last += 1;
                    }

                    if (i != start && length % 2 == 0) {
                        length += 1;
                    } else if (i != start && length % 2 != 0){
                        length -= 1;
                    }

                    layer += grid[last - index].charAt(length);
                }

                length -= 2;
                answer[index] = layer;
                start += 2;
                index += 1;
                N--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] solution = solution(new String[]{"1"}, true);
        for (String s : solution) {
            System.out.println(s);
        }
    }
}
