package moderate;

public class PhraseOfInteger{

	/**
	* @note: we can always append " " at the end of the word because
	* we can trim them all together in the end
	* @note: one way to deal with "and": set a flag and pass it along, to basicPhrase 
	* method
	* @note: 
	* 1.See the answer in the book: using arrays is a good method!
	* 2. sometimes focus too much on code reuse and repeated code, especially when there
	* are many edge cases in both situation. Trying to find a general solution to both will
	* often be even more complicated because of the edge cases: it's easy to neglect some
	*/
	public void print(int k){
		if(k < 0){
			System.out.print("negative ");
			k = -k;
		}
		printPhrase(k);
	}


	public void printPhrase(int k){
		StringBuilder sb = new StringBuilder();
		if(k == 0){
			System.out.println("zero");
		}
		// @note: should include equal
		if(k >= 1000000000){
			int b = k / 1000000000;
			sb.append(basicPhrase(b)).append(" billion ");
			k = k - 1000000000 * b;
		}
		if(k >= 1000000){
			int m = k / 1000000;
			sb.append(basicPhrase(m)).append(" million ");
			k = k - 1000000 * m;
		}
		if(k >= 1000){
			int t = k / 1000;
			sb.append(basicPhrase(t)).append(" thousand ");
			k = k - 1000 * t;
		}
		if(k >= 1){
			sb.append(basicPhrase(k));
		}
		String str = sb.toString().trim();
		System.out.println(str);
	}


	/**
	* k is smaller than 1 thousand
	* @note: 1.this is a mess: you'd better draw a diagram first for this kind 
	* of problem: many edge cases and branches
	* 2. should write test first
	* @note: "and" is really hard to deal with. Because you have not only this part,
	* you have other parts that more than 3 digit, which you won't even know when you 
	* are calling this method.
	*/
	protected StringBuilder basicPhrase(int k){
		StringBuilder sb = new StringBuilder();
		if(k == 0){
			// @note: account for 0
			return sb.append("zero");
		}
		int hundred = k / 100;
		int ty = k - 100 * hundred;
		int basic = 0;
		if(ty >= 20){
			ty = ty / 10;
			basic = k - 100 * hundred - ty * 10;
		}else if(ty >= 10){
			switch(ty){
				case 10:
					return sb.append("ten");
				case 11:
					return sb.append("eleven");
				case 12:
					return sb.append("twelve");
				default:
					ty = ty - 10;
					sb.append(tyWord(ty));
					sb.append("teen");
					return sb;
			}
		}else{
			ty = 0;
			// @note: should assign value to basic
			basic = k - 100 * hundred;
		}
		String shundred = translate(hundred);
		String sty = tyWord(ty);
		String sbasic = translate(basic);
		if(!shundred.equals("")){
			sb.append(shundred).append(" hundred");
		}
		if(!sty.equals("and")){
			sb.append(" ").append(sty).append("ty");
		}else{
			if(!sbasic.equals("") && !shundred.equals("")){
				sb.append(" and");
			}
		}
		if(!sbasic.equals("")){
			sb.append(" ").append(sbasic);
		}
		return sb;
	}

	/**
	* translate k to word, k is smaller than 10
	*/
	protected String translate(int k){
		switch(k){
			case 0:
				return "";
			case 1:
				return "one";
			case 2:
				return "two";
			case 3:
				return "three";
			case 4:
				return "four";
			case 5:
				return "five";
			case 6:
				return "six";
			case 7:
				return "seven";
			case 8:
				return "eight";
			case 9:
				return "nine";
			default: 
				throw new IllegalArgumentException();
		}
	}

	/**
	* k is smaller than 10, not including 1
	*/
	protected String tyWord(int k){
		switch(k){
			case 0:
				return "and";
			case 2: 
				return "twen";
			case 3:
				return "thir";
			case 4:
				return "four";
			case 5:
				return "fif";
			case 6: 
				return "six";
			case 7:
				return "seven";
			case 8:
			// @note: this is another edge case
				return "eigh";
			case 9:
				return "nine";
			default:
				throw new IllegalArgumentException();
		}
	}
}