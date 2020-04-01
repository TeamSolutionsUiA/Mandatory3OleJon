/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathans
 */
public class Pair<V, E> {

    private final V vertex;
    private final E edge;

    public static <V, E> Pair<V, E> createPair(V vertex, E edge) {
        return new Pair<V, E>(vertex, edge);
    }

    public Pair(V vertex, E edge) {
        this.vertex = vertex;
        this.edge = edge;
    }

    public V getVertex() {
        return vertex;
    }

    public E getEdge() {
        return edge;
    }

}
