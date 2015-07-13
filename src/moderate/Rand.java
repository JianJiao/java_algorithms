package moderate;

public class Rand{

	public int rand7(){
		int result = 10;
		while(result > 6){
			int side = rand5();
			while(side == 2){
				side = rand5();
			}
			if(side < 2){
				result = rand5();
			}else{
				result = rand5() + 5;
			}
		}
		return result;
	}

	protected int rand5(){
		int result = (int)(Math.random() * 5);
		return result;
	}
}