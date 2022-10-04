package search.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname : Permutations
 * @Description : 46. 全排列
 * https://leetcode.cn/problems/permutations/
 * @Author : chentianyu
 * @Date 2022/8/27 22:03
 */


public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1, 2, 3};
        // 全排列
        List<List<Integer>> ans = permutations.permute(nums);
        System.out.println(ans.toString());  // [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
        // k排列
        int k = 2;
        List<List<Integer>> ans2 = permutations.permute(nums, k);
        System.out.println(ans2.toString());  // [[1, 2], [1, 3], [2, 1], [2, 3], [3, 2], [3, 1]]
    }  // end main()


    // 对数组nums中的元素进行k的排列
    public List<List<Integer>> permute(int[] nums, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(nums, k,0, ans);
        return ans;
    }  // end permute()


    // 【46. 全排列】对数组nums中的元素全排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(nums, nums.length, 0, ans);
        return ans;
    }  // end permute()


    private void backTracking(int[] nums, int k, int pos, List<List<Integer>> ans) {
        if (pos == k) {
            // 到达目标位置，需要将当前排列记录
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                list.add(nums[i]);
            }
            ans.add(list);
            return;
        }

        // 从当前位置继续递归排列，令当前位置元素与包括当前位置元素在内的后续全部元素分别进行一次交换
        for (int i = pos; i < nums.length; i++) {
            swap(nums, pos, i);
            backTracking(nums, k,pos + 1, ans);
            swap(nums, pos, i);
        }
    }  // end backTracking()


    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }  // end swap()
}  // end class
