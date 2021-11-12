package problem;

import java.util.*;

/*
 *   LeetCode - 743. Network Delay Time (Medium)
 *   https://leetcode.com/problems/network-delay-time/
 */
public class NetworkDelayTime {
    static class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    int[] distance;
    List<List<Node>> graph = new ArrayList<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int a = time[0], b = time[1], d = time[2];
            graph.get(a).add(new Node(b, d));
        }

        dijkstra(k);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, distance[i]);
        }

        if (answer == Integer.MAX_VALUE) {
            return -1;
        }

        return answer;
    }

    private void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);

        pq.offer(new Node(start, 0));
        distance[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curr = node.index;
            int dist = node.distance;

            if (distance[curr] < dist) {
                continue;
            }

            for (int i = 0; i < graph.get(curr).size(); i++) {
                int d = distance[curr] + graph.get(curr).get(i).distance;

                if (d < distance[graph.get(curr).get(i).index]) {
                    distance[graph.get(curr).get(i).index] = d;
                    pq.offer(new Node(graph.get(curr).get(i).index, d));
                }
            }
        }
    }

}
