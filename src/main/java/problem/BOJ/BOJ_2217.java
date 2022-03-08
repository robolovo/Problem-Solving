package problem.BOJ;

import java.util.*;

public class BOJ_2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        List<Integer> w = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            w.add(Integer.parseInt(sc.nextLine()));
        }

        Collections.sort(w);

        int min = w.get(0) * N;
        for (int i = 1; i < N; i++) {
            if (w.get(i) * (N - i) > min) {
                min = w.get(i) * (N - i);
            }
        }

        System.out.println(min);
    }
}
