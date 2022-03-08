package problem.BOJ;

import java.util.Scanner;

public class BOJ_19844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            String word = s.substring(i, i + 3);

            if (isWord(word)) {

            }
        }
    }

    static boolean isWord(String s) {
        return s.equals("ce'") || s.equals("je'") || s.equals("ne'") || s.equals("me'")
                || s.equals("te'") || s.equals("se'") || s.equals("le'") || s.equals("la'")
                || s.equals("de'") || s.equals("que'") || s.equals("si'");
    }
}

