package treesAndGraphs;
import java.util.List;

public class HasRoute{

	public static boolean hasRoute(Graph g, GraphNode start, GraphNode end){
		// @note: @important: first should set all visited to false
		// set up:
		List<GraphNode> nodes = g.getNodes();
		for(GraphNode n : nodes){
			n.visited = false;
		}
		// do DFS
		boolean result = dfsHasRoute(start, end);
		return result;
	}

	// DFS: recursive
	public static boolean dfsHasRoute(GraphNode start, GraphNode end){
		if(start == null || end == null){
			throw new IllegalArgumentException("node is null");
		}
		
		start.visited = true;
		if(start == end){
			return true;
		}else{
			List<GraphNode> nodes = start.getAdjacent();
			for(GraphNode n : nodes){
				if(!n.visited){
					boolean result = dfsHasRoute(n, end);
					if(result){
						return true;
					}
				}
			}
			return false;
		}
	}
}