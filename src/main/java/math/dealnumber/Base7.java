package math.dealnumber;

/**
 * @Classname : Base7
 * @Description : 504. 七进制数
 * https://leetcode.cn/problems/base-7/
 * @Author : chentianyu
 * @Date 2022/10/14 21:52
 */


public class Base7 {
    private final int RADIX = 7;

    public String convertToBase7(int num) {
        if (num == 0) return "0";

        int isNegative = 0;
        if (num < 0) {
            isNegative = 1;
            num = -num;
        }

        StringBuilder ans = new StringBuilder();
        while (num > 0) {
            ans.append(num % RADIX + "");
            num /= RADIX;
        }
        if (isNegative == 1) ans.append('-');
        return ans.reverse().toString();
    }
}
