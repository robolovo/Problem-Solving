package problem;

import java.util.*;

/*
*   프로그래머스 - 피로도
*   https://programmers.co.kr/learn/courses/30/lessons/87946
*/

public class Fatigue {
    public static int solution(int k, int[][] dungeons) {
        int answer = -1;

        Arrays.sort(dungeons, (n1, n2) -> n2[0] - n1[0]);
        List<int[]> list1 = new ArrayList<>(Arrays.asList(dungeons));
        Arrays.sort(dungeons, (n1, n2) -> n1[1] - n2[1]);
        List<int[]> list2 = new ArrayList<>(Arrays.asList(dungeons));

        for (int i = 0; i < list2.size(); i++) {
            int l1 = list2.get(i)[1];

            int rest = k- l1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80, 20}, {30, 10}, {50, 40}}));
    }
}
