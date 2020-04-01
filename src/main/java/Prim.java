
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathans (https://www.baeldung.com/java-prim-algorithm, 
 * https://github.com/eugenp/tutorials/blob/master/algorithms-miscellaneous-5/src/main/java/com/baeldung/algorithms/prim/Prim.java)
 */
public class Prim {
    
    private List<Vertex> graph;

    public void run() {
        if(graph.size() > 0) {
            graph.get(0).setVisited(true);
        }
        while(isDisconnected()){
            Edge nextMinimum = new Edge(Integer.MAX_VALUE);
            Vertex nextVertex = graph.get(0);
            for(Vertex vertex : graph) {
                if(vertex.isVisited()) {
                    Pair<Vertex, Edge> candidate = vertex.nextMinimum();
                    if(candidate.getEdge().getWeight() < nextMinimum.getWeight()) {
                        nextMinimum= candidate.getEdge();
                        nextVertex = candidate.getVertex();
                    }
                }
            }
            nextMinimum.setIncluded(true);
            nextVertex.setVisited(true);
        }
    }
    private boolean isDisconnected(){
        for(Vertex vertex : graph) {
                if(!vertex.isVisited()) {
                    return true;
                }
        }
            return false;
    }
    
}