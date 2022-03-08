package problem.BOJ;

import java.math.BigDecimal;
import java.util.*;

public class BOJ_20210 {

    static class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int n = Math.max(o1.length(), o2.length());
            for (int i = 0; i < n; i++) {
                if (o1.charAt(i) == o2.charAt(i)) {
                    continue;
                }

                if (isNumber(o1.charAt(i)) && isNumber(o2.charAt(i))) {
                    StringBuilder sb1 = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();

                    int index1 = i;
                    while (index1 < o1.length() && isNumber(o1.charAt(index1))) {
                        sb1.append(o1.charAt(index1));
                        index1++;
                    }

                    int index2 = i;
                    while (index2 < o2.length() && isNumber(o2.charAt(index2))) {
                        sb2.append(o2.charAt(index2));
                        index2++;
                    }

                    BigDecimal bigDecimal1 = new BigDecimal(sb1.toString());
                    BigDecimal bigDecimal2 = new BigDecimal(sb2.toString());

                    if (bigDecimal1.compareTo(bigDecimal2) == 0) {
                        return sb1.length() - sb2.length();
                    }

                    return bigDecimal1.compareTo(bigDecimal2);
                }

                if (isNumber(o1.charAt(i))) {
                    return -1;
                }

                if (isNumber(o2.charAt(i))) {
                    return 1;
                }

                if (String.valueOf(o1.charAt(i)).equalsIgnoreCase(String.valueOf(o2.charAt(i)))) {
                    return o1.charAt(i) - o2.charAt(i);
                } else {
                    return String.valueOf(o1.charAt(i)).toLowerCase().charAt(0) - String.valueOf(o2.charAt(i)).toLowerCase().charAt(0);
                }

            }
            return 0;
        }

        private boolean isNumber(char c) {
            return c == '1' || c == '2' || c == '3' || c == '4' || c == '5'
                    || c == '6' || c == '7' || c == '8' || c == '9' || c == '0';
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<String> li = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            li.add(sc.nextLine());
        }

        li.sort(new CustomComparator());

        for (String s : li) {
            System.out.println(s);
        }
    }

}
