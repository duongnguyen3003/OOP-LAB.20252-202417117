import java.util.Arrays;

public class ArraySort {

    private static void heapify(int[] arr, int n, int i) {
        int mx = i;       
        int lo = 2 * i + 1;  
        int hi = 2 * i + 2; 

        if(lo < n && arr[lo] > arr[mx]) mx = lo;

        if(hi < n && arr[hi] > arr[mx]) mx = hi;

        if(mx != i) 
        {
            int swap = arr[i];
            arr[i] = arr[mx];
            arr[mx] = swap;

            heapify(arr, n, mx);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        for(int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for(int i = n - 1; i > 0; i--) 
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1789, 2035, 1899, 1456, 2013};
        
        int sum = 0;
        
        for(int i = 0; i < arr.length; i++) sum += arr[i];
        
        double avr = (double)sum / arr.length;
        
        //Arrays.sort(arr);
        heapSort(arr);
        
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average: " + avr);
    }
}