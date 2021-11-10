package problem;

import java.util.*;

/*
 *   LeetCode - 332. Reconstruct Itinerary (Hard)
 *   https://leetcode.com/problems/reconstruct-itinerary/
 */
public class ReconstructItinerary {
    List<String> answer = new ArrayList<>();
    Map<String, PriorityQueue<String>> graph = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dest = ticket.get(1);

            PriorityQueue<String> pq = graph.getOrDefault(src, new PriorityQueue<>());
            pq.add(dest);
            graph.put(src, pq);
        }

        String startFrom = "JFK";
        dfs(startFrom);

        return answer;
    }

    private void dfs(String curr) {
        PriorityQueue<String> pq = graph.get(curr);

        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }

        answer.add(0, curr);
    }

}
