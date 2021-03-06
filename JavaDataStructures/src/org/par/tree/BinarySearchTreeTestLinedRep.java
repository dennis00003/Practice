package org.par.tree;



/**
 * Average search runtime f(n)=O(log n). Same for insert/delete
 * 
 * @author Harinder Singh Bedi
 *
 */
public class BinarySearchTreeTestLinedRep {

	public static void main(String[] args) {
		new BinarySearchTreeTestLinedRep().run();


	}

	static class Node {
		Node left;

		Node right;

		int value;

		public Node(int value) {
			this.value = value;
		}
	}

	public void run() {
		Node root = new Node(5);
		System.out.println("Binary Tree Example");
		System.out.println("Building tree with root value " + root.value);
		insert(root, 1);
		insert(root, 8);
		insert(root, 6);
		insert(root, 3);
		insert(root, 9);
		System.out.println("Traversing tree Preorder");
		printPreOrder(root);
		System.out.println("Traversing tree Inorder");
		printInOrder(root);
		System.out.println("Traversing tree Postorder");
		printPostOrder(root);
		System.out.println("Traversing tree front-to-back from location 7");
		
		Node foundNode=find(3, root);
		
		if(foundNode!=null)
		{
			System.out.println("Node found");
		}
		else {
			System.out.println("Node not found");
		}
		
		if (isBST(root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");

	}

	public void insert(Node node, int value) {
		if (value < node.value) {
			if (node.left != null) {
				insert(node.left, value);
			} else {
				System.out.println("  Inserted " + value + " to left of "
						+ node.value);
				node.left = new Node(value);
			}
		} else if (value > node.value) {
			if (node.right != null) {
				insert(node.right, value);
			} else {
				System.out.println("  Inserted " + value + " to right of "
						+ node.value);
				node.right = new Node(value);
			}
		}
	}


	// NLR
	public void printPreOrder(Node node) {
		if (node != null) {
			System.out.println("  Traversed " + node.value);
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}

	// LNR
	public void printInOrder(Node node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.println("  Traversed " + node.value);
			printInOrder(node.right);
		}
	}


	// LRN
	public void printPostOrder(Node node) {
		if (node != null) {
			printPostOrder(node.left);		
			printPostOrder(node.right);
			System.out.println("  Traversed " + node.value);
		}
	}

	public Node find(int val,Node root)
	{
		Node focusNode=root;

		while (focusNode!=null && focusNode.value!=val)
		{
			if(val<focusNode.value)
				focusNode=focusNode.left;
			else {
				focusNode=focusNode.right;
			}			

		}

		return focusNode;
	}

	/* returns true if given search tree is binary
    search tree (efficient version) */
   boolean isBST(Node root)  {
       return isBSTUtil(root, Integer.MIN_VALUE,
                              Integer.MAX_VALUE);
   }

   /* Returns true if the given tree is a BST and its
     values are >= min and <= max. */
   boolean isBSTUtil(Node node, int min, int max)
   {
       /* an empty tree is BST */
       if (node == null)
           return true;

       /* false if this node violates the min/max constraints */
       if (node.value < min || node.value > max)
           return false;

       /* otherwise check the subtrees recursively
       tightening the min/max constraints */
       // Allow only distinct values
       return (isBSTUtil(node.left, min, node.value-1) &&
               isBSTUtil(node.right, node.value+1, max));
   }


}
