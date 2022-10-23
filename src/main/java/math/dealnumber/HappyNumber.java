package math.dealnumber;

import java.util.*;

/**
 * @Classname : HappyNumber
 * @Description : 202. 快乐数
 * https://leetcode.cn/problems/happy-number/
 * @Author : chentianyu
 * @Date 2022/10/23 23:14
 */


public class HappyNumber {

    /**
     * 快慢指针法
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slow = n, fast = getNext(getNext(n));
        while (true) {
            if (fast == 1) return true;
            if (fast == slow) return false;

            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
    }

    private int getNext(int n) {
        int next = 0;
        while (n > 0) {
            next += Math.pow(n % 10, 2);
            n /= 10;
        }
        return next;
    }

    /**
     * 哈希集合检查法
     *
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            if (set.contains(n)) return false;
            if (n == 1) return true;
            set.add(n);

            int cur = n;
            n = 0;
            while (cur > 0) {
                n += Math.pow(cur % 10, 2);
                cur /= 10;
            }
        }
    }
}  // end class
