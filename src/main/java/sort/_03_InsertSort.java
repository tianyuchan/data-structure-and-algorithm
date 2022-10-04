package sort;

/**
 * @Classname : _03_InsertSort
 * @Description : 插入排序
 * @Author : chentianyu
 * 平均时间复杂度：  O(N^2)    数据随机分布    s = 比较次数 + 移动次数 + 移动到temp = N*(N-1)/4 + N*(N-1)/4 + N-1    算法从1到N-1共执行N轮；每轮首先将当前数据移动到temp，之后每次比较伴随一次移动；平均来说在中途遇到比较中止条件。
 * 最好情况：       O(N)      数据顺序分布    s = 比较次数 + 移动次数 + 移动到temp = N-1 + N-1 + N-1    算法从1到N-1共执行N轮；每轮首先将当前数据移动到temp，之后比较一次和移动一次；也就是第一次比较就遇到中止条件。
 * 最坏情况：       O(N^2)    数据逆序分布    s = 比较次数 + 移动次数 + 移动到temp = N*(N-1)/2 + N*(N-1)/2 + N-1    算法从1到N-1共执行N轮；每轮首先将当前数据移动到temp，之后每次比较伴随一次移动，直到数组头部；也就是比较完所有数据才中止。
 * 空间复杂度：     O(1)      不需要额外空间辅助
 * 排序方式：                 内部排序
 * 稳定性：                   稳定
 *
 * 优化点：
 * ① 寻找合适位置时，由于左边都是排好序的，可以使用二分法查找
 * @Date 2022/8/17 21:54
 */

public class _03_InsertSort extends SortUtils implements Sort {
    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int in, out;
        for (out = 1; out < nums.length; out++) {  // 从1开始，前面只有1个元素相当于排好序
            int temp = nums[out];  // 记录一下待处理值
            in = out;  // 当前坐标
            while (in > 0 && nums[in - 1] > temp) {  // in > 0 才会有前一坐标 in - 1
                nums[in] = nums[in - 1];
                in--;
            }
            nums[in] = temp;  // 最后把待处理值放到找到的合适的位置
        }
    }  // end sort()
}
