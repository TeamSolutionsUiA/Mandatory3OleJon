/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathans
 */
public class Edge {
    
    private final int weight;
    private boolean isIncluded;
    private boolean isPrinted;

    public boolean isPrinted() {
        return isPrinted;
    }

    public void setIsPrinted(boolean isPrinted) {
        this.isPrinted = isPrinted;
    }

    public Edge(int weight) {
        super();
        this.weight = weight;
    }
    
    public int getWeight() {
        return weight;
    }
    public void setIncluded(boolean included) {
        isIncluded = included;
    }
    public boolean isIncluded() {
        return isIncluded;
    }
    
}
