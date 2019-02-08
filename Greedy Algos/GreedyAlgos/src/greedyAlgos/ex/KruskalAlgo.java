package greedyAlgos.ex;
import java.util.ArrayList;
import java.util.List;

public class KruskalAlgo {
	static class Edge{
		int leftVertex;
		int rightVertex;
		int edgeCost;
		public Edge(int leftVertex, int rightVertex, int edgeCost) {
			super();
			this.leftVertex = leftVertex;
			this.rightVertex = rightVertex;
			this.edgeCost = edgeCost;
		}
		public int getLeftVertex() {
			return leftVertex;
		}
		public void setLeftVertex(int leftVertex) {
			this.leftVertex = leftVertex;
		}
		public int getRightVertex() {
			return rightVertex;
		}
		public void setRightVertex(int rightVertex) {
			this.rightVertex = rightVertex;
		}
		public int getEdgeCost() {
			return edgeCost;
		}
		public void setEdgeCost(int edgeCost) {
			this.edgeCost = edgeCost;
		}
		@Override
		public String toString() {
			return "Edge [leftVertex=" + leftVertex + ", rightVertex=" + rightVertex + ", edgeCost=" + edgeCost + "]";
		}
	}
	
	
	public static int[] parent = new int[] {-1,-1,-1,-1,-1};//{-1,-1,-1};
	public static Edge[] edge;
	public static int V = /*3;*/5;
	public static int[][] graph;
	public static int heapSize;
	public static Edge[] mst = new Edge[V-1];
	public static void main(String[] args) {
		graph = /*new int[][] {{0,1,2},{1,0,3},{2,3,0}};*/
		new int[][] {{0,2,0,6,0},
			{2,0,3,8,5},
			{0,3,0,0,7},
			{6,8,0,0,9},
			{0,5,7,9,0}};
		int n=V*V;                     
		Edge[] edge1 = new Edge[n];
		int count=0;
		/*List<Edge> edges =new  ArrayList<Edge>(); */     
		for(int i=0;i<V;i++) { 
			for(int j=0;j<V;j++) { 
				if(graph[i][j]!=0 && i<j) {
					Edge e=new Edge(i,j,graph[i][j]);
					edge1[count]=e;
					count++;
				}
			}
		}
		System.out.println(count);
		edge = new Edge[count];
		for(int i=0;i<count;i++) {
			edge[i]=edge1[i];
			System.out.println(edge[i]);
		}
		kruskal();                   

	}
	private static void kruskal() {

		//1.Build min heap
		heapSize =edge.length;
		buildMinHeap();

		//2.extract min 
		System.out.println("-----------------------------------------------------");
		for(int i=0;i<V;i++) {
			Edge min=extractMin();
			System.out.println("The min Extracted is  : "+min);
			System.out.println("Min Heap after extraction : ");
			print();
			System.out.println();

			//3.check whether the min edge causes loop  if not add it to MST set 
			boolean isloop = unionAndFind(min); 

			if(isloop == false) {
				System.out.println("\n  min --> "+min+"  --> is added to the node as it doesnot form cycle");
				mst[i]=min;
			}
			System.out.println();
			System.out.println("-----------------------------------------------------");
		}		
		//5.print all the edges included in MST
		System.out.println("\n===========================================================");
		System.out.println("Result : ");
		printMst();
	}
	private static void printMst() {
		for(Edge i: mst)
			if(i!=null)
			System.out.println(i);
		
	}
	private static boolean unionAndFind(Edge min) {
		System.out.print(" [UNION AND FIND FOR min["+min.leftVertex+","+min.rightVertex+"]  :  ");
		int vertex1 = min.leftVertex;
		int vertex2 = min.rightVertex;
		int temp1 = vertex1,temp2=vertex2;

		while(parent[temp1] >= 0) {
			temp1 =  parent[temp1];
		}
		while(parent[temp2] >= 0) {
			temp2 =  parent[temp2];
		}

		System.out.print(" --> parent["+vertex1+"]="+temp1+" , parent["+vertex2+"]="+temp2+"  ]  ");
		if(temp1 == vertex1 && temp2==vertex2) {
			System.out.print("hence case 1 --> node are parents ");
			parent[vertex2] = vertex1;
			printParentArray();
			return false;
		}

		if(temp1 != temp2) {
			System.out.print("hence case 2 --> parent1 and parent2 differnt set ");
			if(parent[temp1]<=parent[temp2])
				parent[vertex2] = vertex1;
			else
				parent[vertex1] = vertex2;
			printParentArray();
			return false;
		}
		printParentArray();
		return true;
	}

	private static void printParentArray() {
		System.out.print("{{ ");
		for(int i : parent)
			System.out.print(i+" ");
		System.out.print(" }}");
	}
	private static Edge extractMin() {
		Edge min = edge[0];
		edge[0]=edge[heapSize-1];
		heapSize = heapSize-1;
		minHeapify(0);
		return min;
	}
	private static void buildMinHeap() {
		System.out.println("--------------------------------");
		int n = (int) (Math.floor(heapSize/2)-1); 
		for(int i=n;i>=0;i--) {
			System.out.println("*MINHEAPIFY["+i+"]");
			minHeapify(i);
		}

		System.out.println("After Building min Heap");
		print();
	}
	private static void print() {
		// TODO Auto-generated method stub
		for(int i=0;i<heapSize;i++)
			System.out.println(i+"   - >    "+edge[i]);
	}
	private static void minHeapify(int i) {
		int left = i*2+1;
		int right = i*2+2;
		int min = i;
		if(left<heapSize  && edge[left].edgeCost < edge[min].edgeCost)
			min =left;
		if(right<heapSize && edge[right].edgeCost < edge[min].edgeCost)
			min = right;

		if(min != i) {
			//swap edge[i] and edge[min] and apply min Heapify on edge[min];
			Edge temp = edge[i];
			edge[i]=edge[min];
			edge[min]=temp;

			minHeapify(min);
		}
	}

}
