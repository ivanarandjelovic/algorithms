package org.aivan.tree.balanced;

import org.aivan.tree.base.Node;
import org.aivan.tree.simple.OrderedTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

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

//			log.debug("Imbalance detected, node: " + node.value + ", leftCount = " + node.leftCount + ", rightCount = "
//			    + node.rightCount);

			moveNodeFromLeftToRight(node);

//			log.debug("Imbalance corrected, node: " + node.value + ", leftCount = " + node.leftCount + ", rightCount = "
//			    + node.rightCount);

		} else if (node.rightCount != 0 && (node.rightCount - node.leftCount) >= 2
		    && (node.leftCount * 100.0f) / node.rightCount < (100 - DEBALANCE_LIMIT_IN_PERCENT)) {
			// Right tree is "heavier" (see previous branch for detailed explanation)

//			log.debug("Imbalance detected, node: " + node.value + ", leftCount = " + node.leftCount + ", rightCount = "
//			    + node.rightCount);

			moveNodeFromRightToLeft(node);

//			log.debug("Imbalance corrected, node: " + node.value + ", leftCount = " + node.leftCount + ", rightCount = "
//			    + node.rightCount);

		}
	}

	private void moveNodeFromLeftToRight(Node<T> node) {
//		System.out.println("Before LR move");
//		this.print();
		// Obtain min node from left three:
		assert (node.left != null);
		Node<T> maxNode = popMaxNode(node.left);
//		System.out.println("After popMaxm chosen :"+maxNode.value);
//		this.print();

		// update our node count (pop operation did it only starting from the left
		// child):
		node.leftCount--;

		T value = node.value;
		int count = node.count;
		node.value = maxNode.value;
		node.count = maxNode.count;

		// Re add old root to new root (will go to right three for sure):
		add(node, value, count);
//		System.out.println("After LR move");
//		this.print();
	}

	private void moveNodeFromRightToLeft(Node<T> node) {
//		System.out.println("Before RL move");
//		this.print();
		// Obtain min node from left three:
		assert (node.right != null);
		Node<T> minNode = popMinNode(node.right);
//		System.out.println("After popMin: chosen :"+minNode.value);
//		this.print();
		// update our node count (pop operation did it only starting from the left
		// child):
		node.rightCount--;

		T value = node.value;
		int count = node.count;
		node.value = minNode.value;
		node.count = minNode.count;

		// Re add old root to new root (will go to left three for sure):
		add(node, value, count);
//		System.out.println("After RL move");
//		this.print();
	}

	private Node<T> popMaxNode(Node<T> node) {
//		System.out.println("popMax considering: "+node.value);
		Node<T> result = null;
		if (node.right == null) {
			result = node;
			// This is it, we are the node in question.
			// Parent will take our left children (we don't have right children)
			if (node.parent == null) {
				// We are root
//				System.out.println("popMax, node was root");
				root = node.left;
				node.left.parent = null;
			} else {
				if (node.parent.left == node) {
//					System.out.println("popMax, parent left to left, " + node.parent.value + " to "
//					    + (node.left != null ? node.left.value : null));
					node.parent.left = node.left;
					if (node.left != null) {
						node.left.parent = node.parent;
					}
				} else {
//					System.out.println("popMax, parent right to left, " + node.parent.value + " to "
//					    + (node.left != null ? node.left.value : null));
					node.parent.right = node.left;
					if (node.left != null) {
						node.left.parent = node.parent;
					}
				}
			}
			decrementLevels(node.left);
			// Cleanup result node:
			node.parent = null;
			node.left = null;
			node.right = null;
		} else {
			result = popMaxNode(node.right);
			// Update our balance count:
			node.rightCount--;
			checkNodeBalance(node);
		}
		return result;
	}

	private Node<T> popMinNode(Node<T> node) {
//		System.out.println("popMin considering: "+node.value);
		Node<T> result = null;
		if (node.left == null) {
			result = node;
			// This is it, we are the node in question:
			// Parent will take our right children (we don't have left children)
			if (node.parent == null) {
//				System.out.println("popMin, node was root");
				// We are root
				root = node.right;
				node.right.parent = null;
			} else {
				if (node.parent.left == node) {
//					System.out.println("popMin, parent left to right, " + node.parent.value + " to "
//					    + (node.right != null ? node.right.value : null));
					node.parent.left = node.right;
					if (node.right != null) {
						node.right.parent = node.parent;
					}
				} else {
//					System.out.println("popMin, parent right to right, " + node.parent.value + " to "
//					    + (node.right != null ? node.right.value : null));
					node.parent.right = node.right;
					if (node.right != null) {
						node.right.parent = node.parent;
					}
				}
			}
			decrementLevels(node.right);
			// Cleanup result node:
			node.parent = null;
			node.left = null;
			node.right = null;
		} else {
			result = popMinNode(node.left);
			// Update our balance count:
			node.leftCount--;
			checkNodeBalance(node);
		}
		return result;
	}

}
