package problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*   LeetCode 207. Course Schedule (Medium)
*   https://leetcode.com/problems/course-schedule/
*/
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }

        boolean[] processed = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(graph, visited, processed, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(ArrayList<Integer>[] graph, boolean[] visited, boolean[] processed, int course) {
        if (processed[course]) {
            return false;
        }

        if (visited[course]) {
            return true;
        } else {
            visited[course] = true;
            for (int c : graph[course]) {
                if (dfs(graph, visited, processed, c)) {
                    return true;
                }
            }
            processed[course] = true;
            visited[course] = false;
            return false;
        }
    }

    public static void main(String[] args) {
        boolean canFinish = canFinish(3, new int[][]{{2, 1}, {1, 0}});
        System.out.println("canFinish = " + canFinish);
    }
}
