package treesAndGraphs;
import java.util.List;
import java.util.ArrayList;

public class GraphNode<T>{
	protected T item;
	protected List<GraphNode> adjacent;
	protected boolean visited;

	public GraphNode(T item){
		this(item, null);
	}

	public GraphNode(T item, List<GraphNode> adjacent){
		this.item = item;
		this.adjacent = adjacent;
	}

	public List<GraphNode> getAdjacent(){
		if(adjacent == null){
			adjacent = new ArrayList<GraphNode>();
		}
		return adjacent;
	}

}