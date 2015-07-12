package moderate;

public class Computer{
	protected char[] colors = {'R', 'G', 'B', 'Y'};
	public char[] giveSolution(){
		// @note: this cast is important
		char[] result = new char[4];
		for(int i = 0; i < 4; i++){
			int index = (int) (Math.random() * 4);
			result[i] = colors[index];
		}
		return result;
	}


}