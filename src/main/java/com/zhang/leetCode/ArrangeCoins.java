package main.java.com.zhang.leetCode;

/**
 * @author ZhangZePing
 * @description leetCode 441. 排列硬币
 * @date 2021/11/2 11:14
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 * <p>
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 * <p>
 * 示例 1：
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 * <p>
 * 示例 2：
 * 输入：n = 8
 * 输出：3
 * 解释：因为第四行不完整，所以返回 3 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2 ^ 31 - 1
 */
public class ArrangeCoins {
    public static void main(String[] args) {
        System.out.print(arrangeCoins(1));
    }

    public static int arrangeCoins(int n) {
        return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
    }
}
