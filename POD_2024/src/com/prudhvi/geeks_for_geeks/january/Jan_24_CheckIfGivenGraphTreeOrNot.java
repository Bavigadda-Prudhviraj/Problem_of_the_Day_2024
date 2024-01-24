package com.prudhvi.geeks_for_geeks.january;

import java.util.ArrayList;
import java.util.Arrays;

public class Jan_24_CheckIfGivenGraphTreeOrNot {

	public static void main(String[] args) {
		int n = 4, m = 3;
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		g.add(new ArrayList<>(Arrays.asList(0, 1)));
		g.add(new ArrayList<>(Arrays.asList(1, 2)));
		g.add(new ArrayList<>(Arrays.asList(1, 3)));
		System.out.println(isTree(n, m, g));

	}

	/**
	 * Checks if a given set of edges forms a tree.
	 *
	 * @param n      The number of nodes.
	 * @param m      The number of edges.
	 * @param edges  The list of edges as pairs of nodes.
	 * @return True if the edges form a tree, false otherwise.
	 * @TimeComplexity O(N + M), where N is the number of nodes and M is the number of edges.
	 * @SpaceComplexity O(N), where N is the number of nodes.
	 */
	public static boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
	    // Check if the number of edges is exactly n-1 (a tree condition)
	    if (m != n - 1)
	        return false;

	    // Initialize a Disjoint Set Union (DSU) data structure
	    Dsu dsu = new Dsu(n);

	    // Traverse each edge and perform union-find operations
	    for (int i = 0; i < m; i++) {
	        int u = edges.get(i).get(0);
	        int v = edges.get(i).get(1);

	        // Check if there is a cycle (both nodes are already in the same connected component)
	        if (dsu.isUnion(u, v)) {
	            return false; // Cycle detected, not a tree
	        } else {
	            dsu.union(u, v);
	        }
	    }

	    return true; // No cycle detected, forms a tree
	}

}

/**
 * Disjoint Set Union (DSU) data structure.
 */
class Dsu {
    int[] parent;

    // Constructor to initialize the DSU with each node as its own parent
    public Dsu(int nodes) {
        parent = new int[nodes];
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
    }

    // Check if two nodes are in the same connected component (have the same grandparent)
    public boolean isUnion(int u, int v) {
        int pu = grandParent(u);
        int pv = grandParent(v);
        return pu == pv;
    }

    // Find the grandparent of a node (with path compression)
    public int grandParent(int node) {
        if (node == parent[node])
            return node;

        return parent[node] = grandParent(parent[node]);
    }

    // Perform union operation to merge two connected components
    public void union(int u, int v) {
        int gpu = grandParent(u);
        int gpv = grandParent(v);

        // If the grandparent nodes are different, update the parent pointer to perform union
        if (gpu != gpv) {
            if (gpu < gpv)
                parent[gpv] = parent[gpu];
            else if (gpv < gpu)
                parent[gpu] = parent[gpv];
        }
    }
}