package array

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
func GetConcatenation(nums []int) []int {
	result := make([]int, 2*len(nums))
	midIndex := len(nums)
	// Copy is slower than loop
	// copy(result[0:len(nums)], nums[:])
	// copy(result[len(nums):], nums[:])
	for i := 0; i < len(nums); i++ {
		result[i], result[midIndex] = nums[i], nums[i]
		midIndex += 1
	}
	return result
}
