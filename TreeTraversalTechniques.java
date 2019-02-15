package vijay.ds.trees;
public class TreeTraversalTechniques {
	static class Node{
		 char data;
		 Node leftnode;
		 Node rightNode;

		 public Node(char data, Node leftnode, Node rightNode) {
			super();
			this.data = data;
			this.leftnode = leftnode;
			this.rightNode = rightNode;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", leftnode=" + leftnode + ", rightNode=" + rightNode + "]";
		}
		 
		public char getData() {
			return data;
		}
		public void setData(char data) {
			this.data = data;
		}
		public Node getLeftnode() {
			return leftnode;
		}
		public void setLeftnode(Node leftnode) {
			this.leftnode = leftnode;
		}
		public Node getRightNode() {
			return rightNode;
		}
		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}
		 
		 
	}
	
	public static void main(String[] args) {
	
     //Constructing a tree;
    	Node n7 =new Node('g',null,null);  
    	Node n6 =new Node('f',null,null); 
    	Node n5 =new Node('e',null,null); 
    	Node n4 =new Node('d',null,null); 
    	Node n3 =new Node('c',n6,n7); 
    	Node n2 =new Node('b',n4,n5); 
    	Node n1 =new Node('a',n2,n3); 
    
    	//print inorder Traversal
    	System.out.println("-------------------------------------------------------------");
    	System.out.println("INORDER : ");
    	inorder(n1);
    	System.out.println("\n-------------------------------------------------------------");
    	System.out.println("PREORDER : ");
    	preorder(n1);
    	System.out.println("\n-------------------------------------------------------------");
    	System.out.println("POSTORDER : ");
    	postorder(n1);
	}
	
	private static void postorder(Node node) {
		if(node!=null) {
			postorder(node.leftnode);
			postorder(node.rightNode);
			System.out.print(node.data+" ");
		}
	}

	private static void preorder(Node node) {
		if(node!=null) {
			System.out.print(node.data+" ");
			preorder(node.leftnode);
			preorder(node.rightNode);
		}
	}

	public static void inorder(Node node) {
		if(node != null) {
			inorder(node.leftnode);
			System.out.print(node.data+" ");
			inorder(node.rightNode);
		}
	}

}
