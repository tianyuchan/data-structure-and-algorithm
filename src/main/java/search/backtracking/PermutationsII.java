package search.backtracking;

import java.util.*;

/**
 * @Classname : PermutationsII
 * @Description : 47. 全排列 II
 * https://leetcode.cn/problems/permutations-ii/
 * @Author : chentianyu
 * @Date 2022/9/20 22:49
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        boolean[] bits = new boolean[nums.length];
        // 对数组排序，让相同的数字相邻
        Arrays.sort(nums);
        backTracking(ans, path, bits, nums, nums.length, 0);
        return ans;
    }

    private void backTracking(List<List<Integer>> ans, ArrayDeque<Integer> path, boolean[] bits, int[] nums, int n, int pos) {
        if (pos == n) {
            ans.add(new ArrayList<>(path));
        }

        for (int i = 0; i < n; i++) {
            // 若当前位置数字已经使用 或 (当前位置数字和前一位置数字一致 且 前一位置未被使用)，则直接遍历下一位置
            // 即上一位置相同数字未被使用便不可能使用当前位置数字
            if (bits[i] || (i > 0 && nums[i] == nums[i-1] && !bits[i-1])) continue;
            bits[i] = true;
            path.addLast(nums[i]);
            backTracking(ans, path, bits, nums, n, pos+1);
            bits[i] = false;
            path.removeLast();
        }
    }
}
