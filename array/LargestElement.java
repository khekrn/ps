package array;

public final class LargestElement{


	public long longest(long[] arr, int n){
		long largestElement = arr[0];
		for(long value : arr){
			if(value > largestElement){
				largestElement = value;
			}
		}
		return largestElement;
	}

}