package main.java.sorting.merge_sort;

/**
 * Created by tanerali on 01/08/2017.
 *
 * A MergeSort recursively breaks down a list until each element is in its own list
 * which is by definition sorted (1 element only). For instance, an array of 8 elements
 * becomes 2 arrays of 4 elemtns, which becomes 4 arrays of 2 elemtns, which becomes
 * 8 arrays of 1 element. Once this has been completely broken down, you can begin combiningg
 * sorted lists. You start by combining the first 2 lists. You compare the value to see which is lowest.
 * You sort all individual arrays into 4 arrays of 2 elements, where each is now sorted. Then you
 * merge these 4 arrays into 2 arrays of 4 elements. You merge them by always comparing the first 2
 * elements in each array to see which is lowest and you insert that into the temporary array.
 * Continue until you have rebuilt all elements into a single sorted array.
 *
 * Big O = O(n log n)
 */
public class MergeSort {

    //makes it simpler for user to start mergeSort by passing an array
    //this method hides the mergeSort's recursive complexity (required params)
    public static void mergeSort(int[] array){

        mergeSort(array, new int[array.length], 0, array.length-1);

    }

    /**
     *
     * @param array - the array to split/combine
     * @param temp - the temporary array used for rebuilding the lists
     * @param leftStart - left index
     * @param rightEnd - right index
     */
    //this is the recursive mergeSort method
    public static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {

        //base case to escape the recursion
        if (leftStart >= rightEnd){
            return;
        }

        //determine the middle of the array and each subsequent sub-array
        int middle = (leftStart + rightEnd) / 2;

        //recursively call mergeSort to break down the left side of the list
        mergeSort(array, temp, leftStart, middle);
        //recursively call mergeSort to break down the right side of the list
        mergeSort(array, temp, middle+1, rightEnd);
        //will be called once for each recursion with the values of array, temp, leftStart and rightEnd
        mergeHalves(array, temp, leftStart, rightEnd);
    }


    public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd){

        //on the first pass leftStart = 0 and rightEnd = 1
        //get left index
        int leftEnd = (leftStart + rightEnd) / 2;
        //get right index
        int rightStart = leftEnd + 1;
        //get size
        int size = rightEnd - leftStart + 1;

        //save initial left and right start positions for later use
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            //if the value at index l"left" is smaller than index "right"
            if ( array[left] <= array[right] ) {
                //add index "left" as next element in sorted array
                temp[index] = array[left];
                //increment left
                left++;
            } else {
                //add index "right" as next element in sorted array
                temp[index] = array[right];
                //increment right
                right++;
            }
            //increment index
            index++;
        }

        //copy all trailing values from the left into temp
        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        //copy all trailing values from the right into temp
        System.arraycopy(array, left, temp, index, rightEnd - right + 1);
        //copy all values from temp into original array
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }


    public static void main(String[] args) {

        System.out.println("initial array");
        int[] testArr = {98,17,56,13,9,16,100,54,18};
        System.out.println();

        for (int i: testArr) {
            System.out.print(i+ " ");
        }

        mergeSort(testArr);

    }
}
