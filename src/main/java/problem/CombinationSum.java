package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *   LeetCode - 39.Combination Sum (Medium)
 *   https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    static List<List<Integer>> answer = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        dfs(candidates, new ArrayList<>(), 0, 0, target);

        return answer;
    }

    private static void dfs(int[] candidates, List<Integer> arr, int start, int sum, int target) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            answer.add(new ArrayList<>(arr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            arr.add(candidates[i]);
            dfs(candidates, arr, i, sum + candidates[i], target);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
