import java.util.Scanner;

public class fractional_knapsack {

    public static void main(String args[]){
        int i, j = 0, max_qty, m, n;  
        float sum = 0, max;
        int array[][]=new int[2][20];  

        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter no of items");  
        
        n = s.nextInt(); 
 
        System.out.println("Enter the weights of each items");
        for(i = 0; i < n; i++)  
            array[0][i] = s.nextInt();    
 
        System.out.println("Enter the values of each items");
        for(i=0; i<n; i++)  
            array[1][i] = s.nextInt(); 
 
        System.out.println("Enter maximum volume of knapsack :");  
        max_qty = s.nextInt();  
 
        m = max_qty;  
        while(m>=0){  
            max = 0;  
            for(i=0;i<n;i++){  
                if(((float)array[1][i]) / ((float)array[0][i]) > max){  
                    max=((float)array[1][i]) / ((float)array[0][i]);  
                    j = i;  
                }  
            }  
            if(array[0][j] > m){  
                System.out.println("Quantity of item number: " +  (j+1) + " added is " +m);  
                sum+=m*max;  
                m = -1;  
            }  
            else{  
                System.out.println("Quantity of item number: " + (j+1) + " added is " + array[0][j]);  
                m-=array[0][j];  
                sum+=(float)array[1][j];  
                array[1][j] = 0;  
            }  
        }  
        System.out.println("The total profit is " + sum);
        s.close();
    
    }
    
}
