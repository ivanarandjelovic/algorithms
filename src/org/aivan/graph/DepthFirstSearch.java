package org.aivan.graph;

import org.aivan.graph.base.Graph;
import org.aivan.graph.base.Vertex;

import java.util.Map;
import java.util.HashMap;
import java.lang.Integer;

public class DepthFirstSearch {

	public Graph graph;

	public Map<Vertex,Integer> startTimes = new HashMap<Vertex, Integer>(); 
	public Map<Vertex,Integer> endTimes = new HashMap<Vertex, Integer>(); 
	public Map<Vertex,Vertex> parents = new HashMap<Vertex, Vertex>(); 

	protected int time = 0;
	
	/**
	 * Perform DFS
	 */
	public void dfs() {
		time = 0;
		for(Vertex v : graph.vertices) {
			if(!startTimes.containsKey(v)) {
				// New node, not visited so far:
				visit(v);
			}
		}
	}

	protected void visit(Vertex v) {
		time++;
		startTimes.put(v,new Integer(time));
		for(Vertex c : v.edges) {
			if(!startTimes.containsKey(c)) {
				parents.put(c,v);
				visit(c);
			}
		}
		time++;
		endTimes.put(v,new Integer(time));
	}
}