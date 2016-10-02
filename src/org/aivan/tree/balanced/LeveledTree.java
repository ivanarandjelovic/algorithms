package org.aivan.tree.balanced;

import org.aivan.tree.base.Node;
import org.aivan.tree.simple.OrderedTree;

public class LeveledTree<T extends Comparable<T>> extends OrderedTree<T> {

	/**
	 * What is the maximum allowed height difference between two sub-trees. "2"
	 * means maximally balanced tree, but values >2 are also an option (needs to
	 * be tested).
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
			if (Math.abs(heightDifference) >= MAX_ALLOWED_HEIGHT_DIFFERENCE) {
				return heightDifference;
			} else {
				return 0;
			}
		}
		return 0;
	}

	private void rebalanceRightToLeft(Node<T> node) {
		Node<T> newRoot = node.right;
		Node<T> leftBranch = newRoot.left;

		// new root get's new left child and new parent:
		newRoot.left = node;
		if (node.parent != null) {
			newRoot.parent = node.parent;
			if(newRoot.parent.left == node) {
				newRoot.parent.left = newRoot;
			} else {
				newRoot.parent.right = newRoot;
			}
		} else {
			newRoot.parent = null;
			root = newRoot;
		}
		node.parent = newRoot;

		// old root get's new right branch:
		node.right = leftBranch;
		if (leftBranch != null) {
			leftBranch.parent = node;
		}

		// Re-calc levels:
		updateLevels(newRoot);

		// update height:
		updateHeight(node);
		updateHeight(newRoot);

		// What about node count?
		node.rightCount -= (newRoot.rightCount + 1);
		newRoot.leftCount += (node.leftCount + 1);

	}

	private void rebalanceLeftToRight(Node<T> node) {
		Node<T> newRoot = node.left;
		Node<T> rightBranch = newRoot.right;

		// new root get's new left child and new parent:
		newRoot.right = node;
		if (node.parent != null) {
			newRoot.parent = node.parent;
			if(newRoot.parent.left == node) {
				newRoot.parent.left = newRoot;
			} else {
				newRoot.parent.right = newRoot;
			}
		} else {
			newRoot.parent = null;
			root = newRoot;
		}
		node.parent = newRoot;

		// old root get's new left branch:
		node.left = rightBranch;
		if (rightBranch != null) {
			rightBranch.parent = node;
		}

		// Re-calc levels:
		updateLevels(newRoot);

		// update height:
		updateHeight(node);
		updateHeight(newRoot);

		// What about node count?
		node.leftCount -= (newRoot.leftCount + 1);
		newRoot.rightCount += (node.rightCount + 1);
	}

	private void updateLevels(Node<T> node) {
		if (node != null) {
			if (node.parent != null) {
				node.level = node.parent.level + 1;
			} else {
				node.level = 0;
			}
			updateLevels(node.left);
			updateLevels(node.right);
		}
	}

}
