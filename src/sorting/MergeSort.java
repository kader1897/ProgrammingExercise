package sorting;

/**
 * Created by kader.belli on 31.12.2018.
 */

import util.ArrayUtil;

public class MergeSort {
    
    private static int[] merge(int[] input, int left, int right, int end)
    {
        int[] result = new int[end - left + 1];
        
        int leftIndex = left;
        int rightIndex = right;
        
        for(int i = 0; i < result.length; i++)
        {
            if(rightIndex > end || (leftIndex < right && input[leftIndex] < input[rightIndex]))
            {
                result[i] = input[leftIndex];
                leftIndex++;
            }
            else
            {
                result[i] = input[rightIndex];
                rightIndex++;
            }
        }
        
        return result;
    }
    
    public static void mergeSort(int[] input, int start, int end)
    {
        if(end - start < 1)
            return;
        
        int splitIndex = start + ((end - start) / 2);
        
        mergeSort(input, start, splitIndex);
        mergeSort(input, splitIndex + 1, end);
        System.arraycopy(merge(input, start, splitIndex + 1, end), 0, input, start, end - start + 1);
    }
    public static void main(String[] args) {
        int[] array = ArrayUtil.sampleUnorderedArray();
        MergeSort.mergeSort(array, 0, array.length - 1);
        ArrayUtil.printArray(array);
    }
}

