import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class order_statistics {

    public static int randomizedSelect(int[] array, int startIndex, int endIndex, int order, Random random){
        if (startIndex == endIndex) {
            return array[startIndex];
        }

        int pivotIndex = randomizedPartition(array, startIndex, endIndex, random);
        int k = pivotIndex - startIndex + 1;

        if (order == k) {
            return array[pivotIndex];
        } else if (order < k) {
            return randomizedSelect(array, startIndex, pivotIndex - 1, order, random);
        } else {
            return randomizedSelect(array, pivotIndex + 1, endIndex, order - k, random);
        }
    }
    
    public static int randomizedPartition(int[] array, int startIndex, int endIndex, Random random){
        int rangeLength = endIndex - startIndex + 1;
        int i = startIndex + random.nextInt(rangeLength);
        swap(array, endIndex, i);
        return partition(array, startIndex, endIndex);
    }

    public static int partition(int[] array, int startIndex, int endIndex){
        int pivot = array[endIndex];
        int i = startIndex - 1;

        for (int j = startIndex; j < endIndex; ++j) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, endIndex);
        return i + 1;
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String args[]){
        String fileData = "";

        try {  
            
            File f1 = new File("order_stats.txt");    
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
        int i = arr[n-1];
        Arrays.copyOf(arr, arr.length-1);
        
        Random random = new Random();

        System.out.println(randomizedSelect(arr, 0, n-1, i, random));
    }
    
}
