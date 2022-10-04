package sort;

/**
 * @Classname : _01_BubbleSort
 * @Description : 冒泡排序
 * 平均时间复杂度：  O(N^2)    数据随机分布    s = 比较次数 + 交换次数 = N*(N-1)/2 + N*(N-1)/4    交换的次数平均来说是比较的一半
 * 最好情况：       O(N)      数据顺序分布    s = 比较次数 + 交换次数 = N + 0 = N
 * 最坏情况：       O(N^2)    数据逆序分布    s = 比较次数 + 交换次数 = N*(N-1)/2 + N*(N-1)/2    每次比较都需要交换
 * 空间复杂度：     O(1)      不需要额外空间辅助
 * 排序方式：                 内部排序（不借助外部数组）
 * 稳定性：                   稳定（不存在跳跃交换）
 *
 * 排序算法稳定性：是指排序之后，两个相同元素之间位置不会发生改变。在二次排序的时候比较重要。
 * @Author : chentianyu
 * @Date 2022/8/15 23:09
 */

public class _01_BubbleSort extends SortUtils implements Sort {

    @Override
    public void sort(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        boolean swapped;
        int in, out;
        for(out = nums.length-1; out > 0; out--) {  // >0 而不是 >=0，是因为只剩下最后一个数据项时，不用再遍历排序，它一定关键字最小
            swapped = false;
            for (in = 0; in < out; in++)  // out 位置处尚未排序
                if (nums[in] > nums[in + 1]) {  // 比较 > 保证了稳定性
                    swap(nums, in, in+1);
                    swapped = true;
                }
            if(!swapped) {
                return;
            }
        }
    }  // end sort()
}
