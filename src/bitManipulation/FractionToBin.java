package bitManipulation;

public class FractionToBin{

	/**
	*	convert a fraction to string binary reprensentation
	*/
	public void fractionToBin(Double num){
		StringBuilder sb = new StringBuilder();
		sb.append("0.");
		for(int i = 0; i < 32; i++){
			num *= 2;
			char bitStr; 
			if(num >= 1){
				num = num -1;
				bitStr = '1';
				if(num == 0){
					sb.append(bitStr);
					break;
				}
			}else{
				bitStr = '0';
			}
			sb.append(bitStr);
		}
		if(num > 0){
			System.out.println("ERROR");
		}else{
			System.out.println(sb.toString());
		}
	}
}