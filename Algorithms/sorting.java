import java.util.Arrays;
import java.util.Scanner;
import java.io.File;   
import java.io.FileNotFoundException;  

public class sorting{
    public static int[] countElements(int[] input, int k) {
        int[] c = new int[k + 1];
        Arrays.fill(c, 0);
    
        for (int i : input) {
            c[i] += 1;
        }
    
        for (int i = 1; i < c.length; i++) {
        c[i] += c[i - 1];
        }
    
        return c;
    }
    
    public static void countSort(int arr[], int n) {
        int[] arr1 = new int[n + 1];
    
        int x = arr[0];
        for (int i = 1; i < n; i++) {
          if (arr[i] > x)
            x = arr[i];
            for(int z = 0; z < arr.length; z++)
            System.out.print(arr[z]+" ");
        System.out.println();
        }
        int[] count_arr = new int[x + 1];
    
        for (int i = 0; i < x; ++i) {
          count_arr[i] = 0;
          for(int z = 0; z < arr.length; z++)
            System.out.print(arr[z]+" ");
        System.out.println();
        }
    
        for (int i = 0; i < n; i++) {
          count_arr[arr[i]]++;
          for(int z = 0; z < arr.length; z++)
            System.out.print(arr[z]+" ");
        System.out.println();
        }
    
        for (int i = 1; i <= x; i++) {
          count_arr[i] += count_arr[i - 1];
          for(int z = 0; z < arr.length; z++)
            System.out.print(arr[z]+" ");
        System.out.println();
        }
    
        for (int i = n - 1; i >= 0; i--) {
          arr1[count_arr[arr[i]] - 1] = arr[i];
          count_arr[arr[i]]--;
          for(int z = 0; z < arr.length; z++)
            System.out.print(arr[z]+" ");
        System.out.println();
        }
    
        for (int i = 0; i < n; i++) {
          arr[i] = arr1[i];
          for(int z = 0; z < arr.length; z++)
            System.out.print(arr[z]+" ");
        System.out.println();
        }
      }

    public static void mergeSort(int[] arr, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
    
        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = arr[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
    
        merge(arr, l, r, mid, n - mid);
    }
    public static void merge(int[] arr, int[] l, int[] r, int left, int right) { 
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            }
            else {
                arr[k++] = r[j++];
            }
            for(int x = 0; x < arr.length; x++)
            System.out.print(arr[x]+" ");
        System.out.println();
        }
        while (i < left) {
            arr[k++] = l[i++];
            for(int x = 0; x < arr.length; x++)
            System.out.print(arr[x]+" ");
        System.out.println();
        }
        while (j < right) {
            arr[k++] = r[j++];
            for(int x = 0; x < arr.length; x++)
            System.out.print(arr[x]+" ");
        System.out.println();
        }
    }

    public static int partition (int a[], int start, int end){  
        int pivot = a[end]; 
        int i = (start - 1);  
    
        for (int j = start; j < end; j++)  
        {  
            if (a[j] < pivot){  
                i++;   
                int t = a[i];  
                a[i] = a[j];  
                a[j] = t;  
            }  
        }  
        int t = a[i+1];  
        a[i+1] = a[end];  
        a[end] = t;  
        return (i + 1);  
    }  
  
  
    public static void quick(int arr[], int start, int end){  
        
        if (start < end)  
        {  
            int p = partition(arr, start, end); 
           
            quick(arr, start, p - 1);  
            quick(arr, p + 1, end);  
            
        }  
    }  

    public static void selection(int arr[]){
        for (int i = 0; i < arr.length - 1; i++){  
            int index = i;  
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[index]){  
                    index = j;
                    for(int x = 0; x < arr.length; x++)
                    System.out.print(arr[x]+" ");
                System.out.println();
                }  
            }  
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
        }  
    }

    public static void insertion(int arr[]){
        for(int j = 1; j < arr.length; j++){
            int key = arr[j];
            int i = j-1;
            while((i > -1) && arr[i] >= key){
                arr[i+1] = arr[i];
                i--;
                for(int x = 0; x < arr.length; x++)
                    System.out.print(arr[x]+" ");
                System.out.println();
            }
            for(int x = 0; x < arr.length; x++)
                System.out.print(arr[x]+" ");
            arr[i+1] = key;
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);

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
         


        System.out.println("-------------------------------------------------------------------");
        System.out.println("Press the number against the name to select.");
        System.out.println("1. Insertion sort");
        System.out.println("2. Selection sort");
        System.out.println("3. Quick sort");
        System.out.println("4. Merge sort");
        System.out.println("5. Count sort");
        System.out.println("------------------------------------------------------------------");
        int select = s.nextInt();
        int l = (arr[0]+"").length();
        s.close();
        switch(select){
            case 1:
                insertion(arr);
            break;
            case 2:
                selection(arr);
            break;
            case 3:
                quick(arr, 0, n-1);
            break;
            case 4:
                mergeSort(arr, n);
            break;
            case 5:
                countSort(arr, n/l);
            break;
            default:
                System.out.println("Invalid choice.");
            
        }
        System.out.println("===============================================");
        for(int i = 0; i < n; i++)
            System.out.println(arr[i]);
    }
}