package monotonestack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Classname : NextGreaterElementII
 * @Description : 503. 下一个更大元素 II
 * https://leetcode.cn/problems/next-greater-element-ii/
 * @Author : chentianyu
 * @Date 2022/11/27 22:55
 */


public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n - 1; i++) {  // 遍历两次
            while (!stack.isEmpty() && stack.peek() != i % n && nums[stack.peek()] < nums[i % n]) {
                ans[stack.pop()] = nums[i % n];
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return ans;
    }
}  // end class
