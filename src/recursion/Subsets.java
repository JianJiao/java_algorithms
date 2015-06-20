package recursion;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class Subsets{

	/**
	* return a list of subsets, or null if the input is null
	* @assume: we are using hashset
	*/
	public List<Set> subSets(Set set){
		// check arg
		if(set == null){
			return null;
		}
		List<Set> l;
		// stop:
		if(set.size() == 0){
			l = new ArrayList<Set>();
			Set empty = new HashSet();
			l.add(empty);
			return l;
		}
		// prepare set
		Object first = set.iterator().next();
		set.remove(first);
		// recursive call
		l = subSets(set);
		// deal with results
		int size = l.size();
		for(int i = 0; i < size; i++){
			HashSet copySet = new HashSet();
			copySet.addAll(l.get(i));
			l.add(copySet);
		}
		for(int i= 0; i < size; i++){
			l.get(i).add(first);
		}
		// restore
		set.add(first);
		return l;
	}

}