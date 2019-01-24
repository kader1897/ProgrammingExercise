package trees;

import util.HeapUtil;

import java.util.Scanner;

import static util.HeapUtil.add;
import static util.HeapUtil.buildMaxHeap;

/**
 * Created by kader.belli on 24.01.2019.
 */
public class HeapExample{
    public static void main(String args[] ){

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i;
        int[] arr = new int[n];
        for(i = 0; i < n; i++)
            arr[i] = s.nextInt();
        
        buildMaxHeap(arr);
        
        int q = s.nextInt();
        for(i = 0; i < q; i++)
        {
            int action = s.nextInt();
            if(action == 1)
            {
                // Add x
                int x = s.nextInt();
                arr = add(arr, x);
            }
            else
            {
                // Max
                System.out.println(arr[0]);
            }
        }
    }
}
