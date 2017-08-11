package main.java.sorting.insertion_sort;

/**
 * Created by tanerali on 01/08/2017.
 *
 * Insertion sort iterates through the list by consuming one input element at each repetition,
 * and growing a sorted output list. On a repetition, insertion sort removes one element from
 * the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 *
 * Big O = O(n^2)
 */
public class InsertionSort {
    /*Function to sort array using insertion sort*/
    public void sort(int arr[])
    {
        //get array length
        int n = arr.length;
        //start loop at index[1] (second element) because first element is
        //first element in new sorted list
        for (int i=1; i<n; ++i)
        {
            //item to insert into sorted list
            int insertItem = arr[i];

            //represents the end of the ordered list
            int j = i-1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */

            //while position on left is greater than position on right
            //enter while loop
            while (j>=0 && arr[j] > insertItem)
            {
                //move elements of array down one spot
                arr[j+1] = arr[j];
                //decrement j index
                j--;
            }
            //insert insertItem into appropriate location in list
            arr[j+1] = insertItem;
        }
    }

    /* A utility function to print array*/
    public static void printArray(int arr[])
    {
        for (int i=0; i<arr.length; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Driver method
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6};

        InsertionSort ob = new InsertionSort();
        ob.sort(arr);

        printArray(arr);
    }
} /* This code is contributed by Rajat Mishra. */
