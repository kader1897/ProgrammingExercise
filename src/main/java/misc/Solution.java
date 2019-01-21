package misc;

/**
 * Created by kader.belli on 21.01.2019.
 */
public class Solution {
    public static void main(String[] args){
        String[] words = {"xxbxxx", "xbx", "x"};
//        String[] words = {"xxbbbbbbbbbbxx", "xbx", "x"};
//        String[] words = {"bb", "cc", "dd", "bb"};
//        String[] words = {"aabb", "bba", "abb"};

        System.out.println(longestCharSequence(words));
    }
    
    public static int longestCharSequence(String[] words)
    {
        int numLetters = 'z' - 'a' + 1;
        // 0 -> bestStart
        // 1 -> bestEnd
        // 2 -> secondStart
        // 3 -> secondEnd
        // 4 -> middle
        // 5 -> inside
        // 6 -> bestStartIndex
        // 7 -> bestEndIndex
        // 8 -> secondStartIndex
        // 9 -> secondEndIndex
        
        int[][] table = new int[numLetters][10];
        
        for(int index = 0; index < words.length; index++)
        {
            char[] arr = words[index].toCharArray();
            char start = arr[0];
            int sCount = 1;
            int i,j, n = arr.length;
            for(i = 1; i < n; i++)
            {
                if(arr[i] == start)
                    sCount++;
                else break;
            }
            
            if(sCount == n)
            {
                table[start - 'a'][4] += sCount;
            }
            else
            {
                char end = arr[n-1];
                int eCount = 1;
                for(j = arr.length - 2; j >= 0; j--)
                {
                    if(arr[j] == end)
                        eCount++;
                    else break;
                }
                
                if(sCount > table[start - 'a'][0])
                {
                    table[start - 'a'][2] = table[start - 'a'][0];
                    table[start - 'a'][8] = table[start - 'a'][6];
                    table[start - 'a'][0] = sCount;
                    table[start - 'a'][6] = index;
                }
                else if(sCount > table[start - 'a'][2])
                {
                    table[start - 'a'][2] = sCount;
                    table[start - 'a'][8] = index;
                }
    
                if(eCount > table[end - 'a'][1])
                {
                    table[end - 'a'][3] = table[end - 'a'][1];
                    table[end - 'a'][9] = table[end - 'a'][7];
                    table[end - 'a'][1] = eCount;
                    table[end - 'a'][7] = index;
                }
                else if(eCount > table[end - 'a'][3])
                {
                    table[end - 'a'][3] = eCount;
                    table[end - 'a'][9] = index;
                }
                
                if(j >= i)
                {
                    char c = arr[i];
                    int counter = 1;
    
    
                    for(int k = i + 1; k <= j; k++)
                    {
                        if(arr[k] == c)
                            counter++;
                        else {
                            if(counter > table[c-'a'][5])
                                table[c - 'a'][5] = counter;
                            
                            c = arr[k];
                            counter = 1;
                        }
                    }
                    
                    if(counter > table[c-'a'][5])
                        table[c - 'a'][5] = counter;
                }
            }
        }
        
        int maxValue = 0;
        for(int i = 0; i < numLetters; i++)
        {
            int inside  = table[i][5];
            int value = table[i][0] + table[i][1];
            if(table[i][6] == table[i][7])
            {
                int value1 = table[i][0] + table[i][3];
                int value2 = table[i][1] + table[i][2];
                value = Math.max(value1, value2);
            }
            value += table[i][4];
            
            if(inside > value)
                value = inside;
            
            if(value > maxValue )
                maxValue = value;
        }
        
        return maxValue;
    }
}
