package sorting;

import util.ArrayUtil;
import util.HeapUtil.*
        ;

import static util.HeapUtil.buildMaxHeap;
import static util.HeapUtil.maxHeapify;

/**
 * Created by kader.belli on 24.01.2019.
 */
public class HeapSort{
    public static void heapSort(int[] input)
    {
        buildMaxHeap(input);
        int length = input.length;
        while(length > 1)
        {
            length--;
            ArrayUtil.swap(input, 0, length);
            maxHeapify(input, 0, length);
        }
    }
}
