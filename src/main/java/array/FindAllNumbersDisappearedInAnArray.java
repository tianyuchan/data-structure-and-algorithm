package array;

import java.util.*;

/**
 * @Classname : FindAllNumbersDisappearedInAnArray
 * @Description : 448. 找到所有数组中消失的数字
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
 * @Author : chentianyu
 * @Date 2022/11/1 22:25
 */


public class FindAllNumbersDisappearedInAnArray {
    /**
     * 桶记录法 + 空间优化
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        // 将出现的数字标记在桶中适当位置
        // ① 以当前数组为桶
        // ② 数字num与桶中n-1位置对应
        // ③ 标记该位置有值的方法是将该位置数字加n
        int n = nums.length;
        for (int num : nums) {
            num = (num - 1) % n;
            nums[num] += n;
        }
        // 遍历记录未出现的数字
        // ① 未出现的数字的位置处一定小于等于n
        // ② 未出现数字等于小于等于n位置加1
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ans.add(i + 1);
            }
        }
        return ans;
    }


    /**
     * 桶记录法
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 将出现的数字放进桶中
        int n = nums.length;
        int[] bucket = new int[n + 1];
        for (int num : nums) {
            bucket[num]++;
        }
        // 遍历记录未出现的数字
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (bucket[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
