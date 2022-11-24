package prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname : SubarraySumEqualsK
 * @Description : 560. 和为 K 的子数组
 * https://leetcode.cn/problems/subarray-sum-equals-k/
 * ① 当前位置前缀和刚好等于k：+1
 * ② 当前位置前缀和减去之前位置前缀和等于k：+ 之前位置前缀和的个数
 * @Author : chentianyu
 * @Date 2022/11/25 00:14
 */


public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0, psum = 0;
        // 前缀和：数量
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int n : nums) {
            psum += n;
            count += map.getOrDefault(psum - k, 0);
            map.put(psum, map.getOrDefault(psum, 0) + 1);
        }
        return count;
    }


}
