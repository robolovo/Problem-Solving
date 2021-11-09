package wooah;

import java.util.*;

public class P04 {
    public static int[] solution(String s) {
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                index = i;
                break;
            }
        }

        String substring = s.substring(0, index);

        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            s = s.substring(index);
            s += substring;
        }

        List<Integer> sequenceNumArr = new ArrayList<>();
        int sequenceNum = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                sequenceNum += 1;
            } else {
                sequenceNumArr.add(sequenceNum);
                sequenceNum = 1;
            }
        }
        sequenceNumArr.add(sequenceNum);

        int[] result = sequenceNumArr.stream().mapToInt(i -> i).toArray();
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] aaabbaaas = solution("aaaaabaaaaavvc");
        for (int aaabbaaa : aaabbaaas) {
            System.out.print(aaabbaaa + " ");
        }
    }
}
