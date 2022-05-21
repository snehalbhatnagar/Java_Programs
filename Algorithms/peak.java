import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class peak {

    public static int findPeak(int arr[], int low, int high, int size){
        int mid = low + (high - low)/2;

        if((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == size -1 || arr[mid + 1] <= arr[mid]))
            return mid;
        else if(mid > 0 && arr[mid - 1] > arr[mid])
            return findPeak(arr, low, mid-1, size);
        else
            return findPeak(arr, mid+1, high, size);        
    }
    public static void main(String arsgs[]){
        String fileData = "";

        try {  
            
            File f1 = new File("array.txt");    
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

        int len = arr.length;    

        System.out.println("Peak is "+ arr[findPeak(arr, 0, len-1, len)]);    
    }
    
}
