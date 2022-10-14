package math.dealnumber;

/**
 * @Classname : AddStrings
 * @Description : 415. 字符串相加
 * https://leetcode.cn/problems/add-strings/
 * @Author : chentianyu
 * @Date 2022/10/14 22:43
 */


public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        int n1 = num1.length() - 1, n2 = num2.length() - 1, carry = 0;
        char[] num1CharArray = num1.toCharArray();
        char[] num2CharArray = num2.toCharArray();

        while (n1 >= 0 || n2 >= 0) {
            int a = n1 < 0 ? 0 : num1CharArray[n1--] - '0';
            int b = n2 < 0 ? 0 : num2CharArray[n2--] - '0';
            int sum = a + b + carry;
            ans.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) ans.append(carry);
        return ans.reverse().toString();
    }
}
