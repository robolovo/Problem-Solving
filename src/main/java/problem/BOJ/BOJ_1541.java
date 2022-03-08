package problem.BOJ;

import java.util.*;

public class BOJ_1541 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split("-");

        List<Integer> temp = new ArrayList<>();
        for (String value : s) {
            String[] split = value.split("[+]");

            int sum = 0;
            for (String s1 : split) {
                sum += Integer.parseInt(s1);
            }

            temp.add(sum);
        }

        int answer = temp.get(0);
        for (int i = 1; i < temp.size(); i++) {
            answer -= temp.get(i);
        }

        System.out.println(answer);
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//
//        String[] splitOps = s.split("[^+-]");
//        String[] nums = s.split("[^0-9]");
//
//        List<String> ops = new ArrayList<>();
//        for (String op : splitOps) {
//            if (!op.equals("")) {
//                ops.add(op);
//            }
//        }
//
//        Deque<String> deque = new ArrayDeque<>();
//        deque.add(nums[0]);
//
//        for (int i = 1; i < nums.length; i++) {
//            if (ops.get(i - 1).equals("+")) {
//                int n = Integer.parseInt(deque.pollLast()) + Integer.parseInt(nums[i]);
//                deque.add(String.valueOf(n));
//            } else {
//                deque.add(ops.get(i - 1));
//                deque.add(nums[i]);
//            }
//        }
//
//        Stack<String> stack = new Stack<>();
//        while (!deque.isEmpty()) {
//            String peek = deque.poll();
//            if (stack.isEmpty()) {
//                stack.add(peek);
//            } else if (peek.equals("-")) {
//                int n = Integer.parseInt(stack.pop()) - Integer.parseInt(deque.poll());
//                stack.add(String.valueOf(n));
//            } else {
//                stack.add(peek);
//            }
//        }
//
//        System.out.println(Integer.parseInt(stack.pop()));
//    }

}
