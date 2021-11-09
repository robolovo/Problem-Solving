package wooah;

import java.util.*;

public class P01 {
    public static int[] solution(int[] arr) {
        int[] answer = new int[3];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                int value = map.get(i);
                map.put(i, value + 1);
            }
        }

        int max = 0;
        for (int i = 1; i <= 3; i++) {
            if (map.containsKey(i)) {
                max = Math.max(max, map.get(i));
            }
        }

        for (int i = 1; i <= 3; i++) {
            if (!map.containsKey(i)) {
                answer[i - 1] = max;
                continue;
            }
            if (max > map.get(i)) {
                answer[i - 1] = max - map.get(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] solution = solution(new int[]{2, 1, 3, 1, 2, 1});
        for (int i : solution) {
            System.out.print(i + " ");
        }
        int[] solution1 = solution(new int[]{3,3,3,3,3,3});
        for (int i : solution1) {
            System.out.print(i + " ");
        }
    }
}
