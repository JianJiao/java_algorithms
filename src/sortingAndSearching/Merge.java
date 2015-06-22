package sortingAndSearching;

public class Merge{

	/**
	* merge src into target. Target is bigger
	*	@param: len: the length of the meaningful part of target array
	* 
	*/
	public void merge(int[] src, int[] target, int len){
		// check args
		if(src == null || target == null){
			throw new IllegalArgumentException("src and target cannot be null");
		}
		int srcLength = src.length;
		int targetLength = len;
		int totalLength = srcLength + targetLength;
		int srcIdx = srcLength - 1
		    ,targetIdx = targetLength - 1;
		for(int i = totalLength - 1; i >= 0; i--){
			// i has decreased already
			if(srcIdx < 0 || targetIdx < 0){
				break;
			}
			if(src[srcIdx] > target[targetIdx]){
				target[i] = src[srcIdx];
				srcIdx--;
			}else{
				target[i] = target[targetIdx];
				targetIdx--;
			}
		}
		if(targetIdx < 0){
			for(int i = 0; i <= srcIdx; i++){
				target[i] = src[i];
			}
		}
	}

}