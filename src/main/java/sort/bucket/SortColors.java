package sort.bucket;

/**
 * @Classname : SortColors
 * @Description : 75. 颜色分类
 * https://leetcode.cn/problems/sort-colors/
 * @Author : chentianyu
 * @Date 2022/10/4 23:07
 */


public class SortColors {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }

        int n = 0;
        for (int i = 0; i < 3; i++) {
            while (counts[i] > 0) {
                nums[n++] = i;
                counts[i]--;
            }
        }
    }
}
