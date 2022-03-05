package problem.BOJ;

import java.util.*;

public class BOJ_13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] d = sc.nextLine().split(" ");
        String[] c = sc.nextLine().split(" ");

        long[] dist = new long[N - 1];
        long[] cost = new long[N];

        for (int i = 0; i < N - 1; i++) {
            dist[i] = Long.parseLong(d[i]);
        }

        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(c[i]);
        }

        long sum = 0;
        for (int i = 0; i < dist.length; i++) {
            long curr = cost[i];
            int move = i + 1;
            long dd = dist[i];
            while (move < dist.length && curr < cost[move]) {
                dd += dist[move];
                move++;
            }

            sum += curr * dd;
            i = move - 1;
        }

        System.out.println(sum);
    }
}

//6
//4 2 3 5 2
//3 5 2 4 6 7
