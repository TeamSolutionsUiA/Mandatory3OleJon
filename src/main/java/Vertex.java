
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
        if(this.edges.containsKey(vertex)){
            if(edge.getWeight() < this.edges.get(vertex).getWeight()){
                this.edges.replace(vertex, edge);
            }
        } else {
            this.edges.put(vertex, edge);
        }
    }
    
    public String getLocationName(){
        return locationName;
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