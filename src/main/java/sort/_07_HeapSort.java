package sort;

import java.util.PriorityQueue;

/**
 * @Classname : _07_HeapSort
 * @Description : 堆排序
 * 平均时间复杂度：  O(N*logN)    受数据分布影响较小
 * 最好情况：       O(N*logN)
 * 最坏情况：       O(N*logN)
 * 空间复杂度：      O(N)         堆空间大小
 * 排序方式：       外部堆排序
 * 稳定性：         不稳定
 * @Author : chentianyu
 * @Date 2022/8/20 23:08
 */

public class _07_HeapSort extends SortUtils implements Sort {
    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // 默认最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = heap.remove();
        }
    }  // end sort()
}
