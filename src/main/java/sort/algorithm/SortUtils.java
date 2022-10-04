package sort.algorithm;

/**
 * @Classname : AbstractSort
 * @Description :
 * @Author : chentianyu
 * @Date 2022/8/15 23:04
 */
public class SortUtils {

    protected void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
