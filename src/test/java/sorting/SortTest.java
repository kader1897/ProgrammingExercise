package sorting;

import org.junit.Test;
import util.ArrayUtil;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by kader.belli on 31.12.2018.
 */
public class SortTest{
    
    private final int[] array = ArrayUtil.sampleUnorderedArray();
    private final int[] orderedArray = ArrayUtil.sampleOrderedArray();
    private final int[] singleElementArray = ArrayUtil.singleElementArray();
    
    @Test
    public void testSelectionSort()
    {
        int[] arr = new int[array.length];
        int[] arrIterative = new int[array.length];
        System.arraycopy(array, 0, arr, 0, array.length);
        System.arraycopy(array, 0, arrIterative, 0, array.length);
        
        SelectionSort.selectionSort(arr, 0);
        SelectionSort.selectionSortIterative(arrIterative);
        
        assertArrayEquals(orderedArray, arr);
        assertArrayEquals(orderedArray, arrIterative);
    }
    
    @Test
    public void testInsertionSort()
    {
        int[] arr = new int[array.length];
        System.arraycopy(array, 0, arr, 0, array.length);
        
        InsertionSort.insertionSort(arr);
        assertArrayEquals(arr, orderedArray);
    }
    
    @Test
    public void testQuickSort(){
        int[] arr = new int[array.length];
        System.arraycopy(array, 0, arr, 0, array.length);
    
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(arr, orderedArray);
    }
    
    @Test
    public void testMergeSort(){
        int[] arr = new int[array.length];
        System.arraycopy(array, 0, arr, 0, array.length);
    
        MergeSort.mergeSort(arr, 0, arr.length - 1);
        assertArrayEquals(arr, orderedArray);
    }
    
    @Test
    public void testHeapSort(){
        int[] arr = new int[array.length];
        System.arraycopy(array, 0, arr, 0, array.length);
        
        HeapSort.heapSort(arr);
        assertArrayEquals(arr, orderedArray);
    }
    
    @Test
    public void testSingleElementSelectionSort()
    {
        int[] arr = ArrayUtil.singleElementArray();
        SelectionSort.selectionSort(arr, 0);
        
        assertArrayEquals(arr, singleElementArray);
    
        int[] arrIterative = ArrayUtil.singleElementArray();
        SelectionSort.selectionSortIterative(arr);
        
        assertArrayEquals(arrIterative, singleElementArray);
    }
    
    @Test
    public void testSingleElementInsertionSort()
    {
        int[] arr = ArrayUtil.singleElementArray();
        InsertionSort.insertionSort(arr);
        
        assertArrayEquals(arr, singleElementArray);
    }
    
    @Test
    public void testSingleElementQuickSort()
    {
        int[] arr = ArrayUtil.singleElementArray();
        QuickSort.quickSort(arr, 0, arr.length - 1);
        
        assertArrayEquals(arr, singleElementArray);
    }
    
    @Test
    public void testSingleElementMergeSort()
    {
        int[] arr = ArrayUtil.singleElementArray();
        MergeSort.mergeSort(arr, 0, arr.length - 1);
        
        assertArrayEquals(arr, singleElementArray);
    }
}
