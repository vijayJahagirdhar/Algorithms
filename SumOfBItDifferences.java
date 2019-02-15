package vijay.ds.trees;

public class SumOfBItDifferences {
	public static int[] arr = new int[] {1, 3, 5}; 
	public static String[] binary = new String[arr.length];
	public static int res=0;

	public static void main(String[] args) {

		for(int i=0;i<arr.length;i++) {
			binaryGenerator(arr[i],i);    
		}
		printBinary();
		equatebinary();
		printBinary();
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(i!=j)
					findDiff(i,j);
			}
		}
		System.out.println("RESULT : "+res);
	}

	private static void equatebinary() {
		int max=0;
		for(int i=0;i<binary.length;i++)
			if(binary[i].length()>max)
				max=binary[i].length();

		for(int i=0;i<binary.length;i++) {
			if(binary[i].length()<max) {
				int noOfBits = max-binary[i].length();
				String temp ="";
				for(int j=0;j<noOfBits;j++)
					temp+="0";
				binary[i]=temp+binary[i];
			}
		}

	}

	private static void findDiff(int i, int j) {
		String a = binary[i];
		String b = binary[j];
		int count=0;
		for(int k=0;k<binary[j].length();k++) {
			if(binary[i].charAt(k)!=binary[j].charAt(k)) count++;
		}
		res+=count*2;
	}

	private static void printBinary() {
		for(int i=0;i<binary.length;i++) {
			System.out.println(binary[i]+" ");
		}

	}
	private static void binaryGenerator(int a,int i) {
		int temp = a;
		String val = "";
		while(temp > 0) {
			val += temp%2;
			temp = temp/2;
		}
		binary[i]=val;
	}

}
