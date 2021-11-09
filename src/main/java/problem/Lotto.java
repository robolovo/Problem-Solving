package problem;

import java.util.HashMap;
import java.util.Map;

public class Lotto {
    public static int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(6, 1);
        map.put(5, 2);
        map.put(4, 3);
        map.put(3, 4);
        map.put(2, 5);
        map.put(0 ,6);

        int n = 0;
        int zeroNum = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroNum++;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lotto == win_nums[j]) {
                    n++;
                    win_nums[j] = 9999;
                }
            }
        }

        int max = map.get(n + zeroNum);
        if (n <= 1) {
            n = 0;
        }
        int min = map.get(n);

        return new int[] {max, min};
    }

    public static void main(String[] args) {
        int[] solution = solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{31, 10, 45, 1, 6, 19});

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
