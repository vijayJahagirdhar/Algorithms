package vijay.ds.trees;

public class Example {
	static int[][] arr = new int[][] {{0,0,1},{1,0,1},{1,1,1}};
	static int m=3;
	static int n=3;
	public static void main(String[] args) {
		String val;
		for(int i=0;i<n;i++) {
			val = check(i);
			if(val.equalsIgnoreCase("YES")) {
				System.out.println(" UNIQUESNESS WILL BE LOST BY DELETING A COLUMN ...");
				break;
			}
		}
	}
	private static String check(int temp) {
		String res = "";
		System.out.println("After deleting "+(temp+1)+" column");
		String[] resultantArray = new String[] {"","",""};
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(j!=temp) 
				   resultantArray[i]+=arr[i][j];
			}
		}
		print(resultantArray);
		boolean result=false;
	    result = checkForUniqueness(resultantArray);
	    if(result) {
	       res = "YES";
		   System.out.print("    ----- >    Uniqueness is lost");
	    }else {
	    	res = "NO";
	    	System.out.print("   ------>    not lost");
	    }System.out.println();
		return res;
	}
	private static boolean checkForUniqueness(String[] resultantArray) {
		boolean res=false;
		for(int i=0;i<resultantArray.length-1;i++) {
			for(int j=i+1;j<resultantArray.length;j++) {
				if(resultantArray[i].equalsIgnoreCase(resultantArray[j]))
					res = true;
			}
		}
		return res;
	}
	private static void print(String[] resultantArray) {
		for(int i=0;i<resultantArray.length;i++)
			System.out.print(resultantArray[i]+"  ");
	}
}