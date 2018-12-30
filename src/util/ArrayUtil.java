package util;

public class ArrayUtil {
    public static void printArray(int[] array)
    {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] sampleUnorderedArray()
    {
        int[] array = {7,5,3,8,4,3,9,10,2};
        return array;
    }
}
