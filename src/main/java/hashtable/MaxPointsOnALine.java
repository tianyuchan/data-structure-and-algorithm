package hashtable;

import java.util.HashMap;

/**
 * @Classname : MaxPointsOnALine
 * @Description : 149. 直线上最多的点数
 * https://leetcode.cn/problems/max-points-on-a-line/
 * @Author : chentianyu
 * @Date 2022/11/20 23:36
 */


public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        int ans = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            // 对于每个点，统计其他点与之同斜率的点的个数（即经过当前点的同一条直线的个数）
            // 由于当前点之前的点都已经统计过，只需统计当前点与后续点组成的直线即可
            int[] pointA = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] pointB = points[j];

                // 确定斜率
                StringBuilder k = new StringBuilder();
                int dx = pointB[0] - pointA[0], dy = pointB[1] - pointA[1];
                if (dx == 0) {
                    // 平行y轴的直线
                    k.append(pointA[0]);
                    k.append('#');
                    k.append(0);
                } else if (dy == 0) {
                    // 平行x轴的直线
                    k.append(0);
                    k.append('#');
                    k.append(pointA[1]);
                } else {
                    // 其他情况需要把斜率的分子分母约分为最简后再记录
                    int gcm = gcm(dx, dy);
                    k.append(dy / gcm);
                    k.append('/');
                    k.append(dx / gcm);
                }
                String kStr = k.toString();

                // 同斜率点的个数更新
                int count = 2;
                if (map.containsKey(kStr)) {
                    count = map.get(kStr) + 1;
                    map.put(kStr, count);
                }
                else {
                    map.put(kStr, count);
                }
                ans = Math.max(ans, count);
            }
            map.clear();
        }
        return ans;
    }

    // 获取最大公因数
    private int gcm(int a, int b) {
        return b == 0 ? a : gcm(b, a % b);
    }
}
