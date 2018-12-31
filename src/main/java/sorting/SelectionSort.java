package sorting;

class SelectionSort {

    public static void selectionSort(int[] input, int index)
    {
        if(index >= input.length)
            return;

        int value = input[index];
        int minIndex = index;
        for(int i = index; i < input.length; i++)
        {
            if(input[i] < value)
            {
                value = input[i];
                minIndex = i;
            }
        }

        input[minIndex] = input[index];
        input[index] = value;
        selectionSort(input, index+1);
    }

    public static void selectionSortIterative(int[] input)
    {
        for (int i = 0; i < input.length; i++) {
            int value = input[i];
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if(input[j] < value)
                {
                    value = input[j];
                    minIndex = j;
                }
            }

            input[minIndex] = input[i];
            input[i] = value;
        }
    }
}
