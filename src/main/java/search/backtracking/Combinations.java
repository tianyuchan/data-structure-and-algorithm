package search.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname : Combinations
 * @Description : 77. 组合
 * https://leetcode.cn/problems/combinations/
 * @Author : chentianyu
 * @Date 2022/8/28 01:30
 */


public class Combinations {

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> ans = combinations.combine(4, 2);
        System.out.println(ans.toString());  // [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
    }  // end main()


    // 【77. 组合】对n个数进行k的组合
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        return combine(nums, k);
    }  // end combine()


    // 对数组nums进行k的组合
    public List<List<Integer>> combine(int[] nums, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] comb = new int[k];
        backTracking(nums, k, comb, 0, 0, ans);
        return ans;
    }  // end combine()


    private void backTracking(int[] nums, int k, int[] comb, int count, int pos, List<List<Integer>> ans) {
        if (count == k) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                list.add(comb[i]);
            }
            ans.add(list);
            return;
        }

        int left = k - (count + 1);  // 还需要 left 个数字才能构成一个组合
        // 如果 i >= nums.length - left，则后续可使用的数字少于 left，即后续递归一定无法构成一个组合
        for (int i = pos; i < nums.length - left; i++) {
            comb[count++] = nums[i];
            backTracking(nums, k, comb, count, i + 1, ans);
            count--;
        }
    }  // end backTracking()
}  // end class
