package vijay.ds.trees;

public class SearchingSortedArray2DMinimized {	
	public static int[][] arr;
	public static int rowCount;
	public static int columnCount;
	public static int x=-1,y=-1;

	public static void main(String[] args) {
		//Searching key in o(n) or  O(m)
		int key = 15;
		arr= new int[][]{{1,2,3,4},{3,6,9,11},{7,8,10,15}};
		rowCount = arr.length;
		columnCount = arr[0].length;
		int pos = searchMinimized(0,columnCount-1,key);
		if(pos==1)
			System.out.println("Element found at --> arr[x:"+x+",y:"+y+"]");
		else
			System.out.println("Element not found");
	}

	private static int searchMinimized(int i, int j, int key) {
		int pos = -1;
		System.out.println("searchMinimized("+i+","+ j+")");
		if((0<=i && i<rowCount) && (0<=j && j<columnCount)) {
			if(key == arr[i][j]) {
				pos = 1;x=i;y=j;
			}else if(key < arr[i][j]) 
				pos = searchMinimized(i,j-1 ,key);			   
			else 
				pos = searchMinimized(i+1, j, key);
		}
		else 
			pos = -1;
		return pos;
	}
}
