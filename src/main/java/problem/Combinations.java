package problem;

import java.util.ArrayList;
import java.util.List;

/*
*   LeetCode - 77.Combinations (Medium)
*   https://leetcode.com/problems/combinations/
*/
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(answer, new ArrayList<>(), n, k, 1);
        return answer;
    }

    private void dfs(List<List<Integer>> answer, ArrayList<Integer> arr, int n, int k, int start) {
        if (arr.size() >= k) {
            answer.add(new ArrayList<>(arr));
            return;
        }

        for (int i = start; i <= n; i++) {
            arr.add(i);
            dfs(answer, arr, n, k, i + 1);
            arr.remove(arr.size() - 1);
        }
    }
}
