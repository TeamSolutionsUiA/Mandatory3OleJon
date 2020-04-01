
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathans
 */
public class InternetLocationsMain {

    public static void main(String[] args) {

        ConnectionGraph graph = new ConnectionGraph();

        //construct vertices 
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        
       // Adding all possible edges to each vertex. connection is going both ways,
       //because it is not directed:
       Edge ab = new Edge(10);
       Edge ba = new Edge(10);
       a.addEdge(b,ab);
       b.addEdge(a,ba);
       Edge bc = new Edge(17);
       

        //to make the graph undirected use the same weight 
        //both ways 
        // Every vertex can connect to itself, with the weigth(cost) of 0:
        //Connect A:
        /*a.addEdge(new Edge(a, 0));

        a.addEdge(new Edge(b, 10));
        b.addEdge(new Edge(a, 10));

        a.addEdge(new Edge(c, 5));
        c.addEdge(new Edge(a, 5));

        a.addEdge(new Edge(d, 9999));
        d.addEdge(new Edge(a, 9999));

        a.addEdge(new Edge(e, 3));
        e.addEdge(new Edge(a, 3));

        a.addEdge(new Edge(f, 12));
        f.addEdge(new Edge(a, 12));

        // Connect B:
        b.addEdge(new Edge(b, 0));

        b.addEdge(new Edge(c, 17));
        c.addEdge(new Edge(b, 17));

        b.addEdge(new Edge(d, 9));
        d.addEdge(new Edge(b, 9));

        b.addEdge(new Edge(e, 17));
        e.addEdge(new Edge(b, 17));

        b.addEdge(new Edge(f, 12));
        f.addEdge(new Edge(b, 12));

        // Connect C:
        c.addEdge(new Edge(c, 0));

        c.addEdge(new Edge(d, 35));
        d.addEdge(new Edge(c, 35));

        c.addEdge(new Edge(e, 3));
        e.addEdge(new Edge(c, 3));

        c.addEdge(new Edge(f, 12));
        f.addEdge(new Edge(c, 12));

        //Connect D:
        d.addEdge(new Edge(d, 0));

        d.addEdge(new Edge(e, 99));
        e.addEdge(new Edge(d, 99));

        d.addEdge(new Edge(f, 12));
        f.addEdge(new Edge(d, 12));

        //Connect E:
        e.addEdge(new Edge(e, 0));

        e.addEdge(new Edge(f, 12));
        f.addEdge(new Edge(e, 12));

        //Connect F to itself:
        f.addEdge(new Edge(f, 0));*/

        //Add all vertices to graph:
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);
    
        // Print all vertices with cost of all possible connections: 
        List<Vertex> vertices = graph.getVertices();
        System.out.println("All Vertices with all possible connections: ");
        for(Vertex vertex : vertices){
            vertex.print();
        }  
    } 
}