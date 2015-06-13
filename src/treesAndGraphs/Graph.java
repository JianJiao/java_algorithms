package treesAndGraphs;
import java.util.List;

public class Graph{
	protected  List<GraphNode> nodes;

	public Graph(List<GraphNode> nodes){
		this.nodes = nodes;
	}

	public List<GraphNode> getNodes(){
		return this.nodes;
	}

}