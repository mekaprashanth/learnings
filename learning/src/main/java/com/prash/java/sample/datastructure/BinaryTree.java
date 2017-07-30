/**
 * 
 */
package com.prash.java.sample.datastructure;

/**
 * @author Prashanth_Meka
 *
 */
public class BinaryTree {
	
	private Node root;
	
	class Node	{
		int value;
		String name;
		
		Node left;
		Node right;
		
		Node(String name,int value)	{
			this.value = value;
			this.name = name;
		}
		
		@Override
		public String toString() {
			return "Node with name "+name+" value "+ value;
		}
	}
	
	public void addNode(String name, int value)	{
		Node node = new Node(name, value);
	
		if(root == null)	{
			root = node;
		}else	{
			Node focusNode = root;
			Node parent;
			while(true){
				parent = focusNode;
				if(value<focusNode.value)	{
					focusNode = focusNode.left;
					if(focusNode == null)	{
						parent.left = node;
						return;
					}
				}else	{
					focusNode = focusNode.right;
					if(focusNode == null)	{
						parent.right = node;
						return;
					}
				}
			}
		}
	}
	
	public void inOrderTraversal(Node focusNode)	{
		if(focusNode != null)	{
			inOrderTraversal(focusNode.left);
			System.out.println(focusNode);
			inOrderTraversal(focusNode.right);
		}
	}
	
	public void preOrderTraversal(Node focusNode)	{
		if(focusNode != null)	{
			System.out.println(focusNode);
			preOrderTraversal(focusNode.left);
			preOrderTraversal(focusNode.right);
		}
	}
	
	public void postOrderTraversal(Node focusNode)	{
		if(focusNode != null)	{
			postOrderTraversal(focusNode.left);
			postOrderTraversal(focusNode.right);
			System.out.println(focusNode);
		}
	}
	
	public Node findNode(int value)	{
		Node focusNode = root;
		while(focusNode.value != value)	{
			if(focusNode.value > value)	{
				focusNode = focusNode.left;
			}else	{
				focusNode = focusNode.right;
			}
			
			if(focusNode == null)	{
				return null;
			}
		}
		return focusNode;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		tree.addNode("SVP", 3);
		tree.addNode("Architect", 5);
		tree.addNode("DM", 4);
		tree.addNode("Employee", 7);
		tree.addNode("Manager", 6);
		tree.addNode("CEO", 1);
		tree.addNode("VP", 2);
		
		
		System.out.println(tree.findNode(6));
	}

}
