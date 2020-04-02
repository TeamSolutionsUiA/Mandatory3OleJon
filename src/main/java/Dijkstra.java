
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
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
public class Dijkstra {

    public static ConnectionGraph calculateShortestPathFromSource(ConnectionGraph graph, Vertex source) {
        source.setDistance(0);

        Set<Vertex> settledVertices = new HashSet<>();
        Set<Vertex> unsettledVertices = new HashSet<>();

        unsettledVertices.add(source);

        while (unsettledVertices.size() != 0) {
            Vertex currentVertex = getLowestDistanceVertex(unsettledVertices);
            unsettledVertices.remove(currentVertex);
            for (Entry<Vertex, Edge> adjacencyPair
                    : currentVertex.getEdges().entrySet()) {
                Vertex adjacentVertex = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue().getWeight();
                if (!settledVertices.contains(adjacentVertex)) {
                    calculateMinimumDistance(adjacentVertex, edgeWeight, currentVertex);
                    unsettledVertices.add(adjacentVertex);
                }
            }
            settledVertices.add(currentVertex);
        }
        return graph;
    }

    private static Vertex getLowestDistanceVertex(Set< Vertex> unsettledVertices) {
        Vertex lowestDistanceVertex = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Vertex vertex : unsettledVertices) {
            int vertexDistance = vertex.getDistance();
            if (vertexDistance < lowestDistance) {
                lowestDistance = vertexDistance;
                lowestDistanceVertex = vertex;
            }
        }
        return lowestDistanceVertex;
    }

    private static void calculateMinimumDistance(Vertex evaluationVertex,
            Integer edgeWeight, Vertex sourceVertex) {
        Integer sourceDistance = sourceVertex.getDistance();
        if (sourceDistance + edgeWeight < evaluationVertex.getDistance()) {
            evaluationVertex.setDistance(sourceDistance + edgeWeight);
            LinkedList<Vertex> shortestPath = new LinkedList<>(sourceVertex.getShortestPath());
            shortestPath.add(sourceVertex);
            evaluationVertex.setShortestPath(shortestPath);
        }
    }
}
