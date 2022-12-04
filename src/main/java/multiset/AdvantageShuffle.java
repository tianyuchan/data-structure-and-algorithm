package multiset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Classname : AdvantageShuffle
 * @Description : 870. 优势洗牌
 * https://leetcode.cn/problems/advantage-shuffle/
 * @Author : chentianyu
 * @Date 2022/12/2 23:23
 */

// test fetch
public class AdvantageShuffle {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // 将两数组复制并排序
        int n = nums1.length;
        int[] sorted1 = nums1.clone();
        Arrays.sort(sorted1);
        int[] sorted2 = nums2.clone();
        Arrays.sort(sorted2);
        // 创建map，以nums2中每个元素为key，以nums1中大于key的元素为value
        // 由于nums2中可能有重复元素，所以value用列表存储
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int v2 : sorted2) map.put(v2, new LinkedList<>());
        // 创建列表记录nums1中没有放在map中的元素
        LinkedList<Integer> remain = new LinkedList<>();

        int i = 0;
        for (int v1 : sorted1) {
            if (v1 > sorted2[i]) map.get(sorted2[i++]).addLast(v1);
            else remain.addLast(v1);
        }

        int[] ans = new int[n];
        int j = 0;
        for (int v2 : nums2) {
            if (map.get(v2).isEmpty()) {
                ans[j++] = remain.removeLast();
            } else {
                ans[j++] = map.get(v2).removeLast();
            }
        }
        return ans;
    }
}
