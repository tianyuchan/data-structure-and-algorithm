package divideconquer;

import java.util.*;

/**
 * @Classname : DifferentWaysToAddParentheses
 * @Description : 241. 为运算表达式设计优先级
 * https://leetcode.cn/problems/different-ways-to-add-parentheses/
 * @Author : chentianyu
 * @Date 2022/10/9 22:03
 */


public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        DifferentWaysToAddParentheses my = new DifferentWaysToAddParentheses();
        List<Integer> ans = my.diffWaysToCompute("2-1-1");
        System.out.println();
    }

    /**
     * 分治法
     * @param expression
     * @return
     */
    public List<Integer> diffWaysToCompute1(String expression) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> lefts = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rights = diffWaysToCompute(expression.substring(i+1));
                for (int left : lefts) {
                    for (int right : rights) {
                        switch(c) {
                            case '+': ans.add(left + right); break;
                            case '-': ans.add(left - right); break;
                            case '*': ans.add(left * right); break;
                        }
                    }
                }
            }
        }
        if (ans.isEmpty()) {
            ans.add(Integer.valueOf(expression));
        }
        return ans;
    }


    private Map<String, List<Integer>> memorization = new HashMap<>();
    /**
     * 分治法 + memorization 优化
     * @param expression
     * @return
     */
    public List<Integer> diffWaysToCompute2(String expression) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> lefts = memorization.getOrDefault(expression.substring(0, i), diffWaysToCompute(expression.substring(0, i)));
                List<Integer> rights = memorization.getOrDefault(expression.substring(i + 1), diffWaysToCompute(expression.substring(i + 1)));
                for (int left : lefts) {
                    for (int right : rights) {
                        switch(c) {
                            case '+': ans.add(left + right); break;
                            case '-': ans.add(left - right); break;
                            case '*': ans.add(left * right); break;
                        }
                    }
                }
            }
        }
        if (ans.isEmpty()) {
            ans.add(Integer.valueOf(expression));
        }
        memorization.put(expression, ans);
        return ans;
    }


    /**
     * 动态规划
     * @param expression
     * @return
     */
    public List<Integer> diffWaysToCompute(String expression) {
        // 数据格式转换
        // 如 "2-1+11" => nums[2,1,11] opts[-,+]
        List<Integer> nums = new ArrayList<>();
        List<Character> opts = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                nums.add(num);
                num = 0;
                opts.add(c);
            } else {
                num = num * 10 + (c - '0');
            }
        }
        nums.add(num);

        // 动态规划处理
        int n = nums.size();
        // dp[i][j]：nums中第j个和第i个数字之间的不同计算结果
        List<Integer>[][] dp = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                dp[j][i] = new ArrayList<>();
                if (i == j) {
                    dp[j][i].add(nums.get(i));
                } else {
                    // 注意 k 不能取到 i
                    for (int k = j; k < i; k++) {
                        for (int left : dp[j][k]) {
                            for (int right : dp[k + 1][i]) {
                                switch(opts.get(k)) {
                                    case '+': dp[j][i].add(left + right); break;
                                    case '-': dp[j][i].add(left - right); break;
                                    case '*': dp[j][i].add(left * right); break;
                                }
                            }
                        }
                    }
                }  // end else
            }
        }
        return dp[0][n - 1];
    }
}
