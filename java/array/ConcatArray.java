package array;

import java.util.Arrays;

/**
 * Concatenation of Array
 * 
 * Given an integer array nums of length n, you want to 
 * create an array ans of length 2n where ans[i] == nums[i]
 * and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
 * Specifically, ans is the concatenation of two nums arrays.
 * Return the array ans.
 * 
 * Example:
 * Input: nums = [1,2,1]
 * Output: [1,2,1,1,2,1]
 * Explanation: The array ans is formed as follows:
 * - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
 * - ans = [1,2,1,1,2,1]
 */
public class ConcatArray {

    public int[] getConcatenation(int[] nums) {
        var newSize = 2 * nums.length;
        var midIndex = nums.length;
        var result = new int[newSize];

        for (int i =0; i<nums.length; i++){
            result[i] = nums[i];
            result[midIndex] = nums[i];
            midIndex++;
        }
        return result;
    }

   public static void main(String[] args) {
        var concatArray = new ConcatArray();
        var input = new int[]{1,3,2,1};
        System.out.println(Arrays.toString(concatArray.getConcatenation(input)));
   } 
}
