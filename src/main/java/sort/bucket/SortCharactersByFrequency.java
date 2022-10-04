package sort.bucket;

import java.util.*;

/**
 * @Classname : SortCharactersByFrequency
 * @Description : 451. 根据字符出现频率排序
 * https://leetcode.cn/problems/sort-characters-by-frequency/
 * @Author : chentianyu
 * @Date 2022/10/4 23:06
 */


public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            int n = map.getOrDefault(s.charAt(i), 0) + 1;
            maxCount = Math.max(maxCount, n);
            map.put(s.charAt(i), n);
        }

        LinkedList<Character>[] buckets = new LinkedList[maxCount + 1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int n = entry.getValue();
            char c = entry.getKey();
            if (buckets[n] == null) {
                buckets[n] = new LinkedList<>();
            }
            buckets[n].addLast(c);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = maxCount; i > 0; i--) {
            while (buckets[i] != null && buckets[i].size() > 0) {
                char c = buckets[i].removeFirst();
                for (int j = 0; j < i; j++) {
                    ans.append(c);
                }
            }
        }
        return ans.toString();
    }
}
