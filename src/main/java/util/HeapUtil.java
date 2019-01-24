package util;

import static util.ArrayUtil.swap;

/**
 * Created by kader.belli on 24.01.2019.
 */
public class HeapUtil{
    public static void buildMaxHeap(int[] arr)
    {
        // Max-Heapify non-leaf nodes.
        // Nodes after the index n/2 are leaf nodes.
        for(int i = arr.length / 2; i >= 0; i--)
        {
            maxHeapify(arr, i);
        }
    }
    
    public static void maxHeapify(int[] arr, int i, int length)
    {
        int index = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left < length && arr[left] > arr[index])
            index = left;
        if(right < length && arr[right] > arr[index])
            index = right;
        
        if(index != i)
        {
            swap(arr, i, index);
            maxHeapify(arr, index, length);
        }
    }
    
    public static void maxHeapify(int[] arr, int i)
    {
        maxHeapify(arr, i, arr.length);
    }
    
    public static int[] add(int[] arr, int x)
    {
        int n = arr.length;
        int[] result = new int[n + 1]; 
        System.arraycopy(arr, 0, result, 0, n); /* todo: Array size changes, so we need to copy the entire array.
                                                                             todo: This may cause performance problems for large arrays. 
                                                                             todo: Search for a different solution */
        result[n] = x;
        int i = n;
        while(i/2 >= 0 && result[i] > result[i/2])
        {
            swap(result, i, i/2);
            i /= 2;
        }
        return result;
    }
}
