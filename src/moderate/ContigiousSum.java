package moderate;
import java.util.ArrayList;

public class ContigiousSum{

	public int contigiousSum(int[] arr){
		if(arr == null || arr.length == 0){
			throw new IllegalArgumentException("...");
		}
		// @note: we don't even need a list
		// @note: arrayList is more convenient
		// ArrayList<Integer> list = new ArrayList<Integer>();
		int max = arr[0];
		for(int i = 0; i < arr.length; i++){
			int sum = 0;
			for(int j = i; j < arr.length; j++){
				sum += arr[j];
				// list.add(sum);
				if(sum > max){
					max = sum;
				}
			}
		}
		return max;
	}

	public int contigiousSum1(int[] arr){
		if(arr == null || arr.length == 0){
			throw new IllegalArgumentException();
		}

		int max = arr[0];
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
			if(sum > max){
				max = sum;
			}else if(sum < 0){
				// start from i, abandon the previous
				sum = 0;
			}
		}
		return max;

	}


}