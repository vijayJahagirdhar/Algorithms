package greedyAlgos.ex;
import java.util.Arrays;

public class KnapSack {                
       private static double[] original;
       private static boolean[] visited = new boolean[]{false,false,false,false,false,false,false,false};

       public static void main(String[] args) {
              double[] p = new double[] {10,5,15,7,6,18,3};
              double[] w = new double[] {2,3,5,7,1,4,1};
              int n = p.length;
              int m=15;
              double profit = knapsack(p,w,n,m);
              System.out.println("The optimal profit for the program is : "+profit);
       }


       public static double knapsack(double[] p,double[] w,int n,double m) {
              double[] ratio =new double[n];
              original=new double[n];
              for(int i=0;i<n;i++) {
                     ratio[i]=p[i]/w[i];
              }
              for(int i=0;i<n;i++) {
                     original[i] = ratio[i];
              }
              Arrays.sort(ratio, 0, n); 
              /*System.out.println("original");
              for(int i=0;i<n;i++) {
                     System.out.print(original[i]+"  ");
              }
              System.out.println();*/
              double profit=0.0;
       /*     System.out.println();*/
              
              double tempW=0,tempP=0;
              
              //knapsack algo
              for(int j=n-1 ;j>=0;j--) {
                     int x = find(ratio[j]);
                     /*     System.out.print(" ratio selected :"+ratio[j]+" - index : "+x);*/
                     if(m > 0 && w[x] <= m) { 
                           profit = profit +  p[x];
                           m = m - w[x];
                           /*System.out.println(" --> { if( "+m+">0 && "+w[x]+" <= "+m+") ==> profit :"+profit+" m : "+m+" }");*/
                     }
                     else if(w[x]>m) {
                           tempW = w[x];
                           tempP = p[x];
                           break;
                     }
                     /*System.out.println();*/
              }
              if(m > 0) {
                     profit = profit + tempP * (m/tempW);
              }
              return profit;
       }


       private static int find(double d) {
              int pos=-1;
              /*System.out.print(" { ---> element : "+d+" index : ");*/
              int count = 0;
              for(int i = 0;i< original.length;i++) {
                     if(original[i]==d && visited[i] == false) {
                           pos=i;
                           count++;
                     }
              }
              if(pos!=-1)
                     visited[pos]=true;

              /*System.out.print(pos+" -- [");*/
              /*for(int i=0;i<original.length;i++) {
                     System.out.print(visited[i]+" ");
              }*/
              /*System.out.print(" ]");
              System.out.println();*/
              return pos;
       }
}

