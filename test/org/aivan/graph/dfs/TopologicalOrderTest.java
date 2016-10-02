package org.aivan.graph.dfs;

import org.aivan.graph.base.*;
import org.aivan.graph.*;

import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

public class TopologicalOrderTest {

	@Test
	public void clothingTest() {
		
		Graph g = new Graph();
		
		Vertex undershorts = new Vertex("undershorts");
		Vertex pants = new Vertex("pants");
		Vertex belt = new Vertex("belt");
		Vertex shirt = new Vertex("shirt");
		Vertex tie = new Vertex("tie");
		Vertex jacket = new Vertex("jacket");
		Vertex socks = new Vertex("socks");
		Vertex shoes = new Vertex("shoes");
		Vertex watch = new Vertex("watch");
		
		undershorts.edges.add(pants);
		undershorts.edges.add(shoes);
		
		pants.edges.add(belt);
		pants.edges.add(shoes);
		
		belt.edges.add(jacket);
		
		shirt.edges.add(belt);
		shirt.edges.add(tie);
		
		tie.edges.add(jacket);
		
		socks.edges.add(shoes);
		
		g.vertices.add(undershorts);
		g.vertices.add(pants);
		g.vertices.add(belt);
		g.vertices.add(shirt);
		g.vertices.add(tie);
		g.vertices.add(jacket);
		g.vertices.add(socks);
		g.vertices.add(shoes);
		g.vertices.add(watch);
		
		DepthFirstSearch dfs = new DepthFirstSearch();
		dfs.graph = g;
		dfs.dfs();
		
		// Now extract vertices by endTime (in reverse order):
		SortedMap<Integer,Vertex> sortedMap = new TreeMap<Integer,Vertex>();
		for(Vertex v : dfs.endTimes.keySet()) {
			sortedMap.put(dfs.endTimes.get(v), v);
		}
		while(sortedMap.size()>0) {
			Integer time = sortedMap.lastKey();
			Vertex v = sortedMap.get(time);
			sortedMap.remove(time);
			System.out.println(v.value+" at "+time);
		}
		
	}

}