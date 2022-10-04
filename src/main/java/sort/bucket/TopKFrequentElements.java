package sort.bucket;

import java.util.*;

/**
 * @Classname : TopKFrequentElements
 * @Description : 347. 前 K 个高频元素
 * https://leetcode.cn/problems/top-k-frequent-elements/
 * @Author : chentianyu
 * @Date 2022/10/4 23:05
 */


public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (int n : nums) {
            int temp = map.getOrDefault(n, 0) + 1;
            maxCount = Math.max(maxCount, temp);
            map.put(n, temp);
        }

        LinkedList<Integer>[] buckets = new LinkedList[maxCount + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (buckets[entry.getValue()] == null) {
                buckets[entry.getValue()] = new LinkedList<>();
            }
            buckets[entry.getValue()].addLast(entry.getKey());
        }

        int[] ans = new int[k];
        int a = 0;
        for (int i = maxCount; i > 0; i--) {
            while (buckets[i] != null && buckets[i].size() > 0) {
                ans[a++] = buckets[i].removeFirst();
                if (a == k) return ans;
            }
        }
        return ans;
    }
}
