package priorityqueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname : PriorityQueue
 * @Description : 数组实现优先级队列
 * 堆是完全二叉树，用数组表示时，位置 i 的父节点位置为 (i - 1) / 2，左右子节点位置分别为 2 * i + 1 和 2 * i + 2
 * @Author : chentianyu
 * @Date 2022/11/6 21:10
 */


public class Heap {

    public static void main(String[] args) {
        Heap heap = new Heap();
        int [] nums = {6, 2, 1, 8, 9, 4, 5, 0, 3, 7};
        for (int num : nums) {
            heap.push(num);
        }
        while (!heap.isEmpty()) {
            System.out.print(heap.top() + " ");
            heap.pop();
        }
    }

    private List<Integer> array;

    public Heap() {
        array = new ArrayList<>();
    }


    /**
     * 插入：数组末尾插入元素，上浮
     *
     * @param v
     */
    public void push(int v) {
        array.add(v);
        swim(array.size() - 1);
    }

    /**
     * 删除最大值：数组尾移到数组头，下沉
     */
    public void pop() {
        int end = array.size() - 1;
        array.set(0, array.get(end));
        array.remove(end);
        sink(0);
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 查询最大值
     *
     * @return
     */
    public int top() {
        return array.get(0);
    }


    private void swap(List<Integer> array, int a, int b) {
        int tmp = array.get(a);
        array.set(a, array.get(b));
        array.set(b, tmp);
    }

    /**
     * 上浮：与父节点交换直至到达顶点 或 父节点大于等于当前节点
     *
     * @param pos
     */
    private void swim(int pos) {
        while (pos > 0 && array.get((pos - 1) / 2) < array.get(pos)) {
            swap(array, pos, (pos - 1) / 2);
            pos = (pos - 1) / 2;
        }
    }

    /**
     * 下沉：与子节点交换直至无子节点 或 两个子节点都小于等于当前节点
     *
     * @param pos
     */
    private void sink(int pos) {
        int end = array.size() - 1;
        while (2 * pos + 1 <= end) {
            int i = 2 * pos + 1;
            // 注意优先与较大的子节点交换
            if (i < end && array.get(i + 1) > array.get(i)) i++;
            if (array.get(i) <= array.get(pos)) break;
            swap(array, pos, i);
            pos = i;
        }
    }




}
