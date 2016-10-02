package org.aivan.tree.balanced;

import org.aivan.tree.base.Node;
import org.aivan.tree.simple.OrderedTree;

public class LeveledTree<T extends Comparable<T>> extends OrderedTree<T> {

	/**
	 * What is the maximum allowed height difference between two sub-trees. "2" means maximally balanced tree,
	 * but values >2 are also an option (needs to be tested).
	 */
	private static final int MAX_ALLOWED_HEIGHT_DIFFERENCE = 2;

	@Override
	protected boolean add(Node<T> node, T element, int elementCount) {

		boolean nodeReallyAdded = super.add(node, element, elementCount);

		if (nodeReallyAdded) {
			// Now is the time to check if current node height balance is correct
			int balanceDirection = checkNodeBalance(node);
			if (balanceDirection != 0) {
				if (balanceDirection < 0) {
					rebalanceRightToLeft(node);
				} else {
					rebalanceLeftToRight(node);
				}
			}
		}

		return nodeReallyAdded;
	}


	private int checkNodeBalance(Node<T> node) {
		if (node != null) {
			int leftHeight = (node.left != null ? node.left.height : 0);
			int rightHeight = (node.right != null ? node.right.height : 0);
			int heightDifference = leftHeight - rightHeight;
			if(Math.abs(heightDifference)>MAX_ALLOWED_HEIGHT_DIFFERENCE) {
				return heightDifference;
			} else {
				return 0;
			}
		}
		return 0;
	}
	
	private void rebalanceLeftToRight(Node<T> node) {
		// TODO Auto-generated method stub
		
	}

	private void rebalanceRightToLeft(Node<T> node) {
		// TODO Auto-generated method stub
		
	}


}
