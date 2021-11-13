package problem;

import java.util.*;

/*
 *   LeetCode - 787. Cheapest Flights Within K Stops (Medium)
 *   https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class CheapestFlightsWithinKStops {
    class Node {
        int index;
        int cost;
        int k;

        public Node(int index, int cost, int k) {
            this.index = index;
            this.cost = cost;
            this.k = k;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] costArr = new int[n];
        Arrays.fill(costArr, Integer.MAX_VALUE);

        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int a = flight[0], b = flight[1], c = flight[2];
            graph.get(a).add(new Node(b, c, 0));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Node(src, 0, 0));
        costArr[src] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curr = node.index;
            int cost = node.cost;
            int _k = node.k;

            if (_k > k) {
                continue;
            }

            if (costArr[curr] < cost) {
                continue;
            }

            for (int i = 0; i < graph.get(curr).size(); i++) {
                int _cost = costArr[curr] + graph.get(curr).get(i).cost;

                if (_cost < costArr[graph.get(curr).get(i).index]) {
                    costArr[graph.get(curr).get(i).index] = _cost;
                    pq.offer(new Node(graph.get(curr).get(i).index, _cost, graph.get(curr).get(i).k + 1));
                }
            }
        }

        for (int i : costArr) {
            System.out.println("i = " + i);
        }

        return costArr[dst];
    }
}
