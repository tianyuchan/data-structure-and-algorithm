package multiset;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname : DegreeOfAnArray
 * @Description : 697. 数组的度
 * https://leetcode.cn/problems/degree-of-an-array/
 * @Author : chentianyu
 * @Date 2022/11/30 00:17
 */


public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (map.containsKey(cur)) {
                int[] arr = map.get(cur);
                // arr[0] 第一次熟悉位置
                arr[1] = i; // 更新最后出现的位置
                arr[2] = i - arr[0] + 1;  // 更新距离
                arr[3]++;  // 更新出现个数
            } else {
                map.put(cur, new int[]{i, i, 1, 1});
            }
        }

        int maxNum = 0, minLen = nums.length;
        for (Integer key : map.keySet()) {
            int[] arr = map.get(key);
            // 更新：出现频数大的 或是 频数相同但距离更小的
            if (arr[3] > maxNum || (arr[3] == maxNum && arr[2] < minLen)) {
                maxNum = arr[3];
                minLen = arr[2];
            }
        }
        return minLen;
    }
}  // end class
