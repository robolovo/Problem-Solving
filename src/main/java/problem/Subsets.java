package problem;

import java.util.ArrayList;
import java.util.List;

/*
 *   LeetCode - 78. Subsets (Medium)
 *   https://leetcode.com/problems/subsets/
 */
public class Subsets {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(new ArrayList<>(), nums, 0);
        return answer;
    }

    private void dfs(ArrayList<Integer> arr, int[] nums, int start) {
        answer.add(new ArrayList<>(arr));

        for (int i = start; i < nums.length; i++) {
            arr.add(nums[i]);
            dfs(arr, nums, i + 1);
            arr.remove(arr.size() - 1);
        }
    }
}
