package array;

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

public class RemoveElement {

    private void swap(int[] arr, int i, int j){
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int removeElement(int[] nums, int val) {
        var window = nums.length-1;
        var index = 0;
        while(index <= window){
            if(nums[index] == val){
                swap(nums, index, window);
                window -=1;
            }else{
                index += 1;
            }

        }
        return index;
    }

    public static void main(String[] args) {
        var removeElement = new RemoveElement();
        var nums = new int[]{3,2,2,3};
        System.out.println(removeElement.removeElement(nums, 3));
    }
}
