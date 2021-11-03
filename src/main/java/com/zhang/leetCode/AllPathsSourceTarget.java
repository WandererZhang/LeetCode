package main.java.com.zhang.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangZePing
 * @description leetCode 797. 所有可能的路径
 * @date 2021/11/2 14:10
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n- 1的路径并输出（不要求按特定顺序）
 * <p>
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 * <p>
 * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
 * <p>
 * 示例 1：
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * <p>
 * 示例 2：
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * <p>
 * 示例 3：
 * 输入：graph = [[1],[]]
 * 输出：[[0,1]]
 * <p>
 * 示例 4：
 * 输入：graph = [[1,2,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,2,3],[0,3]]
 * <p>
 * 示例 5：
 * 输入：graph = [[1,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,3]]
 * <p>
 * 提示：
 * <p>
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i（即，不存在自环）
 * graph[i] 中的所有元素 互不相同
 * 保证输入为 有向无环图（DAG）
 */
public class AllPathsSourceTarget {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();

    public static void main(String[] args) {
        int[][] graph = {
                {4, 3, 1}, {3, 2, 4}, {3}, {4}, {}
        };
        System.out.print(allPathsSourceTarget(graph));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, 0);
        return result;
    }

    public static void dfs(int[][] graph, int i) {
        if (i == graph.length - 1) {
            temp.add(i);
            result.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
        }
        temp.add(i);
        for (int j : graph[i]) {
            dfs(graph, j);
        }
        temp.remove(temp.size() - 1);
    }
}
