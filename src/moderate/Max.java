package moderate;

public class Max{
	/**
	*	@note: problem: overflow
	*/
	public int max(int first, int second){
		int flag = ~((first - second) >> 31);
		int result = (flag & first) + ((~flag) & second);
		return result;
	}

	// @note: use the exact variable name when deducing, not a, b
	public int max1(int first, int second){
		int flaga = first >> 31; // +, 0; -, 1
		int flagb = second >> 31;
		int flagab = (first - second) >> 31;
		// a +, b -
		int resulta = ((~flaga) & flagb) & first;
		// a -, b +
		int resultb = (flaga & (~flagb)) & second;
		// a, b same sign
		// @note: same sign!
		int resultab = (~flaga ^ flagb) & ((flagab & second) + (~flagab & first));

		int result = resulta + resultb + resultab;
		return result;
	}
}