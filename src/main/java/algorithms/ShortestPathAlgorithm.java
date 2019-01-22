package algorithms;

import java.util.*;

/**
 * Created by kader.belli on 22.01.2019.
 */
public class ShortestPathAlgorithm{
    public static void main(String args[] ) throws Exception {
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
        int N = s.nextInt();
        int M = s.nextInt();
        int i, from, to, w;
        
        PriorityQueue<Vertex> queue = new PriorityQueue();
        
        Vertex[] vertices = new Vertex[N];
        for(i = 0; i < vertices.length; i++)
        {
            vertices[i] = new Vertex(i+1);
        }
        
        for(i = 0; i < M; i++)
        {
            from = s.nextInt() - 1;
            to = s.nextInt() - 1;
            w = s.nextInt();
            
            Edge edge = new Edge(vertices[from], vertices[to], w);
        }
        
        vertices[0].dist = 0;
        queue.add(vertices[0]);
        
        while(!queue.isEmpty())
        {
            Vertex current = queue.poll();
            current.visited = true;
            
            for(Edge e : current.edges)
            {
                Vertex t = e.to;
                if(t.visited)
                    continue;
                if(t.dist > e.weight + current.dist)
                    t.dist = e.weight + current.dist;
                
                queue.add(t);
            }
        }
        
        for(i = 1; i < N; i++)
        {
            System.out.print(vertices[i].dist + " ");
        }
        
    }
}

class Vertex implements Comparable{
    int id;
    List<Edge> edges;
    boolean visited;
    long dist;
    
    Vertex(int id)
    {
        this.id = id;
        this.edges = new ArrayList<>();
        this.visited = false;
        this.dist = Long.MAX_VALUE;
    }
    
    
    @Override
    public int compareTo(Object o){
        return (int) (this.dist - ((Vertex) o).dist);
    }
}

class Edge{
    Vertex from;
    Vertex to;
    int weight;
    
    Edge(Vertex from, Vertex to, int weight)
    {
        this.from = from;
        this.to = to;
        this.weight = weight;
        from.edges.add(this);
    }
}
