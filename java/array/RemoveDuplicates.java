package array;

import java.util.Arrays;

/**
 * Remove Duplicates From Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Given an integer array nums sorted in non-decreasing order, remove the
 * duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * Then return the number of unique elements in nums.
 *
 * Consider the number of unique elements of nums to be k, to get accepted,
 * you need to do the following things:
 *  - Change the array nums such that the first k elements of nums contain
 *    the unique elements in the order they were present in nums initially.
 *    The remaining elements of nums are not important as well as the
 *    size of nums.
 *  - Return k.
 *
 */

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        var result = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[result] = nums[i]; 
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var removeDuplicates = new RemoveDuplicates();
        var arr = new int[]{1,1,2,2};
        System.out.println("Result = "+removeDuplicates.removeDuplicates(arr));
        System.out.println("Array = "+Arrays.toString(arr));
    }
}
