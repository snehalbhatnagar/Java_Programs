import java.util.Scanner;

public class knapsack {
    public static int knapsackDP(int[] w, int[] v, int n, int W) {
        if (n <= 0 || W <= 0) {
            return 0;
        }
    
        int[][] m = new int[n + 1][W + 1];
        for (int j = 0; j <= W; j++){
            m[0][j] = 0;
        }
    
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= W; j++){ 
                if (w[i - 1] > j){
                    m[i][j] = m[i - 1][j];
                } else {
                    m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return m[n][W];
    }

    public static void main(String args[]){
        int n, W, i;
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter no of items");  
        
        n = s.nextInt(); 

        int w[] = new int[n];
        int v[] = new int[n];
 
        System.out.println("Enter the weights of each items");
        for(i = 0; i < n; i++)  
            w[i] = s.nextInt();    
 
        System.out.println("Enter the values of each items");
        for(i=0; i<n; i++)  
            v[i] = s.nextInt(); 
 
        System.out.println("Enter maximum volume of knapsack :");  
        W = s.nextInt();
        
        System.out.println(knapsackDP(w, v, n, W));
    } 
    
}
