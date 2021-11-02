package main.java.com.zhang.leetCode;

/**
 * @author ZhangZePing
 * @description leetCode 915. 分割数组
 * @date 2021/11/2 10:14
 * <p>
 * 给定一个数组 A，将其划分为两个连续子数组 left 和 right，使得：
 * <p>
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
 * <p>
 * <p>
 * 示例 1：
 * 输入：[5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 * <p>
 * 示例 2：
 * 输入：[1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 30000
 * 0 <= A[i] <= 10^6
 * 可以保证至少有一种方法能够按题目所描述的那样对 A 进行划分。
 */
public class PartitionDisjoint {
    public static void main(String[] args) {
        int[] nums = {6, 0, 8, 30, 37, 6, 75, 98, 39, 90, 63, 74, 52, 92, 64};
        int[] nums1 = {1, 1, 1, 0, 6, 12};
        int[] nums2 = {5, 0, 3, 8, 6, 8, 1, 9};
        int[] nums3 = {1, 1, 1, 1};
        int[] nums4 = {12, 75, 26, 38, 56, 59, 83, 55, 49, 52, 27, 48, 77, 21, 27, 79, 54, 15, 59, 22, 34, 35, 81, 67, 2, 41, 40, 0, 73, 61, 75, 8, 86, 42, 49, 83, 43, 16, 2, 54, 26, 35, 15, 63, 31, 24, 51, 86, 6, 35, 42, 37, 83, 51, 34, 21, 71, 57, 61, 76, 50, 1, 43, 32, 19, 13, 67, 87, 3, 33, 38, 34, 34, 84, 38, 76, 52, 7, 27, 49, 2, 78, 56, 28, 70, 6, 64, 87, 100, 97, 99, 97, 97, 100, 100, 100, 97, 89, 98, 100};
        System.out.print(partitionDisjoint(nums3));
    }

    public static int partitionDisjoint(int[] nums) {
        int temp = nums[0];
        int max = nums[0];
        int index = 0;
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (temp <= nums[i] && flag) {
                index = i;
                flag = false;
            }
            if (temp > nums[i]) {
                temp = max;
                flag = true;
            }
        }
        if (index == 0) {
            return 1;
        }
        return index;
    }
}
