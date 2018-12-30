package trees;

import java.util.*;

/**
 * Created by kader.belli on 24.12.2018.
 */
public class TreeOperations{
    
    private static int treeHeight(Node node)
    {
        if(node == null)
            return 0;
        return 1 + Math.max(treeHeight(node.getLeft()), treeHeight(node.getRight()));
    }
    
    private static void preOrderTraversal(Node node)
    {
        if(node != null)
        {
            System.out.print(node.getValue() + " ");
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
        }
    }
    
    private static void preOrderTraversalIterative(Node node)
    {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty())
        {
            Node n = stack.pop();
            System.out.print(n.getValue() + " ");
            if(n.getRight()!=null)
                stack.push(n.getRight());
            if(n.getLeft()!=null)
                stack.push(n.getLeft());
        }
        System.out.println();
    }
    
    private static int numberOfNodes(Node node)
    {
        if(node == null)
            return 0;
        return 1 + numberOfNodes(node.getLeft()) + numberOfNodes(node.getRight());
    }
    
    
    private static Node binaryTreeArraySort(Node node)
    {
        int n = numberOfNodes(node);
        Node[] arr = new Node[n];
        int i = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty())
        {
            Node curr = queue.poll();
            arr[i++] = curr;
            if(curr.getLeft() != null)
                queue.add(curr.getLeft());
            if(curr.getRight() != null)
                queue.add(curr.getRight());
        }
    
        Arrays.sort(arr, Comparator.comparingInt(Node::getValue));
        for(i = 0; i < n; i++)
        {
            Node curr = arr[i];
            if(2*i + 1 < n)
                curr.setLeft(arr[2*i + 1]);
            else
                curr.setLeft(null);
            if(2*i + 2 < n)
                curr.setRight(arr[2*i + 2]);
            else
                curr.setRight(null);
        }
        
        return arr[0];
    }
    public static void main(String[] args)
    {
        Node node = constructBinaryTree();
        System.out.println(treeHeight(node));
        preOrderTraversal(node);
        System.out.println();
        preOrderTraversalIterative(node);
        
        Node heap = binaryTreeArraySort(constructUnbalancedBinaryTree());
        preOrderTraversal(heap);
        System.out.println();
    }
    
    private static Node constructBinaryTree()
    {
        Node node = new Node(100);
        Node leftNode = new Node(50);
        leftNode.setLeft(new Node(25));
        leftNode.setRight(new Node(75));
        node.setLeft(leftNode);
    
        Node rightNode = new Node(150);
        rightNode.setLeft(new Node(125));
        rightNode.setRight(new Node(175));
        rightNode.getLeft().setLeft(new Node(110));
        node.setRight(rightNode);
        
        return node;
    }
    
    private static Node constructUnbalancedBinaryTree()
    {
        Node node = new Node(20);
        Node leftNode = new Node(8);
        leftNode.setLeft(new Node(4));
        leftNode.setRight(new Node(12));
        leftNode.getRight().setLeft(new Node(10));
        leftNode.getRight().setRight(new Node(14));
        node.setLeft(leftNode);
        
        Node rightNode = new Node(22);
        node.setRight(rightNode);
        return node;
    }
}
