package search.dfs;

/**
 * @Classname : NumberOfProvinces
 * @Description : 547. 省份数量
 * https://leetcode.cn/problems/number-of-provinces/
 * @Author : chentianyu
 * @Date 2022/8/23 23:04
 */


public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int i, boolean[] visited) {
        visited[i] = true;
        for (int k = 0; k < isConnected.length; k++) {
            if (!visited[k] && isConnected[i][k] == 1) {
                dfs(isConnected, k, visited);
            }
        }
    }
}
