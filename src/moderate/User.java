package moderate;

public class User{
	char[] colors = {'R', 'G', 'B', 'Y'};
	public char[] guess(){
		char[] result = new char[4];
		for(int i = 0; i < 4; i++){
			int index = (int) (Math.random() * 4);
			result[i] = colors[index];
		}
		return result;
	}
}