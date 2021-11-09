package problem;

import java.util.*;

/*
*   프로그래머스 - 방문 길이
*   https://programmers.co.kr/learn/courses/30/lessons/49994
*/

public class VisitLength {
    public static int solution(String dirs) {
        Set<String> set = new HashSet<>();

        int cx = 5, cy = 5, count = 0;
        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int nx = cx, ny = cy;

            if (dir == 'U') {
                nx -= 1;
            } else if (dir == 'R') {
                ny += 1;
            } else if (dir == 'D') {
                nx += 1;
            } else if (dir == 'L') {
                ny -= 1;
            }

            if (nx >= 0 && ny >= 0 && nx <= 10 && ny <= 10) {
                String e1 = String.valueOf(cx) + cy + nx + ny;
                String e2 = String.valueOf(nx) + ny + cx + cy;
                if (!set.contains(e1) && !set.contains(e2)) {
                    set.add(e1);
                    set.add(e2);
                    count += 1;
                }
                cx = nx;
                cy = ny;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int sol1 = solution("LULLLLLLU");
        System.out.println("sol1 = " + sol1);
        int sol2 = solution("LLLLLLLRLLLL");
        System.out.println("sol2 = " + sol2);
        int sol3 = solution("ULURRDLLU");
        System.out.println("sol3 = " + sol3);
    }
}
