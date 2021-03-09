package array;

public final class GameWithNOS{

    public static int[] game_with_number (int arr[], int n) {
		//int[] result = new int[n];
		for(int i = 0; i < arr.length-1; i++){
			arr[i] = arr[i] ^ arr[i+1];
		}

		return arr;
    }

}