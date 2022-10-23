package math.random;

/**
 * @Classname : ImplementRand10UsingRand7
 * @Description : 470. 用 Rand7() 实现 Rand10()
 * https://leetcode.cn/problems/implement-rand10-using-rand7/
 * @Author : chentianyu
 * @Date 2022/10/23 23:02
 */


public class ImplementRand10UsingRand7 {
    public int rand10() {
        int v = 0;
        for (int i = 0; i < 10; i++) {
            v += rand7();
        }
        return v % 10 + 1;
    }

    public int rand101() {
        int a = 0, b = 0;
        while((a = rand7()) > 6);
        while((b = rand7()) > 5);

        return a % 2 == 1 ? b : b + 5;
    }

    private int rand7() {
        return 1 + (int) (Math.random() * 6);
    }
}
