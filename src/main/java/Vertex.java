
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathans
 */
public class Vertex {
    
    private final String locationName;
    private Map<Vertex, Edge> edges;
    private boolean isVisited;
    
    public Vertex(String locationName) {
        this.locationName = locationName;
        edges = new HashMap<>();
    }

    public void addEdge(Vertex vertex, Edge edge){
        edges.put(vertex, edge);
    }
    
    public String getLocationName(){
        return locationName;
    }
    
   /* public void print(){
        System.out.println("Location " + locationName + " :");
        System.out.println("All connections possible with connection cost: ");
        for(Edge edge : edges){
            Vertex destination = edge.getDestinationPoint();
            System.out.println("Destination: " + destination.getLocationName() 
                                + " Connection Cost: " + edge.getWeight());
        }
    }
*/
    
    public void setVisited(boolean isVisited){
        this.isVisited = isVisited;
    }
    
    public boolean isVisited(){
        return isVisited;
    }
    
    public Pair<Vertex, Edge> nextMinimum() {
        Edge nextMinimum = new Edge(Integer.MAX_VALUE);
        Vertex nextVertex = this;
        Iterator<Map.Entry<Vertex, Edge>> it = edges.entrySet()
                .iterator();
        while(it.hasNext()){
            Map.Entry<Vertex, Edge> pair = it.next();
            if(!pair.getKey().isVisited()) {
                if(!pair.getValue().isIncluded()) {
                    if(pair.getValue().getWeight() < nextMinimum.getWeight()) {
                        nextMinimum = pair.getValue();
                        nextVertex = pair.getKey();
                    }
                }
            }
        }
        return new Pair<>(nextVertex, nextMinimum);
    }
}