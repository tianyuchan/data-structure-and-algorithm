package sort.algorithm;

/**
 * @Classname : _06_MergeSort
 * @Description : 归并排序
 * 时间复杂度：平均、最好、最坏  O(N*logN)
 * 空间复杂度：O(N) 【使用辅助空间】
 * 排序方式：外部排序
 * 稳定性：稳定
 * @Author : chentianyu
 * @Date 2022/8/20 22:40
 */

public class _06_MergeSort extends SortUtils implements Sort {
    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        mergeSort(nums, 0, nums.length, new int[nums.length]);
    }

    private void mergeSort(int[] nums, int l, int r, int[] temp) {
        if (l + 1 >= r) {
            return;
        }

        int m = l + (r - l) / 2;
        mergeSort(nums, l, m, temp);
        mergeSort(nums, m, r, temp);

        // 将两个有序数组有序合并到temp数组
        int p = l, q = m, i = l;
        while (p < m || q < r) {
            if (q >= r || (p < m && nums[p] <= nums[q])) {
                temp[i++] = nums[p++];
            } else {
                temp[i++] = nums[q++];
            }
        }
        // 将temp中合并的数组移到nums数组
        for (i = l; i < r; i++) {
            nums[i] = temp[i];
        }
    }  // end mergeSort()
}
