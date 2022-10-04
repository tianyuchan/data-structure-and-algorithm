package sort;

/**
 * @Classname : _02_SelectSort
 * @Description : 选择排序
 * 平均时间复杂度：   O(N^2)     受数据分布影响不大      s = 比较次数 + 交换次数 = N*(N-1)/2 + N-1
 * 最好情况：        O(N^2)
 * 最坏情况：        O(N^2)
 * 空间复杂度：      O(1)       不需要额外空间辅助
 * 排序方式：                   内部排序
 * 稳定性：                    不稳定（存在跳跃性交换，如 8 3 8 1，第一次交换的数据是1和头部的8，两个8原来的顺序被打乱）
 * @Author : chentianyu
 * @Date 2022/8/17 20:59
 */

public class _02_SelectSort extends SortUtils implements Sort {

    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int in, out, min;
        for (out = 0; out < nums.length; out++) {
            min = out;
            for (in = out + 1; in < nums.length; in++) {
                if (nums[in] < nums[min]) {
                    min = in;
                }
            }
            swap(nums, out, min);
        }
    } // end sort()
}
