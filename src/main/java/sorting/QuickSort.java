package sorting;

/*
 * Created by kad_ER_ on 12/30/2018 3:37 AM
 * Project: ProgrammingExercise
 */

import util.ArrayUtil;

class QuickSort {

    private static int partition(int[] input, int left, int right)
    {

        int pivot = input[right];
        int i = left;
        int j = right - 1;

        while(j >= i)
        {
            if (input[j] < pivot)
            {
                ArrayUtil.swap(input, i, j);
                i++;
            }
            else {
                j--;
            }
        }

        ArrayUtil.swap(input, i, right);
        return i;
    }
    public static void quickSort(int[] input, int left, int right)
    {
        if(right > left) {
            int pivotIndex = partition(input, left, right);

            quickSort(input, left, pivotIndex - 1);
            quickSort(input, pivotIndex + 1, right);
        }
    }
}
