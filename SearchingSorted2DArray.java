package vijay.ds.trees;

public class SearchingSorted2DArray {

	public static  int[][] arr;
	public static void main(String[] args) {
	arr= new int[][] {{1,2,3,4},{4,5,6,7},{7,8,9,10}};
	int key = 15;
	System.out.println("Element to be searched : "+key);
    searchArr(arr,key);
	}
	//using linear search..
	private static int searchArr(int[][] arr, int key) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i][0]<=key  &&  arr[i][arr[i].length-1] >= key) {
				int pos = binarySearch(i,0,arr[i].length-1,key);
				if(pos != -1) {
					System.out.println("Element is found at ["+i+","+pos+"]");
					return 0;
				}
			}
		}
		System.out.println("Element not found");
		return 0;
	}
	private static int binarySearch(int row,int low, int high, int key) {
	    int pos = -1;
		int mid = (low+high)/2;
	    if(arr[row][mid]==key) {
	    	pos = mid;
	    	return pos;
	    }
	    else if(key > arr[row][mid]) 
	    	pos = binarySearch(row, mid+1, high, key);
	    else 
	        pos = binarySearch(row,low,mid-1,key); 	
		return pos;
	}
	
	//dont apply binary serch for now,as few of the tc it is failing...
	/*private static int getRowIndex(int[][] arr, int key) {
		int mid = arr.length/2;
		if(key == arr[mid][0]) {
			return mid;
		}else if(arr[mid][0] < key) {
			if(arr[])
		}
		return 0;
	}*/
	

}
