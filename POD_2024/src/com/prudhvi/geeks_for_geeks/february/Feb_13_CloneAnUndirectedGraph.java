package com.prudhvi.geeks_for_geeks.february;

import java.util.ArrayList;
import java.util.HashMap;

public class Feb_13_CloneAnUndirectedGraph {
	/**
	 * Clones a graph using depth-first search (DFS).
	 *
	 * Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges.
	 *                  The function visits each node and each edge once.
	 *
	 * Space Complexity: O(V), where V is the number of vertices.
	 *                   The space is used by the HashMap to store the mapping between original and cloned nodes.
	 *                   The maximum depth of the recursion stack is the maximum depth of the graph.
	 *
	 * @param node The root node of the original graph to be cloned.
	 * @return The root node of the cloned graph.
	 */
	public GraphNode cloneGraph(GraphNode node) {
	    if (node == null) {
	        return null;
	    }
	    // HashMap to store the mapping between original and cloned nodes.
	    HashMap<GraphNode, GraphNode> map = new HashMap<>();
	    // Create the root of the cloned graph.
	    GraphNode cloneNode = new GraphNode(node.val);
	    // Add the root node to the mapping.
	    map.put(node, cloneNode);
	    // Perform depth-first search to clone the entire graph.
	    dfs(node, cloneNode, map);
	    return cloneNode;
	}

	/**
	 * Recursive helper function to perform depth-first search and clone the graph.
	 *
	 * @param node The current original node being processed.
	 * @param cloneNode The corresponding cloned node.
	 * @param map The mapping between original and cloned nodes.
	 */
	public static void dfs(GraphNode node, GraphNode cloneNode, HashMap<GraphNode, GraphNode> map) {
	    for (GraphNode neighbor : node.neighbors) {
	        if (!map.containsKey(neighbor)) {
	            // If the neighbor has not been cloned, create a new cloned node and add it to the mapping.
	            GraphNode clone = new GraphNode(neighbor.val);
	            cloneNode.neighbors.add(clone);
	            map.put(neighbor, clone);
	            // Recursively clone the neighbor and its neighbors.
	            dfs(neighbor, clone, map);
	        } else {
	            // If the neighbor has already been cloned, add the cloned neighbor to the current cloned node.
	            cloneNode.neighbors.add(map.get(neighbor));
	        }
	    }
	}

    
    
}
class GraphNode{
    int val;
    ArrayList<GraphNode> neighbors;
    public GraphNode(){
        val = 0;
        neighbors = new ArrayList<>();
    }

    public GraphNode(int val){
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public GraphNode(int val, ArrayList<GraphNode> neighbors){
        this.val = val;
        this.neighbors = neighbors;
    }
}

