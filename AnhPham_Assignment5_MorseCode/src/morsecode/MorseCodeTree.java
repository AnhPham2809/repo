package morsecode;

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
 private TreeNode<String> root;
 
 //Constructor
 public MorseCodeTree() {
	 root = null;
	 buildTree();
 }
 
 /**
  * getRoot()
  * @returns refrence to root
  */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	/**
	 * setRoot()
	 * set the root of the MorseCodeTree
	 * @param newNode
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = new TreeNode<String>(newNode);
		
	}

	/**
	 * insert()
	 * @param code, result
	 * adds element to the tree
	 */
	@Override
	public void insert(String code, String letter) { //in java doc it was String letter not String result so I change it.
		if(root == null) { //  check empty
			root = new TreeNode<String>(letter);
		}
		else
		{
			addNode(root, code, letter);
		}
	}

	/**
	 * addNode()
	 * Adds the node to the tree.
	 * @param root, code, letter
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.length() > 1) {
			if(code.charAt(0) == '-') {
				addNode(root.childRight, code.substring(1), letter);
			}
			else {
				addNode(root.childLeft, code.substring(1), letter);
			}
		}
		
		else {
			if(code.equals(".")) {
				root.childLeft = new TreeNode<String>(letter);
			}
			else {
				root.childRight = new TreeNode<String>(letter);
			}
		}
		
	}

	/**
	 * fetch()
	 * Fetch the letter/results in the tree and return it
	 */
	@Override
	public String fetch(String code) {
		String a = fetchNode(root, code);
		return a;
	}
	
	/**
	 * fetchNode()
	 * @returns the string/letter of the node
	 * @param root, code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String letter = "";
		if(code.length() > 1) {
			if(code.charAt(0)== '.') { //Character
				letter += fetchNode(root.childLeft, code.substring(1));
			}
			else {
				letter += fetchNode(root.childRight, code.substring(1));
			}
		}
		else {
			if(code.equals(".")) {//String
				letter += root.childLeft.getData();
				return letter;
			}
			
			else {
				letter += root.childRight.getData();
				return letter;
			}
		}
		return letter;
	}

	/**
	 * delete()
	 * Not supported in MorseCodeTree??
	 * @throws UnsupportedOperationException;
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * update()
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * buildTree()
	 * Build the tree based on node inserted.
	 */
	@Override
	public void buildTree() {
		setRoot(new TreeNode<String>(""));
		insert("","");
		//Level 1
		insert(".", "e"); //1
		insert("-", "t"); //2
		
		//Level 2
		insert("..", "i"); //3
		insert(".-", "a"); //4
		insert("-.", "n"); //5
		insert("--", "m"); //6
		
		//Level 3
		insert("...", "s"); //7
		insert("..-", "u"); //8
		insert(".-.", "r"); //9
		insert(".--", "w"); // 10
		insert("-..", "d"); //11
		insert("-.-", "k"); //12
		insert("--.", "g"); //13
		insert("---", "o"); //14
		
		//Level 4
		insert("....", "h"); //15
		insert("...-", "v"); //16
		insert("..-.", "f"); //17
		insert(".-..", "l"); //18
		insert(".--.", "p"); //19
		insert(".---", "j"); //20
		insert("-...", "b"); //21
		insert("-..-", "x"); //22
		insert("-.-.", "c"); //23
		insert("-.--", "y"); //24
		insert("--..", "z"); //25
		insert("--.-", "q"); //26
	}

	/**
	 * toArrayList()
	 * @returns arraylist of items in the tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> beer = new ArrayList<String>();
		LNRoutputTraversal(root, beer); //haha get it root beer
		return beer;
	}

	/**
	 * LNRoutputTraversal
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 * @param root of the tree
	 * @param list arraylist to store the items of the tree in order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root.childLeft == null && root.childRight == null) {
			list.add(root.getData() + " ");
}
		else {
			if(root.childLeft != null) {
				LNRoutputTraversal(root.childLeft, list);
				list.add(root.getData() + " ");
			}
			if(root.childRight != null) {
				LNRoutputTraversal(root.childRight, list);
			}
		}
		
	}

}
