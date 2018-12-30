package util;

public class ArrayUtil {
    public static void printArray(int[] array)
    {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void swap(int[] array, int i1, int i2)
    {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;

    }
    public static int[] sampleUnorderedArray()
    {
        return new int[]{7,5,3,8,4,3,9,10,2};
    }
}
