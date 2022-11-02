package array;

/**
 * @Classname : MaxChunksToMakeSorted
 * @Description : 769. 最多能完成排序的块
 * https://leetcode.cn/problems/max-chunks-to-make-sorted/
 * @Author : chentianyu
 * @Date 2022/11/2 21:49
 */


public class MaxChunksToMakeSorted {
    /**
     * 从左往右遍历，同时记录当前的最大值，每当当前最大值等于数组位置时，我们可以多一次分割。
     *
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                chunks++;
            }
        }
        return chunks;
    }
}
