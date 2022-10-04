package search.backtracking;

import java.util.*;

/**
 * @Classname : CombinationSumII
 * @Description : 40. 组合总和 II
 * https://leetcode.cn/problems/combination-sum-ii/
 * @Author : chentianyu
 * @Date 2022/9/20 23:30
 */


public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        boolean[] bits = new boolean[candidates.length];
        Arrays.sort(candidates);
        backTracking(ans, path, bits, candidates, candidates.length, 0, 0, target);
        return ans;
    }

    private void backTracking(List<List<Integer>> ans, ArrayDeque<Integer> path, boolean[] bits, int[] candidates, int n, int pos, int sum, int target) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = pos; i < n; i++) {
            // 上一位置与当前位置数字相同 且 上一位置数字未被使用，则当前位置数字不可使用。从而保证相同数字在当前位置只能使用一次
            if (i > 0 && candidates[i] == candidates[i-1] && !bits[i-1]) continue;
            bits[i] = true;
            path.addLast(candidates[i]);
            sum += candidates[i];
            backTracking(ans, path, bits, candidates, n, i+1, sum, target);
            bits[i] = false;
            path.removeLast();
            sum -= candidates[i];
            // 若当前求和已经大于等于目标值，由于数组升序，无需进行后续遍历
            if (sum + candidates[i] >= target) break;
        }
    }
}
