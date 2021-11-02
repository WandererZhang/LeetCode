package main.java.com.zhang.leetCode;

import java.awt.*;
import java.util.*;

/**
 * @author ZhangZePing
 * @description leetCode 826. 安排工作以达到最大收益
 * @date 2021/11/1 17:38
 * 有一些工作：difficulty[i]表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
 * <p>
 * 现在我们有一些工人。worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
 * <p>
 * 每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。
 * <p>
 * 举个例子，如果 3 个工人都尝试完成一份报酬为 1 的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。
 * <p>
 * 我们能得到的最大收益是多少？
 * <p>
 * 示例 1：
 * <p>
 * 输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * 输出: 100
 * 解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
 * 示例 2:
 * <p>
 * 输入: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
 * 输出: 0
 * <p>
 * 提示:
 * <p>
 * n == difficulty.length
 * n == profit.length
 * m == worker.length
 * 1 <= n, m <= 104
 * 1 <= difficulty[i], profit[i], worker[i] <= 105
 */
public class MaxProfitAssignment {
    public static void main(String[] args) {
        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};
        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(difficulty[i], profit[i]);
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a.x));
        Arrays.sort(worker);
        int j = 0, max = 0, sum = 0;
        for (int w : worker) {
            while (j < n && w >= points[j].x) {
                max = Math.max(max, points[j++].y);
            }
            sum += max;
        }
        return sum;
    }
}
