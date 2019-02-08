package greedyAlgos.ex;

public class MocklDkstraAlgo {
	public static final int V=5;//3;
	public static int[] vertex= new int[V];
	public static boolean[] visited=new boolean[V];
	public static int graph[][];
	public static int[] parent=new int[V];
	public static void main(String[] args) {
		graph = /*new int[][] {{0,3,1},{3,0,1},{1,1,0}};*/
				new int[][] {{0,2,0,6,0},
			{2,0,3,8,5},
			{0,3,0,0,7},
			{6,8,0,0,9},
			{0,5,7,9,0}};
		int src  = 4;
		int dest = 0;
		dikstra(src,dest);
	}
	private static void dikstra(int src,int dest) {
		for(int i=0;i<V;i++) {
			vertex[i]  = Integer.MAX_VALUE;
			visited[i] = false;
			parent[i]  = -1;
		}

		vertex[src]=0;
		for(int j=0;j<V;j++) {
			int min = findMin();
			visited[min]=true;
			if(min==dest) break;
			else {
				for(int i=0;i<V;i++) {
					if( graph[min][i]!=0 && (graph[min][i]+vertex[min]) < vertex[i] && visited[i] != true) {
						vertex[i]=graph[min][i]+vertex[min];
						parent[i]=min;
					}
				}
			}
			printVertex();
			print(parent);
			System.out.println();
		}
		//Print shortest path 
		printShortestPath(src,dest);
		

	}
	private static void printShortestPath(int src,int dest) {
	    int temp = dest;
	    System.out.println("Dest : "+dest);
	    int[] route= new int[V];
	    
	    for(int i=0;i<V;i++)
	    	route[i]=-1;
	    
	    int  count = 0;
	    route[count] = dest;
		while(parent[temp] >= 0) {
		  	System.out.println(parent[temp]);
	    	temp = parent[temp];
	    	route[++count] = temp;
	    }
		
		System.out.println("Route: ");
		for(int i = V-1;i>0;i--) {
			if(route[i] != -1)
				System.out.print("("+route[i]+"-"+route[i-1]+")"+" --> "+graph[route[i]][route[i-1]]+"\n");
		}
	}
	private static void printVertex() {
		System.out.print("  Vertex:[");
		for(int i=0;i<V;i++)
			System.out.print(vertex[i]+" ");
		System.out.print(" ]");
	}
	private static void print(int[] parent) {
	int count=0;
	System.out.print(" Parent:[ ");
		for(int i=0;i<V;i++) {
			 /*if(parent[i] != -1)
			    count++; */
			System.out.print(parent[i]+" ");
		}
		System.out.print(" ]");
	/*	for(int i=0;i<count-1;i++)
			System.out.println(parent[i]+" - "+parent[i+1]+" -> "+graph[parent[i]][parent[i+1]]);*/

	}
	private static int findMin() {
		// TODO Auto-generated method stub
		int minPos=-1;
		int minVal=Integer.MAX_VALUE;
		for(int i=0;i<V;i++) {
			if(vertex[i]<minVal && visited[i]!=true) {
				minVal=vertex[i];
				minPos=i;
			}
		}
		return minPos;
	}

}
