package greedyAlgos.ex;

import java.awt.geom.GeneralPath;

/*public class HuffmanCodes {
	private static int[] A;
	private static int heapSize;
	public static void main(String[] args) {
		System.out.println("Before building heap");
		A = new int[] {45,13,12,16,9,5}; 
		heapSize=A.length;
		print();
		buildMinHeap();
		System.out.println("Result : ");
		print();
		int ans = huffman_codes();
		System.out.println("result of hufman code : ");
		System.out.println("Ans : "+ans);
		System.out.println();
		System.out.println("------------------------------");
		for(int i=0;i<A.length;i++) {
			System.out.print(A[i]+" ");
		}
	}
	public static int huffman_codes() {
		int ans = 0;
		for(int i=0;i<A.length-1;i++) {
			int left  = extractMin();
			int right = extractMin();
			int root  =   left + right;
			ans=root;
			insertMinHeap(root);
			print();
		}
		return ans;
	}
	public static void insertMinHeap(int key) {
		A[heapSize] = key;
		heapSize=heapSize+1;
		int i= heapSize;
		System.out.println();
		while(Math.floor(i/2)-1>=0) {
			i = (int) (Math.floor(i/2)-1);
			minHeapify(i);
		}
	}
	private static int extractMin() {
		int min = A[0];
		A[0] = A[heapSize-1];
		heapSize=heapSize-1;
		minHeapify(0);
		return min;    
	}

	public static void buildMinHeap() {
		System.out.println();
		int n= (int) (Math.floor((heapSize)/2)-1);
		for(int i=n;i>=0;i--) {
			System.out.print("MinHeapify["+i+"] ---> ");
			minHeapify(i);
		}      
	}

	public static void minHeapify(int i) {
		int left  = i*2+1;
		int right = i*2+2;
		int minimum = i;
		System.out.print("  minHeapify["+i+"] -- > { (l :"+left+" | r :"+right+" |root:"+i+" )  ");
		System.out.print("root : "+A[i]);
		if(left <= (heapSize-1) && A[left] < A[i]) {
			minimum = left;
			System.out.print(" | left : "+A[left]);
		}
		if(right <= (heapSize-1) && A[right] < A[minimum]) {
			minimum = right;
			System.out.print(" | right: "+A[right]);
		}
		System.out.print("| minimum : "+minimum+" ");
		if(minimum != i) {
			//swap A[i] with A[minimum]
			int temp = A[minimum];
			A[minimum] = A[i];
			A[i] = temp;
			System.out.print("  |  ");
			print();
			            System.out.print("  }");
			minHeapify(minimum);
		}
		     System.out.print("  }");
		System.out.println();
	}

	public static void print() {
		for(int i=0;i<heapSize;i++)
			System.out.print(A[i]+" ");
	}

}
 */

public class HuffmanCodes{
	public static int heapSize;
	public static Node[] node;
	public static int fixedSize;
	static class  Node{
		int data;
		char value;
		Node leftNode;
		Node rightNode;
		Node parentNode;
		boolean lVisit = false;
		boolean rVisit = false;
		String code="";

		public int getData() {
			return data;
		}

		public char getValue() {
			return value;
		}

		public void setValue(char value) {
			this.value = value;
		}

		public void setData(int data) {
			this.data = data;
		}
		public Node getLeftNode() {
			return leftNode;
		}
		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}
		public Node getRightNode() {
			return rightNode;
		}
		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", value=" + value + ", leftNode=" + leftNode + ", rightNode=" + rightNode
					+ "]";
		}

	}

	public static void main(String[] args){

		char[] charArr=new char[]{'a','b','c','d','e','f'};
		int[] Arr = new int[] {45,13,12,16,9,5};
		//Initialize node Array..
		node=new Node[Arr.length];
		heapSize=Arr.length;
		fixedSize=Arr.length;
		for(int i=0;i<Arr.length;i++) {
			node[i]= new Node();
			node[i].value = charArr[i];
			node[i].data  = Arr[i];
			node[i].leftNode  = null;
			node[i].rightNode  = null;
		}
		System.out.println("Array @Start :");
		print();
		System.out.println("-----------------");
		huffmanCodeGenerator();

	}

	private static void huffmanCodeGenerator() {
		//Step 1 : Build Min Heap;
		buildMinHeap();
		//Step 2 : iterate through the loop
		for(int i=0;i<fixedSize-1;i++) {
			Node leftMin  = extractMin();
			Node rightMin = extractMin();
			System.out.println(i+"-"+" leftMin : "+leftMin.data+" rightMin : "+rightMin.data);
			//create a new node 
			Node newNode = new Node();
			newNode.data = leftMin.data+rightMin.data;
			newNode.leftNode = leftMin;
			newNode.rightNode = rightMin;

			//Add it to node array
			insert(newNode);
		}

		//step 3 : print HuffmanCode 
		System.out.println("Extracting code : ");
		/*System.out.println(heapSize+" - "+node[0].data);*/
		extractHufCode();
	}

	private static void extractHufCode() {
		System.out.println("---------------------");
		Node initial =node[0];
		Node cur = initial;
		Node prev = cur;
		cur.parentNode=null;
		String code="";
		cur.code="";
		cur.parentNode=null;
		boolean flag=false;
		/*System.out.println("CUR - ParentNode - Code - LV - RV ");*/
		while(cur.lVisit==false || cur.rVisit==false) {
			/*System.out.print(cur.data+" - ");
			if(cur.parentNode!=null)
				System.out.print(cur.parentNode.data);*/
			/*System.out.print(" - "+cur.code+" - "+" - "+cur.lVisit+" - "+cur.rVisit+" - ");*/
			if(cur.leftNode != null && cur.lVisit==false) {
				/*System.out.print(cur.leftNode.data+" - "+cur.rightNode.data);*/
				cur.lVisit =true;
				prev=cur;
				cur = cur.leftNode;
				cur.parentNode=prev;
				code+="0";
				cur.code=code;
				/*System.out.print(" &&&&&& "+cur.data+" &&&&&&& ");*/
			}else if(cur.rightNode != null && cur.rVisit==false) {
				/*System.out.print(" - "+cur.rightNode.data);*/
				cur.rVisit =true;
				prev=cur;
				cur = cur.rightNode;
				cur.parentNode=prev;
				code+="1";
				cur.code=code;
			}else {
				System.out.println(cur.value+"-"+code);
				while(cur.parentNode!=null) {
					/*System.out.print("{ cur : "+cur.data+" }");*/
					cur=cur.parentNode;
					if(cur.rVisit==false)break;
				}
				/*System.out.print(" ---> cur : "+cur.data);*/
				code=cur.code;
			}
		/*	System.out.println();*/
		}


	}

	private static void insert(Node newNode) {
		//insert at the end
		node[heapSize]=newNode;
		heapSize++;
		int n = (int)Math.floor(heapSize/2)-1;
		while(n>=0) {
			minHeapify(n);
			n=(int)Math.floor(n/2)-1;
		}
	}

	private static Node extractMin() {
		Node minNode = node[0];
		node[0]=node[heapSize-1];
		heapSize--;
		minHeapify(0);
		return minNode;
	}

	private static void print() {
		for(int i=0;i<heapSize;i++)
			System.out.println(node[i]);
	}

	private static void buildMinHeap() {
		//Iterate from biggest non leap to root;
		int n = (int) (Math.floor(heapSize/2)-1);
		for(int i=n;i>=0;i--) {
			minHeapify(i);
		}

		System.out.println("After Build Min Heap");
		print();
		System.out.println("-----------------------");
	}

	private static void minHeapify(int i) {

		int left  =  i*2+1;
		int right =  i*2+2;
		int min = i;
		if(left < heapSize && node[left].data < node[min].data){
			min = left;	
		}
		if(right < heapSize && node[right].data < node[min].data) {
			min = right;
		}
		if(min!=i) {
			//Exchange A[min] && A[i];
			Node tempNode = node[i]; 
			node[i] = node[min];
			node[min] = tempNode;
			minHeapify(min);
		}
	}
}