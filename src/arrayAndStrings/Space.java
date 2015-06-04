package arrayAndStrings;

public class Space{

	// not desiable, would take n squared time
	public void replaceSpace(char[] content, int length){
		for(int i=0; i<length; i++){
			if(content[i] == ' '){
				shift(content, i, length-1);
				content[i] = '%';
				content[i+1] = '2';
				content[i+2] = '0';
				i = i+2;
				length = length+2; 
			}
		}
	}

	public void shift(char[] content, int start, int end){
		for(int i=end; i>=start; i--){
			content[i+2] = content[i];
		}
	}

	public void replaceSpace1(char[] content, int length){
		int count = 0;
		for(int i=0; i<length; i++){
			if(content[i] == ' '){
				count++;
			}
		}
		int newLength = length+count*2;
		// @better: it's best to use c.
		// if you use java, it's good to end the string with \0
		content[newLength] = '\0';
		for(int i=length-1, j=newLength-1; i>=0; i--, j--){
			// @better: you could just use newLength as j. No need to create anotehr
			// variable j
			if(content[i] != ' '){
				content[j] = content[i];
			}else{
				content[j] = '0';
				content[j-1] = '2';
				content[j-2] = '%';
				j = j-2;
			}
		}

	}








}