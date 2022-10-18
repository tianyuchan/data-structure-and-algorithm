package sort.algorithm;

/**
 * @Classname : _05_QuickSort
 * @Description : 快速排序
 * 时间复杂度：平均 O(N*logN)  最好 O(N*logN)  最坏 O(N^2)【每次都选择最小值或最大值】
 * 空间复杂度：O(logN) 【递归导致的】
 * 排序方式：内部排序
 * 稳定性：不稳定
 *
 * 优化点：
 * ① 每次不都是以最左边值为基准，而是随机选择一个值
 * ② 当区间变小后，换用简单排序算法
 * @Author : chentianyu
 * @Date 2022/8/18 22:55
 */

public class _05_QuickSort extends SortUtils implements Sort {
    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSort(nums, 0, nums.length);
    }

    private void quickSort(int[] nums, int l, int r) {
        // 左闭右开
        if (l + 1 >= r) {
            return;
        }
        int p = l, q = r - 1;
        while (true) {
            // 注意：左边num[l]为基准，必须从右边开始执行，从而保证停止位置的值一定小于等于num[l] ！！！
            // 若以左边num[l]为基准，从左边开始执行，停止的位置一定是大于等于num[l]的，若大于num[l]的值与num[l]交换，相当于把大的值放到左边，显然无法实现排序。
            while (p < q && nums[q] >= nums[l]) {
                q--;
            }
            while (p < q && nums[p] <= nums[l]) {
                p++;
            }
            if (p == q) {
                break;
            }
            swap(nums, p, q);
        }
        // 为nums[l]找到合适的位置p(或q)后交换
        swap(nums, p, l);

        quickSort(nums, l, p);
        quickSort(nums, p + 1, r);
    }  // end quickSort()
}
