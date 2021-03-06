package org.aivan.sort.tree;

import org.aivan.sort.Sort;
import org.aivan.tree.base.Tree;
import org.aivan.tree.simple.OrderedTree;

/**
 * Implement sorting with simple ordered binary tree
 * @author aivan
 *
 * @param <T>
 */
public class OrderedTreeSort<T extends Comparable<T>> extends OrderedTree<T> implements Sort<T> {

	@Override
	public void sort(T[] array) {
		
		Tree<T> tree = new OrderedTree<T>();
		
		for(T el : array) {
			tree.add(el);
		}
		
		array = tree.getAll().toArray(array);
	}

}
