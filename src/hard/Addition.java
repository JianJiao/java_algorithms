package hard;

public class Addition{

	public int addition(int a, int b){
		int result = a ^ b;
		int carry = a & b;
		if(carry != 0){
			int trueCarry = carry << 1;
			result = addition(result, trueCarry);
		}
		// @note: return!
		return result;
	}
}