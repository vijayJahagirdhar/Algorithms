package vijay.ds.trees;

import java.util.ArrayList;
import java.util.List;

public class RecursiveRelationToFindHeight {
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
		Node n8 =new Node('i',null,null);
		Node n4 =new Node('d',null,n8);
		Node n3 =new Node('c',n6,n7); 
		Node n2 =new Node('b',n4,n5); 
		Node n1 =new Node('a',n2,n3); 

		/*// 1. to find the height of node 

		int height=findHeight(n1);
		System.out.println("Height of root Node is: "+height);

		// 2.To count number of nodes

		int count = noOfNodes(n1);
		System.out.println("Number of nodes are : "+count);

		// 3.To count number of leaves
		int countNoOfleaf = findLeafCount(n1);
		System.out.println("Number of leaves are : "+countNoOfleaf);

		// 4.To count number of non leaves
		int countNoOfNonLeaves =findNonLeafCount(n1);
		System.out.println("Number of Non Leaves  are : "+countNoOfNonLeaves);

		// 5. To count number of full nodes
		int countNoOfFUllNodes = findFullNodes(n1);
		System.out.println("Number of full Nodes are  : "+countNoOfFUllNodes);
*/
		//Example 1.
		//Find out first unique character in string...
		/*	String val = "k";
		char[] charArr = val.toCharArray();
		char res = findFirstOccurence(charArr);
		if(res == '\0') System.out.println("No unique element found");
		else System.out.println("the first unique element found is  : "+ res );*/
		
		//Ex2: find the max sub array ..
		findMaxSubArray();
	}

	static int temp=0;
	private static void findMaxSubArray() {
	   int[] arr= new int[] {1,2,3,4,5,6,7,8,9};
	   int sumVal = 12;
	   int sum = 0;
	   int x=0,y=0;
	   boolean present = false;
	   temp= arr.length;
	   for(int i=0;i<temp;i++) {
		   System.out.print(arr[i]+" -> ");
		   printSubArraySum(arr,temp);
		   sum = arr[i];
		   System.out.print(sum+" ");
		   for(int j=i+1;j<temp;j++) {
			   sum += arr[j];
			   System.out.print(sum+" ");
			   if(sum == sumVal) {
				   x=i;y=j;
				   present=true;
				   break;
			   }
			   else if (sum > sumVal) {
				   temp = j+1;
				   break;
			   }
			   else
				   continue;
		   }
		   if(present) break;
		   System.out.println();
	   }
	   
	   if(present)
	     System.out.println("SubArray for sum "+sumVal+" exist between ["+(x+1)+","+(y+1)+"]");		
	}

	private static void printSubArraySum(int[] arr, int temp2) {
		for(int i=0;i<temp;i++) 
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	private static int findFullNodes(Node temp) {
		if(temp==null)
			return 0;
		if(temp.leftnode != null && temp.rightNode != null) 
			return findFullNodes(temp.leftnode)+findFullNodes(temp.rightNode)+1;
		else if(temp.leftnode == null && temp.rightNode==null) 
			return 0;
		else {
			if(temp.leftnode!=null)
				return findFullNodes(temp.leftnode);
			else if(temp.rightNode!=null)
				return findFullNodes(temp.rightNode);
		}
		return -1;
	}

	private static int findNonLeafCount(Node temp) {
		if(temp==null)
			return 0;
		if(temp.leftnode==null && temp.rightNode==null) 
			return 0;
		else 
			return findNonLeafCount(temp.leftnode)+findNonLeafCount(temp.rightNode)+1;    	  
	}

	private static int findLeafCount(Node temp) {
		if(temp == null) return 0;
		if(temp.leftnode==null  && temp.rightNode==null)
			return 1;
		else 
			return findLeafCount(temp.leftnode)+findLeafCount(temp.rightNode);
	}

	private static char findFirstOccurence(char[] charArr) {
		char res = '\0'; 
		boolean status;
		List val = new ArrayList(); 
		for(int i=0;i<charArr.length;i++) {
			status=false;
			if(!val.contains(charArr[i])) {   
				for(int j=i+1;j<charArr.length;j++) {
					if(charArr[i]==charArr[j] && val.contains(charArr[j])==false) { 
						status = true;
						val.add(charArr[i]);
					}
				}
				if(status == false) {
					res = charArr[i];
					return res;
				}
			}
		}
		return res;
	}

	private static int noOfNodes(Node n1) {
		if(n1==null) return 0;
		if(n1.leftnode==null && n1.rightNode==null) return 1;
		else 
			return noOfNodes(n1.leftnode)+noOfNodes(n1.rightNode)+1;
	}

	public static int count=0;
	/*private static int findHeight(Node temp) {
		if(temp == null) 
			return 0;
		
	}*/
}
