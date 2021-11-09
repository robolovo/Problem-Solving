package problem;

import java.util.ArrayList;
import java.util.List;

/*
*   LeetCode - 46.Permutations (Medium)
*   https://leetcode.com/problems/permutations/
*/
public class Permutations {
    boolean[] visited;
    List<List<Integer>> answer;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];

        answer = new ArrayList<>();
        dfs(nums, new ArrayList<>(), 0);

        return answer;
    }

    private void dfs(int[] nums, List<Integer> arr, int depth) {
        if (depth >= nums.length) {
            answer.add(new ArrayList<>(arr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr.add(nums[i]);
                dfs(nums, arr, depth + 1);
                arr.remove(arr.size() - 1);
                visited[i] = false;
            }
        }
    }
}
