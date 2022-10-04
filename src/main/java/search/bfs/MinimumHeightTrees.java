package search.bfs;

import java.util.*;

/**
 * @Classname : MinimumHeightTrees
 * https://leetcode.cn/problems/minimum-height-trees/
 * @Description : 310. 最小高度树
 * 结论1：无向无环图以某个节点为根节点，结果树的最小高度 = 图中两个距离最远节点（隐藏条件：都是叶子节点）的距离的一半
 * 结论2：最小高度结果树的根节点，一定在两个距离最远节点的路径上，且为其中间节点
 * 结论3：以图中任意一个节点找距其最远的节点x，再以节点x找距其最远的节点y，则节点x和y为图中距离最远的节点
 * @Author : chentianyu
 * @Date 2022/9/22 00:05
 */


public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }

        List<Integer>[] nexts = new List[n];
        for (int i = 0; i < n; i++) {
            nexts[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            nexts[edge[0]].add(edge[1]);
            nexts[edge[1]].add(edge[0]);
        }

        // 使用结论3
        int[] parent = new int[n];
        int x = maxDistNode(nexts, parent, 0);
        int y = maxDistNode(nexts, parent, x);
        List<Integer> path = new ArrayList<>();
        parent[x] = -1;
        while(y != -1) {
            path.add(y);
            y = parent[y];
        }
        // 使用结论1和2
        int xyDist = path.size();
        if (xyDist % 2 == 0) ans.add(path.get(xyDist / 2 - 1));
        ans.add(path.get(xyDist / 2));
        return ans;
    }

    // 获取图中距离节点root最远的节点
    private int maxDistNode(List<Integer>[] nexts, int[] parent, int root) {
        int ans = -1;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[nexts.length];
        q.offer(root);
        while (!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;
            if (nexts[cur] != null) {
                for (int next : nexts[cur]) {
                    if (visited[next]) continue;
                    q.offer(next);
                    parent[next] = cur;
                    ans = next;
                }
            }
        }
        return ans;
    }
}
