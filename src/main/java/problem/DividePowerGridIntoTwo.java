package problem;

/*
*   프로그래머스 - 전력망을 둘로 나누기
*   https://programmers.co.kr/learn/courses/30/lessons/86971
*/

import java.util.*;

public class DividePowerGridIntoTwo {
    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int di = 0;
        while (di < n) {
            List<int[]> list = new ArrayList<>();

            for (int i = 0; i < wires.length; i++) {
                if (i == di) continue;
                int a = wires[i][0], b = wires[i][1];
                list.add(new int[]{a, b});
                list.add(new int[]{b, a});
            }

            for (int i = 0; i < list.size(); i += 2) {
                int count = traverseAndCount(list, i);
                answer = Math.min(answer, Math.abs(n - 2 * count));
            }
            di++;
        }

        return answer;
    }

    private static int traverseAndCount(List<int[]> list, int start) {
        Stack<int[]> stack = new Stack<>();

        int count = 0;
        stack.push(list.get(start));
        while (!stack.isEmpty()) {
            int[] e = stack.pop();
            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                if (e[1] == list.get(i)[0]) {
                    stack.push(list.get(i));
                    list.remove(list.get(i));
                    flag = true;
                    i--;
                }
            }
            if (flag) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int solution1 = solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});
        System.out.println("solution1 = " + solution1);
        int solution2 = solution(2, new int[][]{{1, 3}});
        System.out.println("solution2 = " + solution2);
        int solution3 = solution(5, new int[][]{{1, 2}, {1, 3}, {1, 4}, {1, 5}});
        System.out.println("solution3 = " + solution3);
    }
}
