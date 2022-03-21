package problem.BOJ;

import java.util.Scanner;

public class BOJ_20164 {

    static int firstOddCount = 0;
    static int min = Integer.MAX_VALUE;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();

        firstOddCount = getOddNumCount(N);
        dfs(N, firstOddCount);

        System.out.println(min + " " + max);
    }

    private static void dfs(String s, int oddCount) {
        if (s.length() == 1) {
            min = Math.min(min, oddCount);
            max = Math.max(max, oddCount);
            return;
        }

        if (s.length() == 2) {
            String ss = String.valueOf(Integer.parseInt(s.substring(0, 1)) + Integer.parseInt(s.substring(1, 2)));
            dfs(ss, oddCount + getOddNumCount(ss));
        }

        for (int i = 1; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int left = Integer.parseInt(s.substring(0, i));
                int mid = Integer.parseInt(s.substring(i, j));
                int right = Integer.parseInt(s.substring(j));
                String ss = String.valueOf(left + mid + right);

                dfs(ss, oddCount + getOddNumCount(ss));
            }
        }
    }

    private static int getOddNumCount(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) % 2 == 1) {
                count++;
            }
        }
        return count;
    }

}
