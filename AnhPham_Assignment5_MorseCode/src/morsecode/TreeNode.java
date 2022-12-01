package morsecode;

public class TreeNode<T> {

	private T data;
	protected TreeNode<T> childLeft;
	protected TreeNode<T> childRight;
	
	/**
	 * TreeNode<T>
	 * @param dataNode
	 */
	public TreeNode(T dataNode) {
		data = dataNode;
		childLeft = null;
		childRight = null;
	}
	
	/**
	 * TreeNode()
	 * Copy nodes
	 * @param node
	 */
	public TreeNode(TreeNode<T> node) {
		data = node.data;
		childLeft = node.childLeft;
		childRight = node.childRight;
	}

/**
 * getData 
 * @return data 
 */
	
public T getData() {
	return data;
}
}