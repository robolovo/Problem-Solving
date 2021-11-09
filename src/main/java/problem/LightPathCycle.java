package problem;

import java.util.ArrayList;
import java.util.List;

/*
*   프로그래머스 - 빛의 경로 사이클
*   https://programmers.co.kr/learn/courses/30/lessons/86052
*/

public class LightPathCycle {


    public static int[] solution(String[] grid) {
        int[] answer = {};

        List<List<Character>> graph = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                graph.get(i).add(grid[i].charAt(j));
            }
        }

        dfs(graph, new Node(0, 0), new Node(0, 0), 0);

        return answer;
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void dfs(List<List<Character>> graph, Node curr, Node prev, int direction) {



//        dfs(graph,);
    }

    public static void main(String[] args) {
        int[] solution = solution(new String[]{"SL", "LR"});
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
