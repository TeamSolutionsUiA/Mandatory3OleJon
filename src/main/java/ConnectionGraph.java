
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathans
 */
public class ConnectionGraph {
 
    private Set<Vertex> vertices;
    
    public ConnectionGraph() {
        vertices = new HashSet<>();
    }
    
    List<Vertex> getVertices() {
        return new ArrayList<>(vertices);
    }
    
    boolean addVertex(Vertex vertex){
        return vertices.add(vertex);
    }
    public void printShortestPath(){
        for(Vertex vertex : vertices){
            System.out.print("\n Shortest path to vertex " + vertex.getLocationName() + ": ");
            for(Vertex v : vertex.getShortestPath()){
                System.out.print(v.getLocationName() + " --> ");
                
            }
            System.out.print(vertex.getLocationName() + " distance: "+ vertex.getDistance());
            
        }
    }
}