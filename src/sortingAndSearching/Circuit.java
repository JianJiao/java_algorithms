package sortingAndSearching;

public class Circuit{

	protected int[] max;

	public int maxTower(Person[] pers){
		this.max = new int[pers.length];
		int childMaxResult = 0;
		for(int i = 0; i < pers.length; i++){
			int childResult = maxTowerHelper(i, pers);
			if(childResult > childMaxResult){
				childMaxResult = childResult;
			}
		}
		return childMaxResult;
	}

	/**
	* max tower height using per as the base
	*/
	protected int maxTowerHelper(int i, Person[] pers){
		if(max[i] != 0){
			return max[i];
		}

		int childMaxTower = 0;
		for(int j = 0; j < pers.length; j++){
			if(valid(pers[j], pers[i])){
				int childResult = maxTowerHelper(j, pers);
				if(childResult > childMaxTower){
					childMaxTower = childResult;
				}
			}
		}
		int result = childMaxTower + 1;
		max[i] = result;
		return result;
	}


	protected boolean valid(Person above, Person below){
		if(above == null || below == null){
			return false;
		}
		if(above.ht > below.ht && above.wt > below.wt){
			return true;
		}else{
			return false;
		}
	}

}

