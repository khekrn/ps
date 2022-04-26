package array;

/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. 
 * This matrix has the following properties:
 * - Integers in each row are sorted from left to right.
 * - The first integer of each row is greater than the last integer of the previous row.
 * 
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * 
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 * 
 */
public class Search2D{
	public boolean searchMatrix(int[][] matrix, int target) {
		var result = false;
        for(int i = 0; i < matrix.length; i++){
        	if(matrix[i][0] <= target && matrix[i][matrix[i].length-1] >= target){
        		
				var low = 0;
				var high = matrix[i].length-1;
				var mid = 0;
				while(high > low){
					mid = (high + low) / 2;
					if(matrix[i][mid] < target){
						low = mid +1;
					}else{
						high = high - 1;
					}
				}
				if(matrix[i][high] == target){
					result = true;
					break;
				}else{
					break;
				}
        	}
        }
		return result;
	}
	
	public static void main(String[] args){
		var search2d = new Search2D();
		var input = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
		var target = 13;
		System.out.println(search2d.searchMatrix(input, target));
	}
}