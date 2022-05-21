import java.util.Scanner;

public class max_subarray {
    public static int maxSubArraySum(int[] arr) {
 
        int size = arr.length;
        int start = 0;
        int end = 0;
     
        int maxSoFar = arr[0], maxEndingHere = arr[0];
     
        for (int i = 0; i < size; i++) {
            if (arr[i] > maxEndingHere + arr[i]) {
                start = i;
                maxEndingHere = arr[i];
            } else
                maxEndingHere = maxEndingHere + arr[i];
     
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                end = i;
            }
        }
       System.out.println("Found Maximum Subarray between index"+ Math.min(start, end)+" and "+end);
        return maxSoFar;
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = s.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the of elements: ");
        for(int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        s.close();
        maxSubArraySum(arr);    
    }
    
}
