package trees;

import java.util.Scanner;

/**
 * Created by kader.belli on 23.01.2019.
 */
public class BinarySearchTree{
    public static void main(String args[]) throws Exception{
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */
        
        // Write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Node tree = new Node(s.nextInt());
        for(int i = 1; i < n; i++)
        {
            insertBST(tree, s.nextInt());
        }
        
        int q = s.nextInt();
        Node node = binarySearch(tree, q);
        preOrderTraversal(node);
        
    }
    
    private static void insertBST(Node node, int value){
        Node current = node;
        while(current != null)
        {
            if(value <= current.getValue())
            {
                if(current.getLeft() == null)
                {
                    current.setLeft(new Node(value));
                    return;
                }
                else
                {
                    current = current.getLeft();
                }
            }
            else
            {
                if(current.getRight() == null)
                {
                    current.setRight(new Node(value));
                    return;
                }
                else
                {
                    current = current.getRight();
                }
            }
        }
    }
    
    private static Node binarySearch(Node n, int value){
        if(value == n.getValue())
        {
            return n;
        }
    
        if(value < n.getValue())
        {
            return binarySearch(n.getLeft(), value);
        }
        
        return binarySearch(n.getRight(), value);
    }
    
    private static void preOrderTraversal(Node node){
        if(node != null)
        {
            System.out.print(node.getValue() + " ");
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
        }
    }
}
