package org.aivan.sort.tree;

import org.aivan.sort.Sort;
import org.aivan.sort.SortTest;
import org.aivan.tree.balanced.BalancedOrderedTree;
import org.aivan.tree.base.Tree;
import org.aivan.tree.simple.OrderedTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Implement sorting with simple ordered binary tree
 * 
 * @author aivan
 *
 * @param <T>
 */
public class BalancedTreeSort<T extends Comparable<T>> extends OrderedTree<T> implements Sort<T> {

	public static final Logger log = LogManager.getLogger(BalancedTreeSort.class);
	
	@Override
	public void sort(T[] array) {

		Tree<T> tree = new BalancedOrderedTree<T>();

		for (T el : array) {
			tree.add(el);
		}

		array = tree.getAll().toArray(array);

//		int maxHeight = tree.getMaxHeight();
//		log.debug("tree max height: " + maxHeight);

	}

}
