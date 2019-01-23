package trees;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kader.belli on 24.12.2018.
 */
class TreeOperations{
    
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
//        Node node = constructBinaryTree();
//        System.out.println(treeHeight(node));
//        preOrderTraversal(node);
//        System.out.println();
//        preOrderTraversalIterative(node);
//
//        Node heap = binaryTreeArraySort(constructUnbalancedBinaryTree());
//        preOrderTraversal(heap);
//        System.out.println();
        
        Node tree = readTreeFromConsole();
        AtomicInteger diameter = new AtomicInteger(0);
        treeDiameter(tree, diameter);
        System.out.println("Tree diameter: " + diameter.get());
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
/*    5 1
    L
    2
    R
    3
    LL
    4
    LR
    5*/
    private static Node readTreeFromConsole(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int value = scanner.nextInt();
    
        TreeMap<String, Integer> map = new TreeMap<>();
        Node node = new Node(value);
        for(int i = 1; i < n; i++)
            map.put(scanner.next(), scanner.nextInt());
        
        map.forEach((strPath, val) -> {
            char[] path = strPath.toCharArray();
            Node current = node;
            int j;
            for(j = 0; j < path.length - 1; j++)
            {
                char c = path[j];
                if(c == 'L')
                    current = current.getLeft();
                else
                    current = current.getRight();
            }

            if(path[j] == 'L') current.setLeft(new Node(value));
            else current.setRight(new Node(value));
        });
        
        return node;
    }
    
    public static int treeDiameter(Node node, AtomicInteger maxPathLength)
    {
        if(node == null)
            return 0;
        int leftDiameter = treeDiameter(node.getLeft(), maxPathLength);
        int rightDiameter = treeDiameter(node.getRight(), maxPathLength);
        if(rightDiameter + leftDiameter + 1> maxPathLength.get())
            maxPathLength.set(rightDiameter + leftDiameter + 1);
        return  Math.max(rightDiameter, leftDiameter) + 1;
    }
    

}
