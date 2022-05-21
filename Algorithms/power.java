import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class power {
    public static int calc_power(int x, int y){
        int temp;
        if(y==0)
            return 1;
        if(y == 1)
            return x;    
        if(x == 0)
            return 0;
        if(x == 1)
            return 1;
        if(y%2 == 0){
            temp = calc_power(x, y/2);
            return temp*temp;
        } 
            
        else{
            temp = calc_power(x, (y-1)/2);
            return x * temp * temp;
        }
            
    }
    public static void main(String args[]){
        String fileData = "";

        try {  
            
            File f1 = new File("power.txt");    
            Scanner dataReader = new Scanner(f1);  
            while (dataReader.hasNextLine()) {  
                fileData = dataReader.nextLine();             
            }  
            dataReader.close();  
        } catch (FileNotFoundException exception) {  
            System.out.println("Unexcpected error occurred!");  
            exception.printStackTrace();  
        } 

        String arr1[] = fileData.split(",");
        int n = arr1.length;
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(arr1[i]);

        System.out.println("Answer: "+ calc_power(arr[0], arr[1]));    
    }
}
