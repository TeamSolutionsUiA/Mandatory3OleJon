
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Node;

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
    
    private String locationName;
    private Map<Vertex, Edge> edges;
    private boolean isVisited;
    private List<Vertex> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;
    //private Map<Node, Integer> adjacentNodes = new HashMap<>(); 
    
    public Vertex(String locationName) {
        this.locationName = locationName;
        edges = new HashMap<>();
    }
   
    public void addEdge(Vertex vertex, Edge edge){
        if(this.edges.containsKey(vertex)){
            if(edge.getWeight() < this.edges.get(vertex).getWeight()){
                this.edges.replace(vertex, edge);
            }
        } else {
            this.edges.put(vertex, edge);
        }
    }
    
    public void addDestination(Vertex destination, int distance) {
        addEdge(destination, new Edge(distance));
    }
    
    public String getLocationName(){
        return locationName;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<Vertex> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Vertex> shortestPath) {
        this.shortestPath = shortestPath;
    }
    
    public String originalToString(){
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<Vertex,Edge>> it = edges.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Vertex,Edge> pair = it.next();
            if (!pair.getValue().isPrinted()) {
                sb.append("[");
                sb.append(getLocationName());
                sb.append(" ");
                sb.append(pair.getKey().getLocationName());
                sb.append("] ");
                sb.append(pair.getValue().getWeight());
                sb.append("\n");
                pair.getValue().setIsPrinted(true);
            }
        }
        return sb.toString();
    }

    public String includedToString(){
        StringBuilder sb = new StringBuilder();
        if (isVisited()) {
            Iterator<Map.Entry<Vertex,Edge>> it = edges.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Vertex,Edge> pair = it.next();
                if (pair.getValue().isIncluded()) {
                    if (!pair.getValue().isPrinted()) {
                        sb.append("[");
                        sb.append(getLocationName());
                        sb.append(" ");
                        sb.append(pair.getKey().getLocationName());
                        sb.append("] ");
                        sb.append(pair.getValue().getWeight());
                        sb.append("\n");
                        pair.getValue().setIsPrinted(true);
                    }
                }
            }
        }
        return sb.toString();
    }

    public Map<Vertex, Edge> getEdges() {
        return edges;
    }

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