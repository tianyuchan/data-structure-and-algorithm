package search.bfs;

import java.util.*;

/**
 * @Classname : WordLadderII
 * @Description : 126. 单词接龙 II
 * https://leetcode.cn/problems/word-ladder-ii/
 * @Author : chentianyu
 * @Date 2022/9/18 22:29
 */


public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return new LinkedList<>();
        Map<String, List<String>> from = new HashMap<>();
        Map<String, Integer> steps = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        dict.remove(beginWord);
        int step = 1;
        boolean found = false;

        // 广度优先搜索进行单次层次遍历
        while (!q.isEmpty()) {
            int size = q.size();
            // 对当前层次单词进行遍历
            for (int i = 0; i < size; i++) {
                String curWord = q.poll();
                char[] curWordArray = curWord.toCharArray();
                // 对当前单词的各个位置进行遍历
                for (int j = 0; j < curWord.length(); j++) {
                    char origin = curWordArray[j];
                    // 对单词当前位置可能出现的字符进行遍历
                    for (char k = 'a'; k <= 'z'; k++) {
                        curWordArray[j] = k;
                        String nextWord = new String(curWordArray);
                        // 当前层其他单词也可能转化为该单词
                        if (steps.containsKey(nextWord) && step == steps.getOrDefault(nextWord, -1)) {
                            from.computeIfAbsent(nextWord, key->new ArrayList<>()).add(curWord);  // 记录转化关系
                        }
                        // 当前层第一次有单词转化为该单词
                        if (dict.contains(nextWord)) {
                            dict.remove(nextWord);  // 已被使用，从单词表中删除
                            from.computeIfAbsent(nextWord, key->new ArrayList<>()).add(curWord);  // 记录转化关系
                            steps.put(nextWord, step);  // 记录单词被使用对层数
                            q.add(nextWord);  // 记录该单词，下层进行搜索
                            if (nextWord.equals(endWord)) found = true;  // 查找结束
                        }
                    }
                    curWordArray[j] = origin;
                }
            }
            // 当前层已找到从单词 beginWord 到单词 endWord 转化路径，则无需进行下一层的搜索
            if (found) break;
            step++;
        }

        List<List<String>> ans = new ArrayList<>();
        // 深度优先搜索查找全部符合条件的转化路径
        if (found) {
            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);
            backTracking(from, ans, path, beginWord, endWord);
        }
        return ans;
    }

    private void backTracking(Map<String, List<String>> from, List<List<String>> ans, Deque<String> path, String beginWord, String curWord) {
        if (beginWord.equals(curWord)) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (String nextWord : from.get(curWord)) {
            path.addFirst(nextWord);
            backTracking(from, ans, path, beginWord, nextWord);
            path.removeFirst();
        }
    }
}
