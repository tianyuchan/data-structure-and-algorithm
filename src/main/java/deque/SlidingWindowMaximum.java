package deque;

import java.util.ArrayDeque;

/**
 * @Classname : SlidingWindowMaximum
 * @Description : 239. 滑动窗口最大值
 * https://leetcode.cn/problems/sliding-window-maximum/
 * @Author : chentianyu
 * @Date 2022/11/19 21:56
 */


public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, j = 0;
        int[] ans = new int[n - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 双端队列存索引位置
            // 双端队列维护递减的单调栈，保证左端始终是滑动窗口的最大值
            // 若左端索引位置等于 i-k，说明左端应该移出滑动窗口
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            // 当滑动窗口满后，将最大值记录在结果数组
            if (i >= k - 1) {
                ans[j++] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
