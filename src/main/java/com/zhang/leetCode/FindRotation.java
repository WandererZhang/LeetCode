package main.java.com.zhang.leetCode;

/**
 * @author ZhangZePing
 * @description leetCode 1886. 判断矩阵经轮转后是否一致
 * @date 2021/11/2 14:57
 * 给你两个大小为 n x n 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，如果能够使 mat 与 target 一致，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
 * 输出：true
 * 解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
 * <p>
 * 示例 2：
 * 输入：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
 * 输出：false
 * 解释：无法通过轮转矩阵中的元素使 equal 与 target 一致。
 * <p>
 * 示例 3：
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
 * 输出：true
 * 解释：顺时针轮转 90 度两次可以使 mat 和 target 一致。
 * <p>
 * 提示：
 * <p>
 * n == mat.length == target.length
 * n == mat[i].length == target[i].length
 * 1 <= n <= 10
 * mat[i][j] 和 target[i][j] 不是 0 就是 1
 */
public class FindRotation {
    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] target = {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};
        System.out.print(findRotation(mat, target));
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        boolean flag1 = true, flag2 = true, flag3 = true, flag4 = true;
        int n = mat.length;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != target[i][j]) {
                    flag4 = false;
                }
                if (mat[i][j] != target[j][n - i - 1]) {
                    flag1 = false;
                }
                if (mat[i][j] != target[n - i - 1][n - j - 1]) {
                    flag2 = false;
                }
                if (mat[i][j] != target[n - j - 1][i]) {
                    flag3 = false;
                }
                if (!flag1 && !flag2 && !flag3 && !flag4) {
                    return false;
                }
            }
        }
        return flag1 || flag2 || flag3 || flag4;
    }
}
