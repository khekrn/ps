package array;

import java.util.Arrays;
import java.util.HashMap;


/**
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers 
 * such that they add up to target.You may assume that each input would have exactly one solution, 
 * and you may not use the same element twice.You can return the answer in any order.
 * 
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * 
 */

public class TwoSum{
	
	public int[] solve(int[] nums, int target){
		if(nums == null || nums.length < 2){
			return null;
		}
		
		var result = new int[2];
		var dict = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++){
			var complement = target - nums[i];
			if(dict.containsKey(complement)){
				result[0] = dict.get(complement);
				result[1] = i;
			}
			dict.put(nums[i], i);
		}
		return result;
	}
	
	public static void main(String[] args){
		var obj = new TwoSum();
		var input = new int[]{3,3};
		var target = 6;
		var result = obj.solve(input, target);
		System.out.println("Output = "+Arrays.toString(result));
			
	}
}