package main.java.com.zhang.leetCode;

import java.util.Arrays;

/**
 * @author ZhangZePing
 * @description leetCode 1647. 字符频次唯一的最小删除次数
 * @date 2021/11/4 13:59
 */
public class MinDeletions {
    public static void main(String[] args) {
        System.out.println(minDeletions("aaabbbcc"));
    }

    public static int minDeletions(String s) {
        Integer[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        Arrays.sort(nums, (o1, o2) -> o2 - o1);
        int count = 0;
        for (int i = 1; i < 26; i++) {
            while (nums[i] > 0 && nums[i] >= nums[i - 1]) {
                nums[i]--;
                count++;
            }
        }
        return count;
    }
}
