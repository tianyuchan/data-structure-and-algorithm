package math.dealnumber;

/**
 * @Classname : AddBinary
 * @Description : 67. 二进制求和
 * https://leetcode.cn/problems/add-binary/
 * @Author : chentianyu
 * @Date 2022/10/17 22:58
 */


public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        char[] aCharArray = a.toCharArray(), bCharArray = b.toCharArray();
        int lenA = a.length() - 1, lenB = b.length() - 1, carry = 0;

        while (lenA >= 0 || lenB >= 0) {
            int na = lenA >= 0 ? aCharArray[lenA--] - '0' : 0;
            int nb = lenB >= 0 ? bCharArray[lenB--] - '0' : 0;
            int sum = na + nb + carry;
            carry = sum / 2;
            ans.append((char)('0' + sum % 2));
        }
        if (carry > 0) ans.append((char)('0' + carry));
        return ans.reverse().toString();
    }
}
