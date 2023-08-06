package array

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
func RemoveDuplicates(nums []int) int {
	swap := 1
	for i := 1; i < len(nums); i++ {
		if nums[i] != nums[swap-1] {
			nums[swap] = nums[i]
			swap += 1
		}
	}
	return swap
}

/*
 * Remove Element
 * https://leetcode.com/problems/remove-element/
 *
 * Given an integer array nums and an integer val, remove all occurrences of
 * val in nums in-place. The order of the elements may be changed. Then
 * return the number of elements in nums which are not equal to val.
 * Consider the number of elements in nums which are not equal to val be k,
 * to get accepted, you need to do the following things:
 * - Change the array nums such that the first k elements of nums contain
 *   the elements which are not equal to val. The remaining elements of nums
 *   are not important as well as the size of nums.
 * - Return k.
 */
func RemoveElement(nums []int, val int) int {
	index := 0
	window := len(nums) - 1
	for index <= window {
		if nums[index] == val {
			nums[index], nums[window] = nums[window], nums[index]
			window -= 1
		} else {
			index += 1
		}
	}
	return index
}
