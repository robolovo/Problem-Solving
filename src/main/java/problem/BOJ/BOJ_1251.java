package problem.BOJ;

import java.util.Scanner;

public class BOJ_1251 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();

        StringBuilder min = new StringBuilder();
        min.append("z".repeat(50));
        StringBuilder temp;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() - 1; j++) {
                temp = new StringBuilder();
                temp.append(new StringBuilder(s.substring(0, i + 1)).reverse());
                temp.append(new StringBuilder(s.substring(i + 1, j + 1)).reverse());
                temp.append(new StringBuilder(s.substring(j + 1)).reverse());

                if (min.compareTo(temp) >= 0) {
                    min = new StringBuilder().append(temp);
                }
            }
        }

        System.out.println(min);
    }
}

