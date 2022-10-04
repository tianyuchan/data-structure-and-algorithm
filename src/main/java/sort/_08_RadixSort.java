package sort;

import java.util.LinkedList;

/**
 * @Classname : _08_RadixSort
 * @Description : 基数排序
 * 平均时间复杂度：   O(N*logN)         受数据分布影响较小
 * 最好情况：        O(N*logN)
 * 最坏情况：        O(N*logN)
 * 空间复杂度：      >O(N) <O(k*N)
 * 排序方式：        外部排序
 * 稳定性：          稳定
 * 分析：
 *      基数排序主要是复制次数：2*N*⌊log r(N)⌋    （其中r是基数）
 *          数据关键字最大是 k 位数就需要循环 k 次，每次循环都需要 2*N 次复制，共 2*N*k：
 *              第一次是将全部数据项从数字数组复制到基数数组
 *              第二次是将全部数据项从基数数组复制到数字数组
 *          数据关键字最大位数 k 与数据项个数 N 之间的关系是 k = ⌊log r(N)⌋，即 2*N*⌊log r(N)⌋ ≈ O(N*logN)
 * @Author : chentianyu
 * @Date 2022/8/21 08:55
 */


public class _08_RadixSort extends SortUtils implements Sort {
    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        radixSort(nums, 3, 10);
    }

    /**
     * 基数排序
     * @param nums 数组
     * @param k 数字最大位数
     * @param r 基数
     */
    private void radixSort(int[] nums, int k, int r) {
        LinkedList<Integer>[] lists = new LinkedList[r];
        for (int i = 0; i < r; i++) {
            lists[i] = new LinkedList<>();
        }

        for (int i = 1; i <= k; i++) {
            // 第一次是将全部数据项从数字数组复制到基数数组
            for (int j = 0; j < nums.length; j++) {
                int index = (i == 1 ? nums[j] % r : (nums[j] / ((i - 1) * r)) % r);
                lists[index].addLast(nums[j]);
            }
            // 第二次是将全部数据项从基数数组复制到数字数组
            int n = 0;
            for (int j = 0; j < r; j++) {
                while (!lists[j].isEmpty()) {
                    nums[n++] = lists[j].removeFirst();
                }
            }
        }
    }  // end radixSort()
}
