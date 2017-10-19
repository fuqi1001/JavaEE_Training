package main;

import java.util.*;

public class Test2 {
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % k != 0) return false;
        else sum /= k;
        return helper(nums, sum, 0,k,sum);
    }

    public static boolean helper(int[] nums, int target, int start, int k, int sum) {
        if( k == 1) return true;
        if(sum == 0) return helper(nums, target, 0, k - 1, target);
        for(int i = start; i < nums.length; i++) {
            if(helper(nums, target, i+1,k,sum-nums[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = {4,3,2,3,5,2,1};
        System.out.println(canPartitionKSubsets(nums, 4));
    }
}
