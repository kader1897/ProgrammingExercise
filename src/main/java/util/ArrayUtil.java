package util;

public class ArrayUtil {
    
    private ArrayUtil(){}
    
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
    
    public static int[] sampleOrderedArray()
    {
        return new int[]{2,3,3,4,5,7,8,9,10};
    }
    
    public static int[] sampleReverseOrderedArray()
    {
        return new int[]{10,9,8,7,5,4,3,3,2};
    }
    
    public static int[] singleElementArray()
    {
        return new int[]{83};
    }
    
    public static int[] twoElementArray()
    {
        return new int[]{73,54};
    }
    
    public static int[] twoElementOrderedArray()
    {
        return new int[]{54,73};
    }
}
