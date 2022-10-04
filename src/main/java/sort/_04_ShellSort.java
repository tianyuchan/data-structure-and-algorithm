package sort;

/**
 * @Classname : _04_ShellSort
 * @Description : 希尔排序
 * 时间复杂度：    O(N^(7/6) ~ N^(3/2))    受数据分布影响，理论上难分析，主要来自于试验评估
 * 空间复杂度：    O(1)                    不需要额外空间辅助
 * 排序方式：      内部排序
 * 稳定性：       不稳定（存在跳跃式交换）
 * 起因：
 *      初始时若一个比较小的数靠近序列的尾部，由于是一步一步的比较移动，因此使用插入排序会移动（或复制）很多次。
 *      解决：开始时先使用比较大的步子排序使序列“基本有序”，最后再使用插入排序——希尔排序
 * 间隔（步子）：
 *      选择：间隔序列中的数字互质很重要，可以使每一趟排序更有可能保持前一趟已排好的效果。
 *      常用：h = h*3 + 1
 * @Author : chentianyu
 * @Date 2022/8/17 22:41
 */

public class _04_ShellSort extends SortUtils implements Sort {
    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // 获取间隔队列
        int h = 1;
        while (h < nums.length / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            int in, out;
            for (out = h; out < nums.length; out++) {
                int temp = nums[out];
                in = out;
                while (in > h - 1 && nums[in - h] > temp) {
                    nums[in] = nums[in - h];
                    in -= h;
                }
                nums[in] = temp;
            }
            h = (h - 1) / 3;
        }
    }  // end sort()
}
