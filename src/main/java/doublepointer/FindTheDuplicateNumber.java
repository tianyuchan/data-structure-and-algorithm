package doublepointer;

/**
 * @Classname : FindTheDuplicateNumber
 * @Description : 287. 寻找重复数
 * https://leetcode.cn/problems/find-the-duplicate-number/
 * Floyd 判圈算法:
 * 先设置慢指针 slow 和快指针 fast ，慢指针每次走一步，快指针每次走两步，
 * 根据「Floyd 判圈算法」两个指针在有环的情况下一定会相遇，
 * 此时我们再将 slow 放置起点，两个指针每次同时移动一步，相遇的点就是答案。
 * @Author : chentianyu
 * @Date 2022/12/1 22:21
 */


public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);
        slow = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}  // end class
