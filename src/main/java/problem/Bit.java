package problem;

import java.util.ArrayList;
import java.util.List;

public class Bit {

    public static long[] solution(long[] numbers) {
        List<Long> answer = new ArrayList<>();

        for (long number : numbers) {
            String result = Long.toBinaryString(number);
            String bin = String.format("%64s", result).replaceAll(" ", "0");

            for (int i = bin.length() - 1; i >= 1; i--) {
                if (i == bin.length() - 1 && bin.charAt(i) == '0') {
                    answer.add(number + 1);
                    break;
                }

                if (bin.charAt(i) == '1' && bin.charAt(i - 1) == '0') {
                    double num = number - Math.pow(2, 64 - (i + 1)) + Math.pow(2, 64 - i);
                    answer.add((long) num);
                    break;
                }
            }
        }

        return answer.stream().mapToLong(l -> l).toArray();
    }

    public static void main(String[] args) {
        long[] solution = solution(new long[]{121321478, 323});

        for (long l : solution) {
            System.out.println("l = " + l);
        }
    }
}
