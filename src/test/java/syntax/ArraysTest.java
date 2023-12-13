package syntax;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArraysTest {
    @Test
    void commonMethods() {
        int[] arr = new int[] { 60, 50 ,30 ,20 ,10};
        Arrays.toString(arr);
        Arrays.stream(arr);
        Arrays.fill(arr, 30);
        assertArrayEquals(new int[]{30, 30, 30, 30, 30}, arr);
    }

    @Test
    void fill() {
        //is there a way to fill an array from 0 to n-1
        assertArrayEquals(new int[]{0, 1, 2}, IntStream.range(0,  3).toArray());
    }

    @Test
    void sortArray() {
        // sort method sorts in place
        int[] arr = new int[]{10,2,3,4,5,6};
        Arrays.sort(arr);
        assertEquals(2, arr[0]);

        Integer[] arr2 = new Integer[]{10,2,3,4,5,6};
//        Comparator can only be give to object arrays but not int arrays
        Arrays.sort(arr2, Comparator.reverseOrder());
       int[] arr3 =  Arrays.stream(arr2).sorted(Comparator.reverseOrder()).mapToInt(x -> x).toArray();

       assertEquals(10, arr3[0]);
    }

    @Test
    void createSubArray() {
        int[] arr = new int[]{1,2,3,4,5,6};
        int[] sub = Arrays.copyOfRange(arr, 0,2);
        assertArrayEquals(new int[]{1,2}, sub);
    }

    @Test
    void binarySearchTest() {
        int[] arr = new int[] { 60, 50 ,30 ,20 ,10};
       //binary search is useless, its better to do it by yourself
    }



    @Test
    void reverseElementsInAnArrayInPlace() {
        int[] arr = new int[] { 60, 50 ,30 ,20 ,10};
        int i=0, j=arr.length-1;
        while(i<j){
            int temp = arr[i]; arr[i] = arr[j]; arr[j]= temp; i++; j--;
        }
    }
}
