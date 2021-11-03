package main.java.com.zhang.leetCode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangZePing
 * @description leetCode 1855. 下标对中的最大距离
 * @date 2021/11/3 10:49
 */
public class MaxDistance {
    public static void main(String[] args) {
        int[] nums1 = {2, 2, 2};
        int[] nums2 = {10, 10, 1};
        int[] nums3 = {55, 30, 5, 4, 2};
        int[] nums4 = {100, 20, 10, 10, 5};
        System.out.println(maxDistance(nums3, nums4));
    }

    public static int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] > nums2[p2]) {
                if (p1 == p2) {
                    p1++;
                    p2++;
                } else {
                    p1++;
                }
            } else {
                max = Math.max(p2 - p1, max);
                p2++;
            }
        }
        return max;
    }
}
