package math.dealnumber;

/**
 * @Classname : ExcelSheetColumnTitle
 * @Description : 168. Excel表列名称
 * https://leetcode.cn/problems/excel-sheet-column-title/
 * @Author : chentianyu
 * @Date 2022/10/17 21:48
 */


public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0) {
            int remainder = columnNumber % 26, quotient = columnNumber / 26;
            if (remainder == 0) {
                remainder = 26;
                quotient--;
            }
            ans.append((char)('A' - 1 + remainder));
            if (columnNumber <= 26) break;
            else columnNumber = quotient;
        }
        return ans.reverse().toString();
    }
}
