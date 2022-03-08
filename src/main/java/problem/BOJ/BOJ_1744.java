package problem.BOJ;

import java.util.*;

public class BOJ_1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        boolean zero = false;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(sc.nextLine());
            if (num > 0) {
                positives.add(num);
            } else if (num < 0) {
                negatives.add(num);
            } else {
                zero = true;
            }
        }

        positives.sort((o1, o2) -> o2 - o1);
        negatives.sort(Comparator.comparingInt(o -> o));

        int answer = 0;

        for (int i = 1; i < positives.size(); i += 2) {
            if (positives.get(i - 1).equals(1) || positives.get(i).equals(1)) {
                answer += positives.get(i - 1) + positives.get(i);
            } else {
                answer += positives.get(i - 1) * positives.get(i);
            }
        }

        if (positives.size() % 2 == 1) {
            answer += positives.get(positives.size() - 1);
        }

        for (int i = 1; i < negatives.size(); i += 2) {
            answer += negatives.get(i - 1) * negatives.get(i);
        }

        if (negatives.size() % 2 == 1) {
            if (!zero) {
                answer += negatives.get(negatives.size() - 1);
            }
        }

        System.out.println(answer);
    }
}
