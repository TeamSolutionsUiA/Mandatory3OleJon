
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
       // A:
       Edge ab = new Edge(10);
       a.addEdge(b,ab);
       b.addEdge(a,ab);
       Edge ac = new Edge(5);
       a.addEdge(c,ac);
       c.addEdge(a,ac);
       Edge ad = new Edge(9999);
       a.addEdge(d, ad);
       d.addEdge(a,ad);
       Edge ae = new Edge(3);
       a.addEdge(e, ae);
       e.addEdge(a, ae);
       Edge af = new Edge(12);
       a.addEdge(f, af);
       f.addEdge(a,af);
       //B:
       Edge bc = new Edge(17);
       b.addEdge(c,bc);
       c.addEdge(b,bc);
       Edge bd = new Edge(9);
       b.addEdge(d,bd);
       d.addEdge(b,bd);
       Edge be = new Edge(17);
       b.addEdge(e,be);
       e.addEdge(b,be);
       Edge bf = new Edge(12);
       b.addEdge(f,bf);
       f.addEdge(b,bf);
       //C:
       Edge cd = new Edge(35);
       c.addEdge(d,cd);
       d.addEdge(c,cd);
       Edge ce = new Edge(3);
       c.addEdge(e,ce);
       e.addEdge(c,ce);
       Edge cf = new Edge(12);
       c.addEdge(f,cf);
       f.addEdge(c,cf);
       //D:
       Edge de = new Edge(9999);
       d.addEdge(e,de);
       e.addEdge(d,de);
       Edge df = new Edge(12);
       d.addEdge(f, df);
       f.addEdge(d,df);
       //E:
       Edge ef = new Edge(12);
       e.addEdge(f, ef);
       f.addEdge(e, ef);

        //Add all vertices to the graph:
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);
    
        // Make new graph based on the original one, and run the prim algorithm 
        // to get a new graph connected with the minimum total cost.
        List<Vertex> vertices = graph.getVertices();
        Prim prim = new Prim(vertices);
        prim.run();
        
        //Print original graph:
        System.out.print("Original graph:\n" + prim.graphToString(true) + "\n");
        
        //Print minimum spanning Tree (minimum cost graph):
        prim.resetPrintHistory();
        System.out.print("Minimum spanning Tree:\n" + prim.graphToString(false)); 
        
        }  
    } 
