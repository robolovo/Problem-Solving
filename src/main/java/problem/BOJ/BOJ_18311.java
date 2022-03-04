package problem.BOJ;

import java.util.Scanner;

public class BOJ_18311 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] N_K = sc.nextLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        long K = Long.parseLong(N_K[1]);

        int[] dist = new int[N];
        String[] nums = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            dist[i] = Integer.parseInt(nums[i]);
        }

        boolean finished = false;

        for (int i = 0; i < N; i++) {
            K -= dist[i];

            if (K <= 0) {
                System.out.println(i + 1);
                finished = true;
                break;
            }
        }

        if (!finished) {
            for (int i = N - 1; i >= 0; i--) {
                K -= dist[i];

                if (K <= 0) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }
}
