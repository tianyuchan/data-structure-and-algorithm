package sort;

/**
 * @Classname : TestSort
 * @Description : 测试排序算法
 * @Author : chentianyu
 * @Date 2022/8/15 23:24
 */

public class TestSort {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println("【冒泡排序】");
        TestSort.testSort(new _01_BubbleSort());
        System.out.println("【选择排序】");
        TestSort.testSort(new _02_SelectSort());
        System.out.println("【插入排序】");
        TestSort.testSort(new _03_InsertSort());
        System.out.println("【希尔排序】");
        TestSort.testSort(new _04_ShellSort());
        System.out.println("【快速排序】");
        TestSort.testSort(new _05_QuickSort());
        System.out.println("【归并排序】");
        TestSort.testSort(new _06_MergeSort());
        System.out.println("【堆排序】");
        TestSort.testSort(new _07_HeapSort());
        System.out.println("【基数排序】");
        TestSort.testSort(new _08_RadixSort());

        long end = System.currentTimeMillis();
        System.out.println("time: " + (end-start) + "ms");
    }

    public static void testSort(Sort sort){
        // 特殊值测试
        int[] nums1 = null;
        int[] expect1 = null;
        test("test1", sort, nums1, expect1);

        int[] nums2 = {};
        int[] expect2 = null;
        test("test2", sort, nums2, expect2);

        // 边界值测试
        int[] nums3 = {1};
        int[] expect3 = {1};
        test("test3",sort,nums3,expect3);

        // 功能测试
        int[] nums4 = {1,1,1,1,1,1,1,1,1,1};
        int[] expect4 = {1,1,1,1,1,1,1,1,1,1};
        test("test4",sort,nums4,expect4);

        int[] nums5 = {1,2,1,2,1,2,2,1,2,1};
        int[] expect5 = {1,1,1,1,1,2,2,2,2,2};
        test("test5",sort,nums5,expect5);

        int[] nums6 = {0,1,2,3,4,5,6,7,8,9};
        int[] expect6 = {0,1,2,3,4,5,6,7,8,9};
        test("test6",sort,nums6,expect6);

        int[] nums7 = {9,8,7,6,5,4,3,2,1,0};
        int[] expect7 = {0,1,2,3,4,5,6,7,8,9};
        test("test7",sort,nums7,expect7);

        int[] nums8 = {1,9,5,7,3,8,4,6,5,2};
        int[] expect8 = {1,2,3,4,5,5,6,7,8,9};
        test("test8",sort,nums8,expect8);

        int[] nums9 = {11,123,5,56,3,980,4,6,26,2};
        int[] expect9 = {2,3,4,5,6,11,26,56,123,980};
        test("test9",sort,nums9,expect9);
    }

    private static void test(String testN, Sort sort, int[] nums, int[] expect){
        sort.sort(nums);

        if (nums == null || expect == null) {
            System.out.println(testN + " ---------------- pass");
            if (nums != null && nums.length == 0) {
                System.out.println("expect: {}");
                System.out.println("result: {}");
            } else {
                System.out.println("expect: " + expect);
                System.out.println("result: " + nums);
            }
            return;
        }

        boolean success = true;
        for(int i=0; i< nums.length; i++) {
            if(nums[i] != expect[i]) {
                success = false;
                break;
            }
        }
        if (success) {
            System.out.println(testN + " ---------------- pass");
        } else {
            System.out.println(testN + " ---------------- failed");
        }
        System.out.print("expect: ");
        for(int i=0; i<expect.length; i++)
            System.out.print(expect[i] + " ");
        System.out.println();
        System.out.print("result: ");
        for(int i=0; i<nums.length; i++)
            System.out.print(nums[i] + " ");
        System.out.println();
    }

}
