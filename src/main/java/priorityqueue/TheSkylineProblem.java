package priorityqueue;

import java.util.*;

/**
 * @Classname : TheSkylineProblem
 * @Description : 218. 天际线问题
 * https://leetcode.cn/problems/the-skyline-problem/
 * 天际线：建筑物外部轮廓中某个高度第一次出现的位置
 * @Author : chentianyu
 * @Date 2022/11/18 01:09
 */


public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        // S1：查找全部可能作为天际线横坐标的扫描线（注意：可能存在重复的扫描线）
        List<Integer> scans = new ArrayList<>();
        for (int[] building : buildings) {
            scans.add(building[0]);
            scans.add(building[1]);
        }
        Collections.sort(scans);

        // S2：创建优先队列
        // 队列元素：建筑物高度和右端点组成的数组
        // 比较规则：高度优先（逆序），高度相同则右端点小的优先（正序）
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2)->{
            if (o1[0] != o2[0]) return Integer.compare(o2[0], o1[0]);
            else return Integer.compare(o1[1], o2[1]);
        });

        // S3：遍历扫描线，确定该扫描线的高度，并确定该扫描线是否有效
        int i = 0, len = buildings.length;
        for (int x : scans) {
            // S3.1：确定该扫描线的高度
            // 入队：建筑物左端点小于等于扫描线
            while (i < len && buildings[i][0] <= x) {
                q.offer(new int[]{buildings[i][2], buildings[i][1]});
                i++;
            }
            // 出队：建筑物右端点也小于等于扫描线，即[left, right)未包含扫描线，说明该建筑物未经过该扫描线
            while (!q.isEmpty() && q.peek()[1] <= x) {
                q.poll();
            }
            // 确定高度：经过该扫描线的所有建筑物中高度最高建筑物的高度
            int h = q.isEmpty() ? 0 : q.peek()[0];

            // S3.2：确定该扫描线是否有效
            // 有效判断条件：当前扫描线高度与上一扫描线高度不同
            // 无效具体情况：① 该扫描线与上一扫描线相同；② 该扫描线高度与上一扫描线高度相同
            if (ans.isEmpty() || h != ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(new Integer[]{x, h}));
            }
        }
        return ans;
    }
}
