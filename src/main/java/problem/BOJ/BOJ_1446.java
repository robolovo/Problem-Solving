package problem.BOJ;

import java.util.*;

public class BOJ_1446 {

    static class ShortCut {
        int start, end, length;

        public ShortCut(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] split = sc.nextLine().trim().split(" ");
        int N = Integer.parseInt(split[0]);
        int D = Integer.parseInt(split[1]);

        List<ShortCut> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] s = sc.nextLine().trim().split(" ");

            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int length = Integer.parseInt(s[2]);

            if (end > D) {
                continue;
            }

            if (end - start <= length) {
                continue;
            }

            list.add(new ShortCut(start, end, length));
        }

        list.sort(new Comparator<ShortCut>() {
            @Override
            public int compare(ShortCut o1, ShortCut o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });

        int index = 0;
        int curr = 0;
        int[] dist = new int[10001];
        Arrays.fill(dist, 10001);
        dist[0] = 0;

        while (curr < D) {
            if (index < list.size()) {
                ShortCut shortCut = list.get(index);
                if (curr == shortCut.start) {
                    dist[shortCut.end] = Math.min(dist[curr] + shortCut.length, dist[shortCut.end]);
                    index++;
                } else {
                    dist[curr + 1] = Math.min(dist[curr + 1], dist[curr] + 1);
                    curr++;
                }
            } else {
                dist[curr + 1] = Math.min(dist[curr + 1], dist[curr] + 1);
                curr++;
            }
        }

        System.out.println(dist[D]);
    }
}
