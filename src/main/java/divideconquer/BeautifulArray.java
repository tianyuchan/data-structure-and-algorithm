package divideconquer;

import java.util.*;

/**
 * @Classname : BeautifulArray
 * @Description : 932. 漂亮数组
 * https://leetcode.cn/problems/beautiful-array/
 * @Author : chentianyu
 * @Date 2022/10/11 21:58
 */


public class BeautifulArray {
    Map<Integer, int[]> memorization = new HashMap<>();

    /**
     * 分治法 + memorization 优化
     *
     * 【漂亮数组】：
     * 对于某些固定的N，如果数组A是整数1, 2, ..., N组成的排列，使得：
     * 对于每个i < j，都不存在k 满足i < k < j使得A[k] * 2 = A[i] + A[j]。
     * 【使用结论】：
     * ① 仿射传递性：数组A是漂亮数组，则数组 kA + b 也是漂亮数组（k≠0）
     * ② 半奇半偶必漂亮：对于数组A中任意区间[i, j] 且 i < j，若左半区间都为奇数，右半区间都为偶数，则数组A是漂亮数组。
     * ③ n个数中，有 (n + 1) / 2 个奇数，有 n / 2 个偶数。
     *
     * @param n
     * @return
     */
    public int[] beautifulArray(int n) {
        if (memorization.containsKey(n)) return memorization.get(n);

        if (n == 1) {
            return new int[]{1};
        } else {
            int[] ans = new int[n];
            int t = 0;
            for (int left : beautifulArray((n + 1) / 2)) {
                ans[t++] = 2 * left - 1;
            }
            for (int right : beautifulArray(n / 2)) {
                ans[t++] = 2 * right;
            }
            return ans;
        }
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int[] beautifulArray2(int n) {
        List<int[]> dp = new ArrayList<>();
        // 从0开始，保证索引对应
        for (int i = 0; i <= n; i++) {
            dp.add(new int[i]);
        }
        dp.get(1)[0] = 1;

        for (int i = 2; i <= n; i++) {
            int t = 0;
            for (int left : dp.get((i + 1) / 2)) {
                dp.get(i)[t++] = 2 * left - 1;
            }
            for (int right : dp.get(i / 2)) {
                dp.get(i)[t++] = 2 * right;
            }
        }
        return dp.get(n);
    }
}
