package monotonestack;

import java.util.Stack;

/**
 * @Classname : DailyTemperatures
 * @Description : 739. 每日温度
 * https://leetcode.cn/problems/daily-temperatures/
 * @Author : chentianyu
 * @Date 2022/11/3 23:16
 */


public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int pos = stack.pop();
                ans[pos] = i - pos;
            }
            stack.push(i);
        }
        return ans;
    }
}
