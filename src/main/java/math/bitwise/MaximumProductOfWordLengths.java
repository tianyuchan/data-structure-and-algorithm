package math.bitwise;

/**
 * @Classname : MaximumProductOfWordLengths
 * @Description : 318. 最大单词长度乘积
 * https://leetcode.cn/problems/maximum-product-of-word-lengths/
 * @Author : chentianyu
 * @Date 2022/10/30 23:27
 */


public class MaximumProductOfWordLengths {
    /**
     * 执行用时：11 ms, 在所有 Java 提交中击败了59.46%的用户
     * 内存消耗：44 MB, 在所有 Java 提交中击败了25.75%的用户
     * 通过测试用例：168 / 168
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int ans = 0, n = words.length;
        if (n < 2) return ans;

        // int[n][0] 二进制表示哪些字母存在，int[n][1] 非重复字母的个数
        int[] masks = new int[n];
        for (int i = 0; i < n; i++) {
            char[] wordArray = words[i].toCharArray();
            for (char ch : wordArray) {
                int bit = (int) ch - 'a';
                // bit位置此时为0，说明该位置字母第一次出现
                if ((masks[i] & (1 << bit)) == 0) {
                    masks[i] += (1 << bit);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 位与为0，说明无公共字母
                if ((masks[i] & masks[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}
