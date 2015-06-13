package treesAndGraphs;
import java.util.List;
import java.util.ArrayList;

public class RandomTest{
	protected List<GraphNode> adjacent;


	public List<GraphNode> getList(){
		return adjacent;
	}

	public void useList(){
		List<GraphNode> ll = getList();
	}

	public static void main(String[] args){
		GraphNode node = new GraphNode<Integer>(4);
		List<GraphNode> l = new ArrayList<GraphNode>();
		l.add(node);
		List nodes = node.getAdjacent();
	}
}