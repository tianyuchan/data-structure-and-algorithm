package multiset;

import java.util.*;

/**
 * @Classname : ReconstructItinerary
 * @Description : 332. 重新安排行程
 * https://leetcode.cn/problems/reconstruct-itinerary/
 * @Author : chentianyu
 * @Date 2022/11/21 22:49
 */


public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new ArrayList<>();
        // 将每个机场的可达机场以字典序优先队列放入map中
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            if (!map.containsKey(from)) map.put(from, new PriorityQueue<>());
            map.get(from).offer(to);
        }

        // 深度优先遍历查找最优行程
        dfs(ans, map, "JFK");
        Collections.reverse(ans);
        return ans;
    }

    private void dfs(List<String> ans, Map<String, PriorityQueue<String>> map, String cur) {
        while (map.containsKey(cur) && map.get(cur).size() > 0) {
            dfs(ans, map, map.get(cur).poll());
        }
        // 死胡同机场优先放入行程
        ans.add(cur);
    }
}  // end class
