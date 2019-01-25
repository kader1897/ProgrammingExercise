package trees;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kader.belli on 25.01.2019.
 */
public class TrieTree{
    
    public static void main(String args[] ) throws Exception {
        
        //Scanner
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
    
        TrieNode root = new TrieNode();
        int i, j;
        for(i = 0; i < n; i++)
        {
            TrieNode current = root;
            char[] arr = s.next().trim().toCharArray();
            int value = s.nextInt();
            for(j = 0; j < arr.length - 1; j++)
            {
                char c = arr[j];
                int index = charToIndex(c);
                if(current.children[index] == null)
                {
                    TrieNode node = new TrieNode(c, null);
                    current.children[index] = node;
                    current = node;
                }
                else
                {
                    current = current.children[index];
                }
            }
            
            char c = arr[j];
            int index = charToIndex(c);
            TrieNode node = current.children[index];
            if(node == null)
            {
                current.children[index] = new TrieNode(c, value);
            }
            else if(node.weight < value)
            {
                node.weight = value;
            }
        }
        
        queryExecution:
        for(i = 0; i < q; i++)
        {
            char[] query = s.next().trim().toCharArray();
            TrieNode current = root;
            for(char c : query)
            {
                int index = charToIndex(c);
                TrieNode node = current.children[index];
                if(node == null)
                {
                    System.out.println(-1);
                    continue queryExecution;
                }
                current = node;
            }
            
            AtomicInteger maxPriority = new AtomicInteger(-1);
            findMaxPriorityString(current, maxPriority);
            System.out.println(maxPriority.get());
        }
    }
    
    private static int charToIndex(char c)
    {
        return c - 'a';
    }
    
    private static void findMaxPriorityString(TrieNode node, AtomicInteger maxPriority)
    {
        if(node.weight != null && node.weight > maxPriority.get())
            maxPriority.set(node.weight);
        for(TrieNode n : node.children)
        {
            if(n != null)
                findMaxPriorityString(n, maxPriority);
        }
    }
}

class TrieNode{
    
    final int numLetters = 'z' - 'a' + 1;
    Character value;
    Integer weight;
    TrieNode[] children;
    
    TrieNode(Character value, Integer weight)
    {
        this.value = value;
        this.weight = weight;
        this.children = new TrieNode[numLetters];
    }
    
    TrieNode()
    {
        this.value = null;
        this.weight = null;
        this.children = new TrieNode[numLetters];
    }
}
