package org.aivan.tree.balanced;

import org.aivan.tree.base.Node;
import org.aivan.tree.simple.OrderedTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BalancedOrderedTree<T extends Comparable<T>> extends OrderedTree<T> {

	public static final Logger log = LogManager.getLogger(BalancedOrderedTree.class);

	/**
	 * How mich percentage of difference we allow between two branches
	 */
	private static final float DEBALANCE_LIMIT_IN_PERCENT = 10;

	@Override
	protected void add(Node<T> node, T element) {
		// TODO Auto-generated method stub
		super.add(node, element);
		// Now, does current node requires re-balancing?
		checkNodeBalance(node);
	}

	@Override
	protected boolean delete(Node<T> node, T element) {
		// TODO Auto-generated method stub
		boolean result = super.delete(node, element);
		// This might affected node balance
		if (result) {
			checkNodeBalance(node);
		}
		return result;
	}

	private void checkNodeBalance(Node<T> node) {
		if (node.leftCount != 0 && (node.leftCount - node.rightCount) >= 2
		    && (node.rightCount * 100.0f) / node.leftCount < (100 - DEBALANCE_LIMIT_IN_PERCENT)) {
			// So, there are left nodes, there are at least two more then on the right
			// side and the
			// right side has less nodes for at least DEBALANCE_LIMIT_IN_PERCENT
			// percent

			log.debug("Imbalance detected, node: " + node.value + ", leftCount = " + node.leftCount + ", rightCount = "
			    + node.rightCount);

			moveNodeFromLeftToRight(node);

			log.debug("Imbalance corrected, node: " + node.value + ", leftCount = " + node.leftCount + ", rightCount = "
			    + node.rightCount);

		} else if (node.rightCount != 0 && (node.rightCount - node.leftCount) >= 2
		    && (node.leftCount * 100.0f) / node.rightCount < (100 - DEBALANCE_LIMIT_IN_PERCENT)) {
			// Right tree is "heavier" (see previous branch for detailed explanation)

			log.debug("Imbalance detected, node: " + node.value + ", leftCount = " + node.leftCount + ", rightCount = "
			    + node.rightCount);

			moveNodeFromRightToLeft(node);

			log.debug("Imbalance corrected, node: " + node.value + ", leftCount = " + node.leftCount + ", rightCount = "
			    + node.rightCount);

		}
	}

	private void moveNodeFromLeftToRight(Node<T> node) {
		// Obtain min node from left three:
		assert (node.left != null);
		Node<T> maxNode = popMaxNode(node.left);
		// update our node count (pop operation did it only starting from the left
		// child):
		node.leftCount--;

		T value = node.value;
		int count = node.count;
		node.value = maxNode.value;
		node.count = maxNode.count;

		// Re add old root to new root (will go to right three for sure):
		add(node, value, count);
	}

	private void moveNodeFromRightToLeft(Node<T> node) {
		// Obtain min node from left three:
		assert (node.right != null);
		Node<T> minNode = popMinNode(node.right);
		// update our node count (pop operation did it only starting from the left
		// child):
		node.rightCount--;

		T value = node.value;
		int count = node.count;
		node.value = minNode.value;
		node.count = minNode.count;

		// Re add old root to new root (will go to left three for sure):
		add(node, value, count);
	}

	private Node<T> popMaxNode(Node<T> node) {
		Node<T> result = null;
		if (node.right == null) {
			result = node;
			// This is it, we are the node in question.
			// Parent will take our left children (we don't have right children)
			if (node.parent == null) {
				// We are root
				root = node.left;
			} else {
				if (node.parent.left == node) {
					node.parent.left = node.left;
				} else {
					node.parent.right = node.left;
				}
			}
			// Cleanup result node:
			node.parent = null;
			node.left = null;
			node.right = null;
		} else {
			result = popMaxNode(node.right);
			// Update our balance count:
			node.rightCount--;
		}
		return result;
	}

	private Node<T> popMinNode(Node<T> node) {
		Node<T> result = null;
		if (node.left == null) {
			result = node;
			// This is it, we are the node in question:
			// Parent will take our right children (we don't have left children)
			if (node.parent == null) {
				// We are root
				root = node.right;
			} else {
				if (node.parent.left == node) {
					node.parent.left = node.right;
				} else {
					node.parent.right = node.right;
				}
			}
			// Cleanup result node:
			node.parent = null;
			node.left = null;
			node.right = null;
		} else {
			result = popMaxNode(node.left);
			// Update our balance count:
			node.leftCount--;
		}
		return result;
	}

}
